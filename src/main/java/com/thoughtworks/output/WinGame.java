package com.thoughtworks.output;

public class WinGame implements IOutputInstruction {

    @Override
    public String printInstruction() {
        return "Congratulations, you win!";
    }
}
