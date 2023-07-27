package com.api.codeassessmentapi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.quera.problem.WaterCalculation.startCalculation;

public class WaterCalculationTest {

    @Test
    public void testWaterCalculation() {
        assertEquals(startCalculation(new int[]{4, 1, 3, 5, 2, 3, 4}), 7);
        assertEquals(startCalculation(new int[]{5, 2, 3, 1, 2, 7, 4, 3, 9, 5}), 19);
        assertEquals(startCalculation(new int[]{2, 5, 3, 1, 8, 3, 2, 6, 4, 1}), 13);
        assertEquals(startCalculation(new int[]{4, 2, 6, 3, 1, 1, 4, 2, 1, 3, 2}), 12);
        assertEquals(startCalculation(new int[]{5, 1, 2, 3, 4, 5, 2, 4}), 12);
        assertEquals(startCalculation(new int[]{2, 3, 1, 5}), 2);
        assertEquals(startCalculation(new int[]{2, 3, 1, 1, 4, 2, 1, 3, 6, 2}), 10);
        assertEquals(startCalculation(new int[]{8}), 0);
        assertEquals(startCalculation(new int[]{10, 15}), 0);
        assertEquals(startCalculation(new int[]{10, 8, 11}), 2);
    }
}