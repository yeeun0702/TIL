package org.CalculatorProject.challenge.level3;

import org.CalculatorProject.challenge.level3.exception.ErrorMessage;
import org.CalculatorProject.challenge.level3.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> resultList = new ArrayList<>();

    //  연산 수행 (제네릭 활용)
    public double calculate(T num1, T num2, OperatorType operator) {
        if (num1 == null || num2 == null || operator == null) {
            throw new InvalidInputException(ErrorMessage.INVALID_OPERATOR.getMessage());
        }

        double result = operator.apply(num1.doubleValue(), num2.doubleValue()); // 모든 숫자 타입을 double로 변환
        resultList.add(result); // 연산 결과를 리스트에 저장
        return result;
    }

    // 연산 결과 리스트 조회 (캡슐화)
    public List<Double> getResultList() {
        return new ArrayList<>(resultList);
    }

    // 가장 먼저 저장된 연산 결과 삭제
    public void removeResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
        } else {
            throw new InvalidInputException(ErrorMessage.INVALID_DELETE_NO_RESULT.getMessage());
        }
    }

    // 입력값보다 큰 결과 조회 (람다 & 스트림 활용)
    public List<Double> filterGreaterThan(double threshold) {
        return resultList.stream() //  저장된 연산 결과 리스트를 스트림으로 변환
                .filter(result -> result > threshold) // 임계값보다 큰 값만 람다식을 이용하여 필터링
                .collect(Collectors.toList()); // 필터링된 값을 리스트로 변환하여 반환
    }

}
