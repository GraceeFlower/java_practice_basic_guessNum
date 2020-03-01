package com.thoughtworks.answer;

import java.io.File;

public class ChooseAnswer {

    private String path;

    public ChooseAnswer(String path) {
        this.path = path;
    }

    public String chooseGetter() {
        return new File(path).isFile() ?
            new FileGetter(path).getAnswer().trim() : new RandomGetter().getAnswer().trim();
    }
}
