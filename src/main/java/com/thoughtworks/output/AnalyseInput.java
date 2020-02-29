package com.thoughtworks.output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalyseInput {

    private String answer;
    private String input;

    public AnalyseInput(String answer, String input) {
        this.answer = answer;
        this.input = input;
    }

    public String printInstruction() {
        List<String> answerList = new ArrayList<>(Arrays.asList(answer.split("")));
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split("")));
        int correctNum = 0;
        int correctPosition = 0;
        for (int i = 0; i < inputList.size(); i++) {
            if (answerList.contains(inputList.get(i))) {
                if (inputList.get(i).equals(answerList.get(i))) {
                    correctNum++;
                } else {
                    correctPosition++;
                }
            }
        }
        return correctNum + "A" + correctPosition + "B";
    }
}
