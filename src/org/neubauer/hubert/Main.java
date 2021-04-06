package org.neubauer.hubert;

import java.util.Random;

/**
 * How it works:
 * we generate 2 numbers from 0 to 1, and check whether they are within a circle or radius 0.5
 * if they are, they're a hit and we count it, if it's not just go to next one
 * once done, multiply the result by 4 because
 * (area of circe) / (area of square) = 0.25 ~= (hits) / (total shots)
 * Ofc, it's just an approximation
 */

public class Main {

    public static void main(String[] args) {
        Random rng = new Random();

        double half = 0.5d;
        int size = Integer.MAX_VALUE;   //WARNING: it takes a while
        int hitCounter = 0;

        for (int i = 0; i < size; i++) {
            double x = rng.nextDouble();
            double y = rng.nextDouble();

            boolean tmp = Math.pow(x - half, 2) + Math.pow(y - half, 2) <= Math.pow(half, 2);
            if (tmp) {
                //System.out.println(hitCounter++);
                ++hitCounter;
            }
        }

        System.out.println("Total shots: " + size);
        System.out.println("Hits: " + hitCounter);
        Double paj = Double.parseDouble(String.valueOf(hitCounter)) / Double.parseDouble(String.valueOf(size)) * 4;
        System.out.println("Calculated PI: " + paj);
        System.out.println("Difference: " + Math.abs(Math.PI - paj));
    }
}
