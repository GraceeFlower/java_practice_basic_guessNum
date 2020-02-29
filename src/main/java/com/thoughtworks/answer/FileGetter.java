package com.thoughtworks.answer;

import java.io.*;

public class FileGetter implements AnswerGetter {

    private final String path;

    public FileGetter(String path) {
        this.path = path;
    }

    @Override
    public String getAnswer() {
        StringBuilder answer = new StringBuilder();
        try(InputStream input = new FileInputStream(path)) {
            int num;
            while (-1 != (num = input.read())) {
                answer.append((char)num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer.toString();
    }

}
