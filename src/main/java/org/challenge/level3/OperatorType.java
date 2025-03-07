package org.challenge.level3;

import org.challenge.level3.exception.DivideByZeroException;
import java.util.function.BiFunction;

import static org.challenge.level3.exception.ErrorMessage.INVALID_DIVIDEBYZERO;
import static org.challenge.level3.exception.ErrorMessage.INVALID_OPERATOR;

public enum OperatorType { // 람다식 적용
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new DivideByZeroException(INVALID_DIVIDEBYZERO.getMessage());
        return a / b;
    });

    private final String symbol;
    private final BiFunction<Double, Double, Double> operation; // 제네릭 타입 변경

    OperatorType(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public double apply(double a, double b) {
        return operation.apply(a, b);
    }

    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType op : values()) { // Enum의 모든 값을 배열로 반환하여 모든 OperatorType을 순회
            if (op.symbol.equals(symbol)) { // symbol 값과 입력된 값이 같다면
                return op; // 연산자 반환
            }
        }
        throw new IllegalArgumentException(INVALID_OPERATOR.getMessage());
    }
}
