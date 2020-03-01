package com.thoughtworks.exception;

import java.util.Arrays;
import java.util.HashSet;

public class WrongInput {

    private String answer;
    private String input;

    public WrongInput(String answer, String input) {
        this.answer = answer;
        this.input = input;
    }

    public boolean isWrong() {
        return isWrongLength() || isRepeat();
    }

    private boolean isWrongLength() {
        return answer.length() != input.length();
    }

    private boolean isRepeat() {
        return answer.length() > new HashSet<>(Arrays.asList(input.split(""))).size();
    }
}
