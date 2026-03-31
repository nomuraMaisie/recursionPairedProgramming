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
        studentTests();
    }

    private static void studentTests() {
        //Test 1 nextIsDouble()
        int[] nextDub = {5, 10, 20, 2, 4};
        int result = Recursive.nextIsDouble(nextDub);
        boolean actual = (result == 3);
        showResults(true, actual, 1, "nextIsDouble()");

        //Test 2 nestIsDouble()
        nextDub = new int[] {0, 0, 3, 6};
        result = Recursive.nextIsDouble(nextDub);
        actual = (result == 2);
        showResults(true, actual, 2, "nextIsDouble()");

        //Test 3 listMnemonics()
        ArrayList<String> mnemonics = Recursive.listMnemonics("79");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("PW");
        expected.add("PX");
        expected.add("PY");
        expected.add("PZ");
        expected.add("QW");
        expected.add("QX");
        expected.add("QY");
        expected.add("QZ");
        expected.add("RW");
        expected.add("RX");
        expected.add("RY");
        expected.add("RZ");
        expected.add("SW");
        expected.add("SX");
        expected.add("SY");
        expected.add("SZ");
        actual = mnemonics.equals(expected);
        showResults(true, actual, 3, "listMnemonics()");

        //Test 4 listMnemonics()
        mnemonics = Recursive.listMnemonics("7");
        expected = new ArrayList<>();
        expected.add("P");
        expected.add("Q");
        expected.add("R");
        expected.add("S");
        actual = mnemonics.equals(expected);
        showResults(true, actual, 4, "listMnemonics()");

        //Test 5 canFlowOffMap()
        int[][] map = {
           {200, 200, 200, 200, 200},
           {200,  99,  98,  97, 200},
           {200, 150,  96,  95,  94},
           {200, 200, 200, 200,  93}
       };
       actual = Recursive.canFlowOffMap(map, 2, 2);
       showResults(true, actual, 5, "canFlowOffMap()");

        //Test 6 canFlowOffMap()
        map = new int[][] {
            {50, 50, 50},
            {50, 40, 40},
            {50, 50, 50}
        };
        actual = Recursive.canFlowOffMap(map, 1, 1);
        showResults(false, actual, 6, "canFlowOffMap()");

        //Test 7 minDifference()
        int skills[] = {3, 8, 2, 5, 1, 9};
        actual = (Recursive.minDifference(2, skills) == 0);
        showResults(true, actual, 7, "minDifference()");

        //Test 8 minDifference()
        // 9, -5, 7, 4, -2, 11, -6, 8, 3
        //min diff 1
        skills = new int[] {9, -5, 7, 4, -2, 11, -6, 8, 3};
        actual = (Recursive.minDifference(2, skills) == 1);
        showResults(true, actual, 8, "minDifference()");
    }
    
    private static void showResults(boolean expected, boolean actual, int testNum, String name) {
        if (expected == actual) {
            System.out.println("Passed test " + testNum);
        }
        else {
            System.out.println("Failed test " + testNum + ": " + name);
        }
    }

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
        //Recursive.drawCarpet(729, 4);
        //Recursive.drawCarpet(729, 1);
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