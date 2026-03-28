/*
 * RecursiveTester.java - CS 314 Assignment 7
 *
 * By signing my/our name(s) below, I/we affirm that this assignment is my/our
 * own work. I/we have neither given nor received unauthorized assistance on
 * this assignment.
 *
 * Name 1:
 * Email address 1:
 * UTEID 1:
 *
 * Name 2:
 * Email address 2:
 * UTEID 2:
 */

import java.util.ArrayList;

/**
 * Tester class for the methods in Recursive.java
 * 
 * @author scottm
 *
 */
public class RecursiveTester {

    // run the tests
    public static void main(String[] args) {
        //doNextIsDoubleTests();
        //doCarpetTest();
        //doFairTeamsTests();
        //doListMnemonicsTests();
        doFlowingWaterTests();
    }

    //TEMP TEST CASES DELETE
    private static void doListMnemonicsTests() {
        ArrayList<String> actual;
        int expectedSize;

        // Test 1: Example from prompt, 3 * 3 * 3 = 27 mnemonics
        actual = Recursive.listMnemonics("623");
        expectedSize = 27;
        showMnemonicResults(actual, expectedSize, "MAD", "OCF", 1);

        // Test 2: Single digit with 3 letters
        actual = Recursive.listMnemonics("2");
        expectedSize = 3;
        showMnemonicResults(actual, expectedSize, "A", "C", 2);

        // Test 3: Single digit with 4 letters (7 maps to PQRS)
        actual = Recursive.listMnemonics("7");
        expectedSize = 4;
        showMnemonicResults(actual, expectedSize, "P", "S", 3);

        // Test 4: Two digits, one with 3 letters and one with 4 letters = 12
        actual = Recursive.listMnemonics("27");
        expectedSize = 12;
        showMnemonicResults(actual, expectedSize, "AP", "CS", 4);

        // Test 6: Two digits with 4 letters each (7 and 9) = 16
        actual = Recursive.listMnemonics("79");
        expectedSize = 16;
        showMnemonicResults(actual, expectedSize, "PW", "SZ", 6);

        System.out.println();
    }

