package org.mandatory.refactored.view;

import org.mandatory.refactored.exception.ErrorMessage;
import org.mandatory.refactored.exception.InvalidInputException;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    // 첫 번째 숫자 입력
    public int getNum1() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // 잘못된 입력 버리기
            throw new InvalidInputException(ErrorMessage.INVALID_NUMBER);
        }
        return scanner.nextInt();
    }

    // 두 번째 숫자 입력
    public int getNum2() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // 잘못된 입력 버리기
            throw new InvalidInputException(ErrorMessage.INVALID_NUMBER);
        }
        return scanner.nextInt();
    }

    // 연산 기호 입력
    public char getOperator() {
        String input = scanner.next();
        if (input.length() != 1 || "+-*/".indexOf(input.charAt(0)) == -1) {
            throw new InvalidInputException(ErrorMessage.INVALID_OPERATOR);
        }
        return input.charAt(0);
    }

    // 연산 결과 삭제 여부 확인 (예외 발생 시 throw)
    public boolean confirmDeletion() {
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("yes")) {
                return true;
            } else if (input.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println(ErrorMessage.INVALID_DELETION_INPUT);
            }
        }
    }

    // 추가 계산 여부 확인 (예외 발생 시 throw)
    public boolean confirmContinue() {
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("continue")) {
                return true;
            } else if (input.equalsIgnoreCase("exit")) {
                return false;
            } else {
                System.out.println(ErrorMessage.INVALID_CONTINUE_INPUT);
            }
        }
    }
}
