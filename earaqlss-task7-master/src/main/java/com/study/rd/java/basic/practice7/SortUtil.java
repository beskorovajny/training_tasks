package com..rd.java.basic.practice7;


import java.util.List;

/**
 * @author besko
 */
public class SortUtil {

    private SortUtil() {
    }

    public static void sortGunsByModel(Guns list) {
        List<Gun> toSort = list.getGunList();
        toSort.sort((o1, o2) -> o1.getModel().compareTo(o2.getModel()));

    }

    public static void sortGunsByOrigin(Guns list) {
        List<Gun> toSort = list.getGunList();
        toSort.sort((o1, o2) -> o1.getOrigin().compareTo(o2.getOrigin()));

    }

    public static void sortGunsByMaterial(Guns list) {
        List<Gun> toSort = list.getGunList();
        toSort.sort((o1, o2) -> o1.getMaterial().toString().compareTo(o2.getMaterial().toString()));

    }

}
