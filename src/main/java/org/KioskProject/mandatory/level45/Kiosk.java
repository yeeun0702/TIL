package org.KioskProject.mandatory.level45;

import org.KioskProject.mandatory.level45.exception.ErrorMessage;
import org.KioskProject.mandatory.level45.exception.InvalidInputException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus; // 메뉴 카테고리의 메뉴들 (Burgers, Drinks, Desserts)을 리스트로 관리
    private Scanner scanner;

    // 생성자
    public Kiosk(List<Menu> menus) { // 키오스크 속에 메뉴들을 생성
        this.menus = menus;
        this.scanner = new Scanner(System.in);
    }

    /**
     * main 에서 관리하던 입력과 반복문 로직을 start 함수로 변경
     */
    public void start() {
        while (true) {// 프로그램 반복 실행
            try {
                printMainMenu();

                // 메뉴 카테고리 숫자를 입력 받기
                int menuCategoryNum = getValidatedIntInput("");

                // 0 입력 시 프로그램 종료
                if (menuCategoryNum == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                if (menuCategoryNum < 1 || menuCategoryNum > menus.size()) {
                    throw new InvalidInputException(ErrorMessage.INVALID_INPUT.getMessage());
                }
                // showMenuSelection 메서드를 활용하여 메뉴에 접근
                showMenuSelection(menus.get(menuCategoryNum - 1));
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(ErrorMessage.UNKNOWN_ERROR.getMessage());
                scanner.nextLine(); // 입력 버퍼 초기화
            }
        }
    }

    /**
     * 메인 메뉴 출력 (Burgers, Drinks, Desserts)
     */
    private void printMainMenu() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 종료");
    }

    /**
     * 특정 카테고리의 메뉴 출력 및 선택 처리
     */
    public void showMenuSelection(Menu menu) {
        while (true) {
            menu.showMenuItems(); // 해당 카테고리의 메뉴 출력

            // 메뉴가 비어 있는지 확인
            if (menu.getMenuItems() == null || menu.getMenuItems().isEmpty()) {
                System.out.println(ErrorMessage.EMPTY_MENU.getMessage());
                return;
            }
            try {
                // 상세 메뉴 숫자 입력 받기
                int itemChoice = getValidatedIntInput("\n메뉴를 선택하세요: ");

                // `0` 입력 시 뒤로가기
                if (itemChoice == 0) break;

                if (itemChoice < 1 || itemChoice > menu.getMenuItems().size()) {
                    throw new InvalidInputException(ErrorMessage.INVALID_INPUT.getMessage());
                }

                printSelectedMenu(menu, itemChoice);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 선택한 메뉴 출력
     */
    private void printSelectedMenu(Menu menu, int itemChoice) {
        MenuItem selectedItem = menu.getMenuItems().get(itemChoice - 1);
        System.out.printf("선택한 메뉴: %s | W %.1f | %s\n",
                selectedItem.getMenuName(), selectedItem.getPrice(), selectedItem.getDescription());
    }


    /**
     *  숫자 입력을 검증하는 메서드 (숫자가 아닌 입력 방지)
     */
    private int getValidatedIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println(ErrorMessage.NOT_A_NUMBER.getMessage());
                scanner.next(); // 잘못된 입력 제거
            }
        }
    }

}