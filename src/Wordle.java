/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */

import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleGWindow;

public class Wordle {
    /* Private instance variables */

    private WordleGWindow gw;
    private final String rand = chooseRandomWord();
    private int row = 0;
    private int start = 0;

    public void run() {
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
    }

    /*
     * Called when the user hits the RETURN key or clicks the ENTER button,
     * passing in the string of characters on the current row.
     */

    public void enterAction(String s) {
        //gw.showMessage("You have to implement this method.");
        String word = "";
        String actualWord = rand;
        boolean isAWord = false;
        for (int i = 0; i < 5; i++) {
            word += gw.getSquareLetter(gw.getCurrentRow(), i).toLowerCase();
        }
        String[] arr = WordleDictionary.FIVE_LETTER_WORDS;
        for (int j = 0; j < arr.length; j++) {
            if (word.toLowerCase().equals(arr[j])) {
                isAWord = true;
            }
        }
        if (isAWord) {

            for(int i = 0; i < word.length(); i++) {
                char atter = word.charAt(i);
                if(word.charAt(i) == rand.charAt(i)) {
                    gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.CORRECT_COLOR);
                } else {
                    for (int j = 0; j < word.length(); j++) {
                        if(atter == rand.charAt(j)) {
                            gw.setSquareColor(gw.getCurrentRow(), i, WordleGWindow.PRESENT_COLOR);
                            //gw.setSquareLetter(gw.getCurrentRow(),i,WordleGWindow.);
                            //gw.setKeyColor(gw.getCurrentRow(), WordleGWindow.PRESENT_COLOR);

                        }
                    }
                }
                if(gw.getSquareColor(gw.getCurrentRow(), i) != WordleGWindow.CORRECT_COLOR &&
                   gw.getSquareColor(gw.getCurrentRow(), i) != WordleGWindow.PRESENT_COLOR) {
                    gw.setSquareColor(gw.getCurrentRow(),i, WordleGWindow.MISSING_COLOR);
                }
            }

                int count = 0;
                for(int k = 0; k < word.length(); k++) {
                    if(gw.getSquareColor(gw.getCurrentRow(),k) == WordleGWindow.CORRECT_COLOR) {
                        count++;
                    }
                }
                if(count == word.length()) {
                    gw.showMessage("Congratulations you won!");
                    //exit(1);
                } else if (row == 5){
                    gw.showMessage("The correct word was " + rand);
                } else {
                row++;
                gw.setCurrentRow(row);
            }

        } else if(word.isBlank()){
            gw.showMessage("Empty. Write a 5-letter word");

        } else if (word.length() != 5) {
            gw.showMessage("Not enough characters. Delete and Try Again");
        } else {
            gw.showMessage("Not a word. Delete and Try Again");
        }

    }

    public String chooseRandomWord() {
        return WordleDictionary.FIVE_LETTER_WORDS[(int) (Math.random() *
                WordleDictionary.FIVE_LETTER_WORDS.length)];
    }


    /* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
    }

}

/*
for (int i = 0; i < 5; i++) {
                if (word.charAt(i) == rand.charAt(i)) {
                    gw.setSquareColor(row, i, WordleGWindow.CORRECT_COLOR);
                } else if (letter == rand.charAt(i)) {
                    gw.setSquareColor(row, i, WordleGWindow.PRESENT_COLOR);
                } else {
                    gw.setSquareColor(row, i, WordleGWindow.MISSING_COLOR);
                }
            }
            start++;
            if (row == 5) {
                System.out.println("The correct word was " + rand);
            } else {
                row++;
                gw.setCurrentRow(row);
            }
 */

/*
while (!word.equals(rand) && row < 6) {
                gw.setCurrentRow(row);
                char letter = word.charAt(start);
                for (int i = 0; i < 5; i++) {
                    if (word.charAt(i) == rand.charAt(i)) {
                        gw.setSquareColor(row, i, WordleGWindow.CORRECT_COLOR);
                    } else if (letter == rand.charAt(i)) {
                        gw.setSquareColor(row, i, WordleGWindow.PRESENT_COLOR);
                    } else {
                        gw.setSquareColor(row, i, WordleGWindow.MISSING_COLOR);
                    }
                    start++;
                }
                start = 0;
                row++;

            }
        } else {
            gw.showMessage("Not a word. Delete and Try Again");
        }
 */

/*
 gw.setCurrentRow(row);
            char letter = word.charAt(start);
            for (int i = 0; i < 5; i++) {
                if (rand.indexOf(word.charAt(i)) != -1) {
                    if (word.charAt(i) == rand.charAt(i)) {
                        gw.setSquareColor(row, i, WordleGWindow.CORRECT_COLOR);
                    } else if (letter == rand.charAt(i)) {
                        gw.setSquareColor(row, rand.indexOf(i), WordleGWindow.PRESENT_COLOR);
                    }
                } else {
                    gw.setSquareColor(row, i, WordleGWindow.MISSING_COLOR);
                }

            }
            start++;
            row++;
 */
