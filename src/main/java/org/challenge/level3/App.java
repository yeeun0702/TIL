package org.challenge.level3;

import org.challenge.level3.exception.CustomExceptionHandler;
import org.challenge.level3.exception.ErrorMessage;

import java.util.List;
import java.util.Scanner;

import static org.challenge.level3.exception.ErrorMessage.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            try {
                // 첫 번째 숫자 입력
                double num1 = getValidatedNumber(scanner, "첫 번째 숫자를 입력하세요: ");

                // 두 번째 숫자 입력
                double num2 = getValidatedNumber(scanner, "두 번째 숫자를 입력하세요: ");

                // 연산자 입력 (올바른 값이 입력될 때까지 반복)
                OperatorType operator = getValidatedOperator(scanner);

                // 연산 수행
                double result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);

                // 저장된 결과 중 특정 값보다 큰 값 조회
                double threshold = getValidatedNumber(scanner, "저장된 결과 중 이 값보다 큰 값만 출력할 숫자 입력: ");
                List<Double> filteredResults = calculator.filterGreaterThan(threshold);
                System.out.println("입력값보다 큰 결과들: " + filteredResults);

                // 연산 결과 삭제 여부 확인 (예외 처리 포함)
                confirmAndRemoveResult(scanner, calculator);

                // 프로그램 종료 여부 확인 (예외 처리 포함)
                if (!confirmContinue(scanner)) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            } catch (Exception e) {
                CustomExceptionHandler.handleException(e);
                scanner.nextLine(); // 잘못된 입력 버리기
            }
        }
        scanner.close();
    }

    // 숫자 입력을 검증하는 메서드 (숫자가 아닌 값 입력 방지)
    private static double getValidatedNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double num = scanner.nextDouble();
                if (num < 0) {
                    System.out.println(INVALID_NUMBER.getMessage());
                } else {
                    return num;
                }
            } else {
                System.out.println(INVALID_NUMBER.getMessage());
                scanner.next(); // 잘못된 입력 버리기
            }
        }
    }

    // 연산자 입력을 검증하는 메서드 (올바른 연산자 입력될 때까지 반복)
    private static OperatorType getValidatedOperator(Scanner scanner) {
        while (true) {
            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
            String symbol = scanner.next();
            try {
                return OperatorType.fromSymbol(symbol);
            } catch (IllegalArgumentException e) {
                CustomExceptionHandler.handleException(e);
            }
        }
    }

    // 연산 결과 삭제 여부 확인 (삭제할 데이터 없을 시 예외 처리)
    private static void confirmAndRemoveResult(Scanner scanner, ArithmeticCalculator<Double> calculator) {
        while (true) {
            System.out.print("연산 결과를 삭제하시겠습니까? (yes 입력 시 삭제 / no 입력 시 유지): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("yes")) {
                try {
                    calculator.removeResult();
                    System.out.println("연산 결과 삭제 완료!");
                } catch (Exception e) {
                    CustomExceptionHandler.handleException(e);
                }
                break;
            } else if (input.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println(INVALID_DELETE_INPUT.getMessage());
            }
        }
    }

    // 프로그램 종료 여부 확인 (exit 또는 continue만 허용)
    private static boolean confirmContinue(Scanner scanner) {
        while (true) {
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료 / continue 입력 시 계속 진행): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) {
                return false;
            } else if (input.equalsIgnoreCase("continue")) {
                return true;
            } else {
                System.out.println(INVALID_CONTINUE_INPUT.getMessage());
            }
        }
    }
}
