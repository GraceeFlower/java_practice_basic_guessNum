package com.thoughtworks.exception;

import java.util.Arrays;
import java.util.HashSet;

public class WrongInput {

    private String input;
    private int answerLen;

    public WrongInput(String answer, String input) {
        this.answerLen = answer.length();
        this.input = input;
    }

    public WrongInput(String input) {
        this.input = input;
    }

    public boolean isWrong() {
        return isWrongLength() || isWrongFormat() || isRepeat();
    }

    private boolean isWrongLength() {
        return answerLen != input.length();
    }

    private boolean isRepeat() {
        return answerLen > new HashSet<>(Arrays.asList(input.split(""))).size();
    }

    public boolean isWrongFormat() {
        char[] strArr = this.input.toCharArray();
        for (char c : strArr) {
            if (c > 57 || c < 48) {
                return true;
            }
        }
        return false;
    }
}
