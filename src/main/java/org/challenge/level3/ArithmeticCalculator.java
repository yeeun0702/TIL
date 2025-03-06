package org.challenge.level3;

import org.challenge.level3.exception.InvalidInputException;
import org.challenge.level3.exception.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> resultList = new ArrayList<>();
    private T num1; // 제네릭 타입을 활용한 필드 선언
    private T num2; // 제네릭 타입을 활용한 필드 선언
    private OperatorType operator;

    //  입력 값 설정 메서드
    public void setNum1(T num1) { // 제네릭 타입 T를 사용하여 입력값을 저장
        if (num1.doubleValue() < 0) { // 음수 값 제한
            throw new InvalidInputException(ErrorMessage.INVALID_NUMBER); // 예외 처리
        }
        this.num1 = num1;
    }

    public void setNum2(T num2) {
        if (num2.doubleValue() < 0) {
            throw new InvalidInputException(ErrorMessage.INVALID_NUMBER);
        }
        this.num2 = num2;
    }

    public void setOperator(OperatorType operator) {
        this.operator = operator;
    }

    //  연산 수행 (제네릭 활용)
    public double calculate() {
        if (num1 == null || num2 == null || operator == null) {
            throw new InvalidInputException(ErrorMessage.INVALID_OPERATOR);
        }

        double result = operator.apply(num1.doubleValue(), num2.doubleValue()); // 모든 숫자 타입을 double로 변환
        resultList.add(result); // 연산 결과를 리스트에 저장
        return result;
    }

    // 연산 결과 리스트 조회 (캡슐화)
    public List<Double> getResultList() {
        return new ArrayList<>(resultList);
    }


}
