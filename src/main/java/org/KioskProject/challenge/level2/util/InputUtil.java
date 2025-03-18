package org.KioskProject.challenge.level2.util;

import org.KioskProject.challenge.level2.exception.ErrorMessage;

import java.util.Scanner;

public class InputUtil {

    /**
     *  숫자 입력을 검증하는 메서드 (숫자가 아닌 입력 방지)
     */
    public static int getValidatedIntInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 처리
                return input;
            } else {
                System.out.println(ErrorMessage.NOT_A_NUMBER.getMessage());
                scanner.nextLine(); // 잘못된 입력 제거
            }
        }
    }
}
