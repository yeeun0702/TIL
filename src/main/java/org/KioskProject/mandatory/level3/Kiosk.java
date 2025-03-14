package org.KioskProject.mandatory.level3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems; // MenuItem 리스트
    private static Scanner scanner; // 스캐너 선언

    // 키오스크 내에 메뉴를 추가할 생성자
    Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.scanner = new Scanner(System.in);
    }

    // main 에서 관리하던 입력과 반복문 로직을 start 함수로 변경
    public void start() {
        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);

            // 형식에 맞춰 출력
            System.out.printf("%d. %-15s | W %-4.1f | %s%n",
                    i + 1, item.getMenuName(), item.getPrice(), item.getDescription());
        }
        System.out.println("0. 종료             | 종료");

        while (true) {
            System.out.println("메뉴를 입력하세요. 0 입력 시 프로그램을 종료합니다.");
            // 숫자를 입력 받기
            int n = scanner.nextInt();

            // 0 입력 시 프로그램 종료
            if (n == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 입력된 숫자에 따른 처리
            if (n >= 0 && n <= menuItems.size()) {
                MenuItem selectedItem = menuItems.get(n - 1); // 1부터 4까지 인덱스 가져오기
                System.out.printf("선택한 메뉴 : %d. %-15s | W %-4.1f | %s%n",
                        n, selectedItem.getMenuName(), selectedItem.getPrice(), selectedItem.getDescription());
            } else {
                System.out.println("잘못된 선택입니다. 메뉴 번호를 확인해주세요.");
            }
        }
    }
}









