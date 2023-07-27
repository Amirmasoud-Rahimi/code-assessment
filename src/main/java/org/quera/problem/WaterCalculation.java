package org.quera.problem;

import java.util.Scanner;

public class WaterCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter Building Counts : ");
        int buildingCount = scanner.nextInt();
        int[] heights = new int[buildingCount];
        System.out.print("Please Enter Building heights with space (ex: 1 2 3): ");
        for (int i = 0; i < buildingCount; i++) {
            if (scanner.hasNextInt()) {
                heights[i] = scanner.nextInt();
            }
        }
        System.out.println("Water (m2)= " + startCalculation(heights));
    }

    public static int startCalculation(int[] heights) {
        int firstResult = leftToRightCalculation(heights);
        int secondResult = rightToLeftCalculation(heights);
        return firstResult + secondResult;
    }

    private static int leftToRightCalculation(int[] heights) {
        int result = 0, i = 0, start = 0, end = 1;

        while (i < heights.length) {
            for (i = end; i < heights.length; i++) {
                if (heights[start] <= heights[i]) {
                    for (int k = start; k < i; k++) {
                        result += Math.max(heights[start] - heights[k + 1], 0);
                    }
                    break;
                }
            }
            start = i;
            end = i + 1;
        }
        return result;
    }

    private static int rightToLeftCalculation(int[] heights) {
        int result = 0, i = 0, start = heights.length - 1, end = heights.length - 2;

        while (i >= 0) {
            for (i = end; i >= 0; i--) {
                if (heights[start] < heights[i]) {
                    for (int k = start; k > i; k--) {
                        result = Math.max(heights[start] - heights[k - 1], 0) + result;
                    }
                    break;
                }
            }
            start = i;
            end = i - 1;
        }
        return result;
    }
}