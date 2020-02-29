package com.thoughtworks.answer;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGetter implements AnswerGetter {

    @Override
    public String getAnswer() {
        Set<Integer> answerSet = new HashSet<>();
        Random random = new Random();
        StringBuilder answer = new StringBuilder();
        while (answerSet.size() < 4) {
            answerSet.add(random.nextInt(10));
        }
        for (Integer i : answerSet) {
            answer.append(i);
        }
        return answer.toString();
    }
}
