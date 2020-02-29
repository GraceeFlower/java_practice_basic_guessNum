package com.thoughtworks;

import com.thoughtworks.answer.ChooseAnswer;
import com.thoughtworks.output.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    String answer = new ChooseAnswer("./src/main/resources/answer.txt").chooseGetter();
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入您猜测的数字：");
    for (int i = 0; i < 6;) {
      String input = scanner.nextLine();
      WrongInput wrong = new WrongInput(answer, input);
      if (wrong.isWrong()) {
        System.out.println(wrong.printInstruction());
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
      System.out.println(new ChooseOutput(answer, input).printOutPut());
      i++;
    }
  }
}
