package com..rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author beskorovajny
 */
public class Part5 implements Callable<Object> {
    private static final Logger LOGGER = Logger.getLogger(Part5.class.getName());

    private static final Object MONITOR = new Object();

    private static final int THREADS = 10;
    private static final int COLUMNS = 20;

    private final RandomAccessFile randomAccessFile;

    private final String characters;
    private final int position;


    public Part5(RandomAccessFile out, int position, String charactersToFill, int stringLength) {
        this.randomAccessFile = out;
        this.position = position;

        StringBuilder sb = new StringBuilder(stringLength);
        for (int i = 0; i < COLUMNS; i++) {
            sb.append(charactersToFill);
        }
        sb.append(System.lineSeparator());
        characters = sb.toString();
    }

    @Override
    public Object call() throws IOException {
        RandomAccessFile raf = getRandomAccessFile();
        synchronized (MONITOR) {
            raf.seek(position);
            raf.write(characters.getBytes(StandardCharsets.UTF_8));
        }
        return null;
    }

    private RandomAccessFile getRandomAccessFile() {
        return randomAccessFile;
    }

    public static void main(String[] args) {
        try {
            Files.deleteIfExists(new File("part5.txt").toPath());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
        }
        File file = new File("part5.txt");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {

            ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

            ArrayList<Future<Object>> futureArrayList = new ArrayList<>();

            int position = 0;
            for (int currentNumber = 0; currentNumber < THREADS; currentNumber++) {
                String charToFill = String.valueOf(currentNumber);
                int charsLength = COLUMNS * charToFill.length();
                int stringLength = charsLength + System.lineSeparator().length();

                Future<Object> objectFuture = executorService.submit(new Part5(randomAccessFile,
                                                                    position,
                                                                    charToFill,
                                                                    stringLength));
                futureArrayList.add(objectFuture);

                position += stringLength;
            }

            for (Future<Object> future : futureArrayList) {
                future.get();
            }

            executorService.shutdown();

            System.out.print(new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8));

        } catch (IOException | InterruptedException | ExecutionException e) {
            LOGGER.log(Level.SEVERE, Demo.EXCEPTION_MESSAGE, e);
            Thread.currentThread().interrupt();
        }


    }
}
