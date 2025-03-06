package org.challenge.level3;

import org.challenge.level3.exception.DivideByZeroException;
import org.challenge.level3.exception.ErrorMessage;
import java.util.function.BiFunction;

public enum OperatorType {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new DivideByZeroException(ErrorMessage.INVALID_DIVIDEBYZERO);
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
        for (OperatorType op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_OPERATOR);
    }
}
