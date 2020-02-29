package com.thoughtworks;

import com.thoughtworks.answer.ChooseAnswer;
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
            if (wrong.isWrong()) {
                System.out.println(wrong.printInstruction());
                System.out.println("您还有" + (6 - i) + "次机会：");
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
            ChooseOutput analysis = new ChooseOutput(answer, input);
            guessList.add("input：" + input + "，output：" + analysis.printOutPut());
            for (String s : guessList) {
                System.out.println(s);
            }
            i++;
            System.out.println("您还有" + (6 - i) + "次机会：");
        }
    }
}
