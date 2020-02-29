package com.thoughtworks;

import com.thoughtworks.answer.ChooseAnswer;
import com.thoughtworks.exception.WrongInput;
import com.thoughtworks.exception.WrongInputException;
import com.thoughtworks.output.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String answer = new ChooseAnswer("./src/main/resources/answer.txt").chooseGetter();
        List<String> guessList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您猜测的数字：");
        for (int i = 0; i < 6;) {
            String input = scanner.nextLine();
            WrongInput wrong = new WrongInput(answer, input);
            try {
                if (wrong.isWrong()) {
                    throw new WrongInputException("Wrong Input! Try again!");
                }
            } catch(WrongInputException e) {
                e.printStackTrace();
                continue;
            }
            if (answer.equals(input)) {
                System.out.println(new WinGame().printInstruction());
                break;
            }
            if (i == 5) {
                System.out.println(new DefaultGame(answer).printInstruction());
                break;
            }
            guessList.add("input：" + input + "，output："
                + new AnalyseInput(answer, input).printInstruction());
            for (String s : guessList) {
                System.out.println(s);
            }
            i++;
            System.out.println("您还有" + (6 - i) + "次机会：");
        }
    }
}
