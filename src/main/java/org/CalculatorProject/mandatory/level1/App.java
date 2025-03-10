package org.CalculatorProject.mandatory.level1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // 전체 반복을 위한 while 루프
            System.out.print("첫 번째 숫자를 입력하세요: ");

            // 첫 번째 숫자 입력 (정수인지 확인)
            if (!scanner.hasNextInt()) {
                System.out.println("올바른 정수를 입력하세요.");
                scanner.next(); // 잘못된 입력 버리기
                continue; // 처음으로 돌아감
            }
            int num1 = scanner.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            if (!scanner.hasNextInt()) {
                System.out.println("올바른 정수를 입력하세요.");
                scanner.next();
                continue;
            }
            int num2 = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);

            int result = 0;
            boolean isValid = true; // 연산이 정상적으로 수행되었는지 확인

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("나눗셈 연산에서 분모(두 번째 숫자)에 0이 입력될 수 없습니다.");
                        isValid = false;
                    }
                    break;
                default:
                    System.out.println("올바른 연산 기호를 입력하세요. (+, -, *, / 중 하나)");
                    isValid = false;
                    break;
            }

            // 결과 출력 (유효한 연산일 경우)
            if (isValid) {
                System.out.println("결과: " + result);
            }

            // 추가 계산 여부 확인
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String nextInput = scanner.next();

            // "exit" 입력 시 프로그램 종료
            if (nextInput.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // "exit"이 아닐 경우 다시 처음으로 돌아감
        }

        scanner.close();
    }
}
