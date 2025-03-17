package org.KioskProject.mandatory.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>(
                List.of(
                        new MenuItem("ShackBurger", 6.5, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                        new MenuItem("SmokeBurger", 8.5, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                        new MenuItem("CheeseBurger", 5.5, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                        new MenuItem("Hamburger", 4.5, "비프패티를 기반으로 야채가 들어간 기본버거")
                )
        );

        // Scanner 선언
        Scanner scanner = new Scanner(System.in);

        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.printf("%d. %-15s | W %-4.1f | %s%n",
                    i + 1, item.getMenuName(), item.getPrice(), item.getDescription());
        }
        System.out.println("0. 종료             | 종료");

        while (true) {

            System.out.println("메뉴를 입력하세요. 0 입력 시 키오스크가 종료됩니다.");
            // 숫자를 입력 받기
            int n = scanner.nextInt();

            // 0 입력 시 프로그램 종료
            if (n == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }

            // 입력된 숫자에 따른 처리
            if (n >= 0 && n <= menuItems.size()) {
                MenuItem selectedItem = menuItems.get(n - 1); // 1부터 4까지 인덱스 가져오기
                System.out.printf("선택한 메뉴 : %d. %-15s | W %-4.1f | %s%n",
                        n, selectedItem.getMenuName(), selectedItem.getPrice(), selectedItem.getDescription());
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다. 메뉴 번호를 확인해주세요.");
            }
        }
        scanner.close();
    }


}

