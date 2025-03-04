package org.mandatory.level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private int num1;
    private int num2;
    private char operator;

    // 연산 결과를 저장하는 리스트
    private List<Integer> resultList;

    // 생성자
    public Calculator() {
        this.resultList = new ArrayList<>();
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    // Getter 메서드 (연산 결과 가져오기)
    public List<Integer> getResultList() {
        return new ArrayList<>(resultList); // 원본 리스트 보호 (복사본 반환)
    }

    // Setter 메서드 (연산 결과 리스트 수정 가능)
    public void setResultList(List<Integer> newList) {
        this.resultList = new ArrayList<>(newList); // 새로운 리스트로 교체
    }

    // 사칙연산을 수행하는 메서드
    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        if (num1 < 0 || num2 < 0) {
            throw new IllegalArgumentException("양의 정수(0 포함)만 입력 가능합니다.");
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
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("올바른 연산 기호를 입력하세요. (+, -, *, /)");
        }

        // 연산 결과 저장
        resultList.add(result);

        return result;
    }

}
