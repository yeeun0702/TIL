package org.mandatory.refactored.controller;

import org.mandatory.refactored.model.Calculator;
import org.mandatory.refactored.view.InputView;
import org.mandatory.refactored.view.OutputView;
import org.mandatory.refactored.exception.*;

public class CalculatorController {
    private final Calculator calculator;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(Calculator calculator, InputView inputView, OutputView outputView) {
        this.calculator = calculator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void executeCalculator() {
        outputView.startMessage(); // 계산기 시작 메시지 출력

        while (true) {
            try {
                int num1 = getValidatedNum1();
                int num2 = getValidatedNum2();
                char operator = getValidatedOperator();
                int result = calculator.calculate(num1, num2, operator);
                outputView.displayResult(result);
            } catch (InvalidInputException | CalculationException | DivideByZeroException e) {
                outputView.displayErrorMessage(e.getMessage());
                continue;
            }

            outputView.displayHistory(calculator.getResultList());

            // 삭제 여부 확인 (yes → 삭제, no → 유지)
            if (confirmDeletion()) {
                try {
                    calculator.removeResult();
                    outputView.displayDeleteSuccess();
                    outputView.displayHistory(calculator.getResultList());
                } catch(CalculationException e){
                    outputView.displayErrorMessage(e.getMessage()); // 삭제할 연산 결과가 없을 경우 메시지 출력
                }
            }

            // 추가 계산 여부 확인 (exit 입력 시 프로그램 종료)
            if (!confirmContinue()) {
                outputView.exitMessage();
                break; // 프로그램 종료
            }
        }
    }


    private int getValidatedNum1() {
        while (true) {
            try {
                outputView.num1Message();
                return inputView.getNum();
            } catch (InvalidInputException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private int getValidatedNum2() {
        while (true) {
            try {
                outputView.num2Message();
                return inputView.getNum();
            } catch (InvalidInputException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private char getValidatedOperator() {
        while (true) {
            try {
                outputView.operatorMessage();
                return inputView.getOperator();
            } catch (InvalidInputException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private boolean confirmDeletion() {
        while (true) {
            try {
                outputView.removeMessage();
                return inputView.confirmDeletion(); // true면 삭제, false면 유지
            } catch (InvalidInputException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }

    private boolean confirmContinue() {
        while (true) {
            try {
                outputView.continueMessage();
                return inputView.confirmContinue(); // true면 계속 진행, false면 종료
            } catch (InvalidInputException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }
}