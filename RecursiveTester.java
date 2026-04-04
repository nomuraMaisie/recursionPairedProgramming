/*
 * RecursiveTester.java - CS 314 Assignment 7
 *
 * By signing my/our name(s) below, I/we affirm that this assignment is my/our
 * own work. I/we have neither given nor received unauthorized assistance on
 * this assignment.
 *
 * Name 1: Rajni Nitturi
 * Email address 1:
 * UTEID 1:
 *
 * Name 2: Maisie Nomura
 * Email address 2: maisie.nomura@gmail.com
 * UTEID 2: mkn762
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

}