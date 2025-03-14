package org.KioskProject.mandatory.level45.exception;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 입력입니다. 메뉴 번호를 확인해주세요."),
    NOT_A_NUMBER("숫자를 입력해주세요!"),
    EMPTY_MENU("현재 선택한 카테고리에 메뉴가 없습니다."),
    UNKNOWN_ERROR("알 수 없는 오류가 발생했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}