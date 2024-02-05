/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */

import edu.willamette.cs1.wordle.WordleGWindow;

public class Wordle {
    /* Private instance variables */

    private WordleGWindow gw;


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
        for (int i = 0; i < 5; i++) {
            word += gw.getSquareLetter(0, i);
        }
        

    }

    /* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
    }

}


