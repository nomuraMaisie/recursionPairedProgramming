/*
 * AnagramSolver.java - CS 314 Assignment 7
 *
 * By signing my/our name(s) below, I/we affirm that this assignment is my/our
 * own work. I/we have neither given nor received unauthorized assistance on
 * this assignment.
 *
 * Name 1: Rajni Nitturi
 * Email address 1: rn22455@my.utexas.edu
 * UTEID 1: rn22455
 *
 * Name 2: 
 * Email address 2:
 * UTEID 2:
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.Set;

public class AnagramSolver {

    // The possible words and the letter inventory for each word
    private TreeMap<String, LetterInventory> list;

    /*
     * pre: list != null
     *
     * @param list Contains the words to form anagrams from.
     */
    public AnagramSolver(Set<String> dictionary) {
        if (dictionary == null) {
            throw new IllegalArgumentException("The dictionary cannot be null.");
        }
        list = new TreeMap<>();
        for (String word : dictionary) {
            list.put(word, new LetterInventory(word));
        }
    }

    /*
     * Return a list of anagrams that can be formed from s with no more than
     * maxWords, unless maxWords is 0 in which case there is no limit on the number
     * of words in the anagram. pre: maxWords >= 0, s != null, s contains at least
     * one English letter.
     */
    public List<List<String>> getAnagrams(String s, int maxWords) {
        if (maxWords < 0 || s == null) {
            throw new IllegalArgumentException(
                    "The word cannot be null and the maxWords must "
                    + "be greater than or equal to 0.");
        }
        LetterInventory currInv = new LetterInventory(s);
        if (currInv.isEmpty()) {
            throw new IllegalArgumentException("The word must have at least one English letter "
                    + "in it.");
        }
        TreeMap<String, LetterInventory> newList = new TreeMap<>();
        for (String word : list.keySet()) {
            // Compare the inventories each possible words with the target word inventory to make
            // sure the possible word has the letters and frequency for each as the target word
            // for shrinking the dictionary
            if ((currInv).subtract(list.get(word)) != null) {
                newList.put(word, list.get(word));
            }
        }
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> dict = new ArrayList<>(newList.keySet());
        result = anagramHelper(result, new ArrayList<String>(), newList, maxWords, 
                currInv, 0, dict);
        Collections.sort(result, new AnagramComparator());
        return result;
    }

    /**
     * Finding the anagrams for the target word provided by the user
     * 
     * @param list The list of anagrams for the word
     * @param currWords The current words for the specific anagram currently exploring
     * @param dictionary All possible words with their inventories
     * @param max The max words that can be used to create an anagram
     * @param lettersLeft The letters left in the target word to find in the possible words
     * @param start The position in the dictionary
     * @param listDict The list of possible words to use for the anagram
     * @return The list of anagrams for the specific word the user wants to find anagrams for
     */
    private List<List<String>> anagramHelper(List<List<String>> list, ArrayList<String> currWords,
            TreeMap<String, LetterInventory> dictionary, int max, LetterInventory lettersLeft, 
            int start, ArrayList<String> listDict) {

        if (lettersLeft.isEmpty()) {
            if (currWords.size() <= max || max == 0) {
                list.add(new ArrayList<>(currWords));
            }
            return list;
        }
        if (max != 0 && currWords.size() == max) {
            return list;
        }
        for (int i = start; i < listDict.size(); i++) {
            String word = listDict.get(i);

            LetterInventory newLeft = lettersLeft.subtract(dictionary.get(word));
            if (newLeft != null) {
                currWords.add(word);
                anagramHelper(list, currWords, dictionary, max, newLeft, i, listDict);
                currWords.remove(currWords.size() - 1);
            }
        }
        return list;
    }

    private static class AnagramComparator implements Comparator<List<String>> {
        // Compares Lists in the Anagram List
        /**
         * To compare two lists based on size first and then the individual words in the
         * lists pre: a1 != null, a2 != null
         * 
         * @param the first list to compare to the second list
         * @param the second list to compare to the first list
         * @return the difference between the two lists. A positive value returned means
         *         that a1 is greater than a2, a zero is the lists are equal, and a
         *         negative value means that a1 is less than a2
         */
        public int compare(List<String> a1, List<String> a2) {
            if (a1.size() != a2.size()) {
                return a1.size() - a2.size();
            } else {
                for (int i = 0; i < a1.size(); i++) {
                    int diff = a1.get(i).compareTo(a2.get(i));
                    if (a1.get(i).compareTo(a2.get(i)) != 0) {
                        return diff;
                    }
                }
            }
            return 0;
        }
    }

}
