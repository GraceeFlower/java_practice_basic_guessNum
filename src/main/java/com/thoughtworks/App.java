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
        String instruction;
        List<String> guessList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("游戏开始，请输入您猜测的数字：");
        for (int i = 0; i < 6; i++) {
            String input = scanner.nextLine();
            if (new WrongInput(input).isWrongFormat()) {
                i--;
                System.out.println("您输入的格式错误(必须是纯数字)，请重新输入：");
                continue;
            }
            try {
                if (new WrongInput(answer, input).isWrong()) {
                    i--;
                    throw new WrongInputException("Wrong Input");
                } else {
                    instruction = new AnalyseInput(answer, input).printInstruction();
                    System.out.println(input + " " + new PrintFrequency(i).printInstruction());
                }
            } catch(WrongInputException e) {
                instruction = e.getMessage();
            }
            guessList.add(input + " " + instruction);
            for (String s : guessList) {
                System.out.println(s);
            }
            if (answer.equals(input)) {
                System.out.println(new WinGame().printInstruction());
                break;
            } else if (i == 5) {
                System.out.println(new DefaultGame(answer).printInstruction());
            }
        }
    }
}
