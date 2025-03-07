package org.mandatory.refactored.view;

import org.mandatory.refactored.exception.InvalidInputException;

import java.util.Scanner;

import static org.mandatory.refactored.exception.ErrorMessage.*;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    // 숫자 입력 (검증 후 예외 발생)
    public int getNum() {
        if (!scanner.hasNextInt()) {
            scanner.next(); // 잘못된 입력 버리기
            throw new InvalidInputException(INVALID_NUMBER.getMessage());
        }
        return scanner.nextInt();
    }

    // 연산 기호 입력 (잘못된 경우 예외 발생)
    public char getOperator() {
        String input = scanner.next();
        if (input.length() != 1 || "+-*/".indexOf(input.charAt(0)) == -1) {
            throw new InvalidInputException(INVALID_OPERATOR.getMessage());
        }
        return input.charAt(0);
    }

    // 삭제 여부 확인
    public boolean confirmDeletion() {
        String input = scanner.next();
        if (input.equalsIgnoreCase("yes")) {
            return true;
        } else if (input.equalsIgnoreCase("no")) {
            return false;
        }
        throw new InvalidInputException(INVALID_DELETE_INPUT.getMessage());
    }

    // 추가 계산 여부 확인
    public boolean confirmContinue() {
        String input = scanner.next();
        if (input.equalsIgnoreCase("continue")) {
            return true;
        } else if (input.equalsIgnoreCase("exit")) {
            return false;
        }
        throw new InvalidInputException(INVALID_CONTINUE_INPUT.getMessage());
    }
}
