package org.CalculatorProject.challenge.level3.exception;

public enum ErrorMessage {
    INVALID_NUMBER("양의 정수(0 포함)만 입력 가능합니다."),
    INVALID_DIVIDEBYZERO("0으로 나눌 수 없습니다."),
    INVALID_OPERATOR("잘못된 연산 기호가 입력되었습니다. (+,-,*,/) 중에 하나를 입력하세요."),
    INVALID_DELETE_NO_RESULT("삭제할 연산결과가 없습니다."),
    INVALID_DELETE_INPUT("잘못된 입력입니다. 'yes' 또는 'no'를 입력하세요."),
    INVALID_CONTINUE_INPUT("잘못된 입력입니다. 'exit' 또는 'continue'를 입력하세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}