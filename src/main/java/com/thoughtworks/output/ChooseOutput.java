package com.thoughtworks.output;

public class ChooseOutput {

    private final String answer;
    private final String input;

    public ChooseOutput(String answer, String input) {
        this.answer = answer;
        this.input = input;
    }

    public String printOutPut() {
        IOutputInstruction correct = new WinGame();
        IOutputInstruction wrong = new WrongInput(answer, input);
        if (answer.equals(input)) {
            return correct.printInstruction();
        } else if (wrong.printInstruction() != null) {
            return wrong.printInstruction();
        } else {
            return new AnalyseInput(answer, input).printInstruction();
        }
    }
}
