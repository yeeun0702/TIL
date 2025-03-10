package org.CalculatorProject.mandatory.refactored.view;

import java.util.List;

public class OutputView {
    public void startMessage(){
        System.out.println("계산기를 실행합니다.");
    }

    public void num1Message(){
        System.out.print("첫 번째 숫자를 입력하세요: ");
    }

    public void num2Message(){
        System.out.print("두 번째 숫자를 입력하세요: ");
    }

    public void operatorMessage(){
        System.out.print("사칙연산 기호를 입력하세요: ");
    }

    public void removeMessage(){
        System.out.print("연산 결과에서 가장 먼저 저장된 값을 삭제하시겠습니까? (yes 입력 시 삭제 / no 입력 시 유지): ");
    }

    public void continueMessage(){
        System.out.print("더 계산하시겠습니까? (exit 입력 시 종료 / continue 입력 시 계속 진행): ");
    }

    public void exitMessage(){
        System.out.println("프로그램을 종료합니다.");
    }

    public void displayResult(int result) {
        System.out.println("결과: " + result);
    }

    public void displayHistory(List<Integer> history) {System.out.println("현재까지 저장된 값 조회: " + history);}

    public void displayDeleteSuccess() {System.out.println("연산 결과 삭제 완료!");}

    public void displayErrorMessage(String message) {System.out.println(message);}
}