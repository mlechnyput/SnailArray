package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Vector;

public class Main {

   public static Vector<Integer> v = new Vector<>();

    public static void main(String[] args) throws IOException {
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        System.out.print("Enter n: ");
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * 100);
                System.out.printf("%3d", array[i][j]);
                if (j == n - 1) System.out.println();
            }
        }
        System.out.println();
        System.out.println(snailMeth(array));

    }

    public static Vector snailMeth(int[][] array) {
        int[] arrNew = new int[array.length * 4 - 4];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            arrNew[k] = array[0][i];
            k++;
        }
        for (int i = 1; i < array.length; i++) {
            arrNew[k] = array[i][array.length - 1];
            k++;
        }
        for (int i = array.length - 2; i >= 0; i--) {
            arrNew[k] = array[array.length - 1][i];
            k++;
        }
        for (int i = array.length - 2; i > 0; i--) {
            arrNew[k] = array[i][0];
            k++;
        }

        int[][] small = new int[array.length - 2][array.length - 2];
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - 1; j++) {
                small[i - 1][j - 1] = array[i][j];
            }
        }
        for (int i : arrNew)
            v.add(i);
        if (small.length == 0) return v;
        if (small.length == 1) {
            v.add(small[0][0]);
            return v;
        }
        snailMeth(small);

        return v;
    }

}
