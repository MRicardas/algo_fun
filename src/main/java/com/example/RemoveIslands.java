package com.example;

public class RemoveIslands {

    static int lx = 5;
    static int ly = 5;

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 1 },
                { 0, 0, 1, 0, 1, 0 },
                { 1, 1, 0, 0, 1, 0 },
                { 1, 0, 1, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 1 },
        };

        for (int y = 1; y < ly; y++) {
            for (int x = 1; x < lx; x++) {
                if (!isNotIsland(arr, y, x, -1)) {
                    arr[y][x] = 0;
                }
            }
        }

        System.out.println(" ");
        for (int y = 0; y <= ly; y++) {
            for (int x = 0; x <= lx; x++) {
                System.out.print(arr[y][x] + "  ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    static boolean isNotIsland(int arr[][], int y, int x, int direction) {

        if (arr[y][x] == 0) {
            return false;
        }

        if (x == lx || y == ly || x == 0 || y == 0) {
            if (arr[y][x] == 1) {
                return true;
            } else {
                return false;
            }
        }

        return (direction == 2 ? false : isNotIsland(arr, y - 1, x, 0)) ||
                (direction == 3 ? false : isNotIsland(arr, y, x + 1, 1)) ||
                (direction == 0 ? false : isNotIsland(arr, y + 1, x, 2)) ||
                (direction == 1 ? false : isNotIsland(arr, y, x - 1, 3));

    }
}