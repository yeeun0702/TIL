package org.KioskProject.mandatory.level45;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus; // 메뉴 카테고리의 메뉴들 (Burgers, Drinks, Desserts)을 리스트로 관리
    private Scanner scanner;

    public Kiosk(List<Menu> menus) { // 키오스크 속에 메뉴들을 생성
        this.menus = menus;
        this.scanner = new Scanner(System.in);
    }

    // main 에서 관리하던 입력과 반복문 로직을 start 함수로 변경
    public void start() {
        while (true) {// 프로그램 반복 실행

            // 메인 메뉴(Burgers, Drinks, Desserts) 출력
            System.out.println("\n[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                // 메뉴 카테고리의 이름을 차례로 인덱스 접근하여 출력
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료      | 종료");

            // 메뉴 카테고리 숫자를 입력 받기
            int menuCategoryNum = scanner.nextInt();

            // 0 입력 시 프로그램 종료
            if (menuCategoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            //  입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            if (menuCategoryNum >= 0 && menuCategoryNum <= menus.size()) {

                // showMenuSelection 메서드를 활용하여 메뉴에 접근
                showMenuSelection(menus.get(menuCategoryNum - 1));
            } else {
                System.out.println("잘못된 선택입니다. 메뉴 번호를 확인해주세요.");
            }
        }

    }

    // 특정 카테고리의 메뉴 출력 및 선택 처리
    public void showMenuSelection(Menu menu) {
        menu.showMenuItems(); // 해당 카테고리의 메뉴 출력
        while (true) {

            // 상세 메뉴 숫자 입력 받기
            System.out.print("\n메뉴를 선택하세요: ");
            int itemChoice = scanner.nextInt();

            // `0` 입력 시 뒤로가기
            if (itemChoice == 0) {
                break;
            }

            // 메뉴가 비어 있는지 확인
            if (menu.getMenuItems() == null || menu.getMenuItems().isEmpty()) {
                System.out.println("현재 선택한 카테고리에 메뉴가 없습니다.");
                return;
            }

            // 올바른 입력이라면 해당 메뉴 출력
            if (itemChoice >= 1 && itemChoice <= menu.getMenuItems().size()) {
                MenuItem selectedItem = menu.getMenuItems().get(itemChoice - 1);
                System.out.printf("선택한 메뉴: %s | W %.1f | %s",
                        selectedItem.getMenuName(), selectedItem.getPrice(), selectedItem.getDescription());
            } else {
                System.out.println("잘못된 선택입니다. 메뉴 번호를 확인해주세요.");
            }
        }
    }
}










