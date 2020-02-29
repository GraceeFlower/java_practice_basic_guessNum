package com.thoughtworks.output;

public class DefaultGame implements IOutputInstruction {

    private final String answer;

    public DefaultGame(String answer) {
        this.answer = answer;
    }

    @Override
    public String printInstruction() {
        return "Unfortunately, you have no chance, the answer is " + answer + "!";
    }
}
