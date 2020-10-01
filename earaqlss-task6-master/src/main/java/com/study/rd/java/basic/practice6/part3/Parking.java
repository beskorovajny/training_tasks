package com..rd.java.basic.practice6.part3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author beskorovajny
 */
public class Parking {
    private final List<Integer> parkingList;
    public Parking(int capacity) {
        parkingList = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            parkingList.add(0);
        }
    }
    
    public boolean arrive(int k) {
        boolean flag = false;

        if (k < 0 || k > parkingList.size()) {
            throw new IllegalArgumentException();
        }

        int i = 0;

        while(!flag && i != parkingList.size()){
            for(i = k; i < parkingList.size(); i++){
                if(parkingList.get(i) == 0) {
                    this.parkingList.set(i, 1);
                    flag = true;
                    break;
                }

            }
        }
        if(!flag) {
            for(int j = 0; j < k; j++) {
                if(parkingList.get(j)== 0) {
                    parkingList.set(j, 1);
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    
    public boolean depart(int k) {
        if (k < 0 || k > parkingList.size()) {
            throw new IllegalArgumentException();
        }
        if (parkingList.get(k) == 1) {
            parkingList.set(k, 0);
            return true;
        }
        return false;
    }
    
    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int vehicle : parkingList) {
            stringBuilder.append(vehicle);
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
