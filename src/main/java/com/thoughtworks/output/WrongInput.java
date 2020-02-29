package com.thoughtworks.output;

import java.util.Arrays;
import java.util.HashSet;

public class WrongInput implements IOutputInstruction {

    private String answer;
    private String input;

    public WrongInput(String answer, String input) {
        this.answer = answer;
        this.input = input;
    }

    @Override
    public String printInstruction() {
        if (isLessThanLength() || isRepeatChar()) {
            return "Wrong input";
        }
        return null;
    }

    private boolean isLessThanLength() {
        return answer.length() > input.length();
    }

    private boolean isRepeatChar() {
        return new HashSet<>(Arrays.asList(input.split(""))).size() > answer.length();
    }
}
