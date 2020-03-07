package com.thoughtworks.answer;

import com.thoughtworks.exception.WrongInput;

import java.io.File;

public class ChooseAnswer {

    private String path;

    public ChooseAnswer(String path) {
        this.path = path;
    }

    public String chooseGetter() {
        String fileAnswer = new FileGetter(path).getAnswer();
        boolean isWrong = new WrongInput("1234", fileAnswer).isWrong();
        return new File(path).isFile() && !isWrong?
            new FileGetter(path).getAnswer() : new RandomGetter().getAnswer();
    }
}
