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
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                answer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer.toString();
    }

}
