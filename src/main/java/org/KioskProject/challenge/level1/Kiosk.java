package org.KioskProject.challenge.level1;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus; // 메뉴 카테고리의 메뉴들 (Burgers, Drinks, Desserts)을 리스트로 관리
    private Cart cart;
    private Scanner scanner;

    public Kiosk(List<Menu> menus) { // 키오스크 속에 메뉴들을 생성
        this.menus = menus;
        this.cart = new Cart();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) { // 프로그램 반복 실행

            // 메인 메뉴 출력
            printMainMenu();

            // 장바구니 기능
            cart.printOrderMenu();

            // 메뉴 카테고리 숫자를 입력 받기
            int menuCategoryNum = scanner.nextInt();

            // 0 입력 시 프로그램 종료
            if (menuCategoryNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 주문 확인 및 취소 기능 추가
            if (!cart.isEmpty() && (menuCategoryNum == 4 || menuCategoryNum == 5)) {
                handleOrderOrCancel(menuCategoryNum);
                continue;
            }

            //  메뉴 선택 처리 - 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            if (menuCategoryNum >= 0 && menuCategoryNum <= menus.size()) {
                // showMenuItems 메서드를 활용하여 메뉴에 접근
                showMenuItems(menus.get(menuCategoryNum - 1));
            } else {
                System.out.println("잘못된 선택입니다. 메뉴 번호를 확인해주세요.");
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
     * 선택한 메뉴 출력
     */
    private void printSelectedMenu(Menu menu, int itemChoice) {
        MenuItem selectedItem = menu.getMenuItems().get(itemChoice - 1);
        System.out.printf("선택한 메뉴: %s | W %.1f | %s\n",
                selectedItem.getMenuName(), selectedItem.getPrice(), selectedItem.getDescription());
    }

    /**
     * 특정 카테고리의 메뉴 출력 및 선택 처리
     */
    public void showMenuItems(Menu menu) {

        while (true) {

            menu.showMenuItems(); // 해당 카테고리의 메뉴 출력
            // 상세 메뉴 숫자 입력 받기
            System.out.print("메뉴를 선택하세요: ");
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
                printSelectedMenu(menu, itemChoice);

                // 장바구니 추가 확인
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n" + "1. 확인        2. 취소");

                int addCartChoice = scanner.nextInt();

                if (addCartChoice == 1) {
                    cart.addCart(selectedItem);
                    break;
                } else if (addCartChoice == 2) {
                    System.out.println("메뉴 추가가 취소되었습니다.");
                } else {
                    System.out.println("잘못된 입력입니다.");
                }

            } else {
                System.out.println("잘못된 선택입니다. 메뉴 번호를 확인해주세요.");
            }
        }
    }

    /**
     * 주문 처리 및 취소
     */
    private void handleOrderOrCancel(int orderChoice) {
        if (orderChoice == 4) {
            cart.showCart();
            System.out.println("\n1. 주문    2. 메뉴판");

            int orderConfirm = scanner.nextInt();
            if (orderConfirm == 1) {
                System.out.printf("주문이 완료되었습니다. 총 금액은 W %.1f 입니다.%n", cart.getTotalPrice());
                cart.clearCart();
            } else if (orderConfirm == 2) {
                System.out.println("메뉴판으로 돌아갑니다.");
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        } else if (orderChoice == 5) {
            System.out.println("진행 중인 주문을 취소합니다.");
            cart.clearCart();
        }
    }
}











