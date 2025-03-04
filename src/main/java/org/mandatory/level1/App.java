package org.mandatory.level1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = scanner.nextInt();

        int result;

        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = scanner.next().charAt(0);

        scanner.close();

    }

}