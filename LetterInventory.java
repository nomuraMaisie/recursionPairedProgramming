/*
 * Recursive.java - CS 314 Assignment 7
 *
 * By signing my/our name(s) below, I/we affirm that this assignment is my/our
 * own work. I/we have neither given nor received unauthorized assistance on
 * this assignment.
 *
 * Name 1: Maisie Nomura
 * Email address 1: maisie.nomura@gmail.com
 * UTEID 1: mkn762
 *
 * Name 2:
 * Email address 2:
 * UTEID 2:
 */

public class LetterInventory {
    private final int NUM_LETTERS = 26;
    private final int A_VALUE = 97;
    private int[] inventory;
    private int size;

    /**
     * Constructor for new LetterInventory
     *
     * pre: word != null
     * 
     * @param word
     * @throws IllegalArgumentException if word == null
     */
    //MUST BE O(M+N)
    public LetterInventory(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Violation of precondition: word cannot be null");
        }
        inventory = new int[NUM_LETTERS];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = getIndex(ch);
            if (index >= 0 && index < NUM_LETTERS) {
                inventory[index]++;
                size++;
            }
        }
    }

    /**
     * Get the corresponding index of a letter in the alphabet
     *
     * @return index of letter in the alphabet
     */
    private int getIndex(char ch) {
        ch = Character.toLowerCase(ch);
        return ch - A_VALUE;
    }

    /**
     * Returns the frequency of a letter 
     *
     * pre: c must be an English Letter
     * 
     * @param c- letter to get frequency of
     * @return frequency of given letter
     * @throws 
     */
    public int get(char ch) {
        char lower = Character.toLowerCase(ch);
        if (lower < 'a' || lower > 'z') {
            throw new IllegalArgumentException("Violation of precondition: c must be an " + 
                "English letter.");
        }
        int index = getIndex(ch);
        return inventory[index];
    }

    /**
     * Returns the letters in the inventory 
     *
     * @return size of inventory
     * @throws 
     */
    public int size() {
        return size;
    }

    /**
     * Determines if the LetterInventory is empty 
     *
     * @return true if the LetterInventory is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation with all letters in the inventory in alphabetical order
     *
     * @return string representation of LetterInventory
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < inventory.length; i++) {
            int num = inventory[i];
            if (num > 0) {
                for (int j = 0; j < num; j++) {
                    char ch = letters.charAt(i);
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    /**
     * Adds frequencies of calling LetterInventory and other LetterInventory
     *
     * pre: other != null
     * post: calling object and other are not altered
     * 
     * @param other- LetterInventory to add
     * @return new LetterInventory with added frequencies
     * @throws IllegalArgumentException if other is null
     */
    //MUST BE O(M), M = LETTERS IN ALPHABET
    public LetterInventory add(LetterInventory other) {
        if (other == null) {
           throw new IllegalArgumentException("Violation of precondition: other cannot be null");
        }
        LetterInventory result = new LetterInventory("");
        for(int i = 0; i < NUM_LETTERS; i++) {
            int add = inventory[i] + other.inventory[i];
            result.inventory[i] = add;
            result.size += add;
        }
        return result;
    }


    /**
     * Subtracts frequencies of other LetterInventory from calling LetterInventory
     *
     * pre: other != null
     * post: calling object and other are not altered
     * 
     * @param other- LetterInventory to add
     * @return new LetterInventory with substracted frequencies
     * @throws IllegalArgumentException if other is null
     */
    //MUST BE O(M), M = LETTERS IN ALPHABET
    public LetterInventory subtract(LetterInventory other) {
        if (other == null) {
           throw new IllegalArgumentException("Violation of precondition: other cannot be null");
        }
        LetterInventory result = new LetterInventory("");
        for(int i = 0; i < NUM_LETTERS; i++) {
            int subtract = inventory[i] - other.inventory[i];
            if (subtract < 0 ){
                return null;
            }
            result.inventory[i] = subtract;
            result.size += subtract;
        }
        return result;
    }

    /**
     * Determines if two LetterInventory objects are equal, meaning they have the same frequency
     * for each letter
     *
     * @return true if the LetterInventories are equal, false otherwise
     */
    public boolean equals(Object other) {
        if (!(other instanceof LetterInventory)) {
            return false;
        }
        LetterInventory otherLI = (LetterInventory) other;
        for (int i = 0; i < NUM_LETTERS; i++) {
            if(inventory[i] != otherLI.inventory[i]) {
                return false;
            }
        }
        return true;
    }

}