    private static void showMnemonicResults(ArrayList<String> actual, int expectedSize,
        String mustContain1, String mustContain2, int testNum) {

        boolean sizeCorrect = actual.size() == expectedSize;
        boolean containsFirst = actual.contains(mustContain1);
        boolean containsSecond = actual.contains(mustContain2);

        if (sizeCorrect && containsFirst && containsSecond) {
            System.out.println("Test " + testNum + " passed. list mnemonics.");
        } else {
            System.out.println("Test " + testNum + " failed. list mnemonics.");
            System.out.println("Expected size: " + expectedSize);
            System.out.println("Actual size  : " + actual.size());
            System.out.println("Contains \"" + mustContain1 + "\"? " + containsFirst);
            System.out.println("Contains \"" + mustContain2 + "\"? " + containsSecond);
            System.out.println("Actual list   : " + actual);
        } 
    }
    private static void doFlowingWaterTests() {
        boolean actual;
        boolean expected;

        // Test 1: Flat plain, edge cell should be true
        int[][] flatMap = {
            {100, 100, 100, 100},
            {100, 100, 100, 100},
            {100, 100, 100, 100},
            {100, 100, 100, 100}
        };
        actual = Recursive.canFlowOffMap(flatMap, 0, 2);
        expected = true;
        showFlowResults(actual, expected, 1);

        // Test 2: Flat plain, interior cell should be false
        actual = Recursive.canFlowOffMap(flatMap, 1, 1);
        expected = false;
        showFlowResults(actual, expected, 2);

        // Test 3: Interior cell with a direct downhill path to the edge
        int[][] downhillMap = {
            {200, 200, 200, 200, 200},
            {200,  99,  98,  97, 200},
            {200, 150,  96,  95,  94},
            {200, 200, 200, 200,  93}
        };
        // Start at 96 -> 95 -> 94 (edge) -> off map
        actual = Recursive.canFlowOffMap(downhillMap, 2, 2);
        expected = true;
        showFlowResults(actual, expected, 3);

        // Test 4: Higher cell that can flow into the river path
        // Start at 150 -> 96 -> 95 -> 94 -> edge
        actual = Recursive.canFlowOffMap(downhillMap, 2, 1);
        expected = true;
        showFlowResults(actual, expected, 4);

        // Test 5: Interior cell trapped by equal/higher elevations
        int[][] trappedMap = {
            {300, 300, 300, 300, 300},
            {300, 200, 200, 200, 300},
            {300, 200, 100, 200, 300},
            {300, 200, 200, 200, 300},
            {300, 300, 300, 300, 300}
        };
        // 100 is surrounded by higher cells, but no path reaches edge
        actual = Recursive.canFlowOffMap(trappedMap, 2, 2);
        expected = false;
        showFlowResults(actual, expected, 5);

        // Test 6: Equal elevations should NOT allow movement
        int[][] equalBlockMap = {
            {50, 50, 50},
            {50, 40, 40},
            {50, 50, 50}
        };
        // From (1,1)=40, can move to (1,2)=40? NO, equal not allowed
        // All others are higher, so trapped
        actual = Recursive.canFlowOffMap(equalBlockMap, 1, 1);
        expected = false;
        showFlowResults(actual, expected, 6);

        // Test 7: Single-cell map (edge cell automatically true)
        int[][] singleCellMap = {
            {42}
        };
        actual = Recursive.canFlowOffMap(singleCellMap, 0, 0);
        expected = true;
        showFlowResults(actual, expected, 7);

        // Test 8: Interior cell can choose among multiple paths, at least one succeeds
        int[][] branchMap = {
            { 9,  8,  7,  6},
            {10,  5, 20,  5},
            {11,  4,  3,  2},
            {12, 13, 14,  1}
        };
        // Start at 5 (1,1) -> 4 -> 3 -> 2 -> 1(edge)
        actual = Recursive.canFlowOffMap(branchMap, 1, 1);
        expected = true;
        showFlowResults(actual, expected, 8);

        System.out.println();
    }
    private static void showFlowResults(boolean actual, boolean expected, int testNum) {
        if (actual == expected) {
            System.out.println("Test " + testNum + " passed. can flow off map.");
        } else {
            System.out.println("Test " + testNum + " failed. can flow off map.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + actual);
        }
    }
    //END TEMP DELETE ABOVE

    private static void doNextIsDoubleTests() {
        int[] numsForDouble = { 1, 2, 4, 8, 16, 32, 64, 128, 256 };
        int actualDouble = Recursive.nextIsDouble(numsForDouble);
        int expectedDouble = 8;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 1 passed. next is double.");
        } else {
            System.out.println("Test 1 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[] { 1, 3, 4, 2, 32, 8, 128, -5, 6 };
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 2 passed. next is double.");
        } else {
            System.out.println("Test 2 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[] { 1, 0, 0, -5, -10, 32, 64, 128, 2, 9, 18 };
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 5;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 3 passed. next is double.");
        } else {
            System.out.println("Test 3 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[] { 37 };
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 4 passed. next is double.");
        } else {
            System.out.println("Test 4 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[] { 37, 74 };
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 1;
        if (actualDouble == expectedDouble) {
            System.out.println("Test 5 passed. next is double.");
        } else {
            System.out.println("Test 5 failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }
        System.out.println();
    }

    // Test the Sierpinski carpet method.
    private static void doCarpetTest() {
        // Recursive.drawCarpet(729, 4);
        // Recursive.drawCarpet(729, 1);
    }

    private static void doFairTeamsTests() {
//         System.out.println("Stress test for minDifference - may take up to a minute");
//         int[] testerArr = new int[] {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60,
//         65, 70, 75, 100000};
//         Stopwatch s = new Stopwatch();
//         s.start();
//         int actualInt = Recursive.minDifference(4, testerArr);
//         s.stop();
//         System.out.println("Time to solve for 16 people on 4 teams: " + s.time() +
//         "\n");
//         System.out.println(actualInt);

        int[] abilities = { 1, 2, 3, 4, 5, 6, 7 };
        showFairTeamsResults(Recursive.minDifference(3, abilities), 1, 1);
        showFairTeamsResults(Recursive.minDifference(5, abilities), 2, 2);
        showFairTeamsResults(Recursive.minDifference(6, abilities), 4, 3);

        abilities = new int[] { 1, 12, 46, 60, 53, 86, 72, 79, 44, 7 };
        showFairTeamsResults(Recursive.minDifference(3, abilities), 3, 4);
        showFairTeamsResults(Recursive.minDifference(5, abilities), 19, 5);

        abilities = new int[] { 10, 10, 7, 7, 7 };
        showFairTeamsResults(Recursive.minDifference(2, abilities), 1, 6);

        abilities = new int[] { -10, -10, -8, -8, -8 };
        showFairTeamsResults(Recursive.minDifference(2, abilities), 4, 7);

        abilities = new int[] { -5, 5, 10, 5, 10, -15 };
        showFairTeamsResults(Recursive.minDifference(2, abilities), 0, 8);
    }

    // Show the results of a fair teams test by comparing actual and expected
    // result.
    private static void showFairTeamsResults(int actual, int expected, int testNum) {
        if (actual == expected) {
            System.out.println("Test " + testNum + " passed. min difference.");
        } else {
            System.out.println("Test " + testNum + " failed. min difference.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + actual);
        }
    }
}