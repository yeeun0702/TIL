package org.mandatory.refactored.model;

import org.mandatory.refactored.exception.CalculationException;
import org.mandatory.refactored.exception.DivideByZeroException;
import org.mandatory.refactored.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

import static org.mandatory.refactored.exception.ErrorMessage.*;

public class Calculator {

    // 연산 결과를 저장하는 리스트 (캡슐화)
    private List<Integer> resultList;

    public Calculator() {
        this.resultList = new ArrayList<>();
    }

    // Getter 메서드 (연산 결과 가져오기)
    public List<Integer> getResultList() {
        return new ArrayList<>(resultList); // 원본 리스트 보호 (복사본 반환)
    }

    // 가장 먼저 저장된 연산 결과 삭제
    public void removeResult() {
        if (resultList.isEmpty()) {
            throw new CalculationException(INVALID_DELETE_NO_RESULT.getMessage());
        }
        resultList.remove(0);
    }

    // 사칙연산을 수행하는 메서드
    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        if (num1 < 0 || num2 < 0) {
            throw new InvalidInputException(INVALID_NUMBER.getMessage());
        }

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
                if (num2 == 0) {
                    throw new DivideByZeroException(INVALID_DIVIDEBYZERO.getMessage());
                }
                result = num1 / num2;
                break;
            default:
                throw new CalculationException(INVALID_OPERATOR.getMessage());
        }

        // 연산 결과 저장
        resultList.add(result);

        return result;
    }
}
