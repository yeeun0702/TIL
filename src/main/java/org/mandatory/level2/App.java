package org.mandatory.level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator(); // Calculator 객체 생성

        while (true) { // 전체 반복을 위한 while 루프
            System.out.print("첫 번째 숫자를 입력하세요: ");

            // 첫 번째 숫자 입력 (정수인지 확인)
            if (!scanner.hasNextInt()) {
                System.out.println("올바른 정수를 입력하세요.");
                scanner.next(); // 잘못된 입력 버리기
                continue; // 처음으로 돌아감
            }
            int num1 = scanner.nextInt();
            calculator.setNum1(num1); // Setter 사용

            System.out.print("두 번째 숫자를 입력하세요: ");
            if (!scanner.hasNextInt()) {
                System.out.println("올바른 정수를 입력하세요.");
                scanner.next();
                continue;
            }
            int num2 = scanner.nextInt();
            calculator.setNum2(num2); // Setter 사용

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scanner.next().charAt(0);
            calculator.setOperator(operator); // Setter 사용

            // 연산 수행 및 예외 처리
            try {
                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("오류: " + e.getMessage());
            }


            // Getter를 이용하여 연산 기록 출력
            System.out.println("현재까지 저장된 값 조회: " + calculator.getResultList());

            // 추가 계산 여부 확인
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료 / continue 입력 시 계속 진행): ");
            String continueCalculation = scanner.next();

            // "exit" 입력 시 프로그램 종료
            if (continueCalculation.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        scanner.close();
    }
}
