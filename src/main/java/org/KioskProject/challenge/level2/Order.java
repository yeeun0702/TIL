package org.KioskProject.challenge.level2;

import org.KioskProject.challenge.level2.cart.Cart;

import java.util.Scanner;

public class Order {
    private Cart cart;
    private Scanner scanner;

    public Order(Cart cart){
        this.cart = cart;
        this.scanner = new Scanner(System.in);
    }

    public void handleOrderOrCancel(int orderChoice) {
        // 장바구니가 비어있는지 확인
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다. 주문을 진행할 수 없습니다.");
            return;
        }
        if (orderChoice == 4) {
            cart.showCart();
            int orderConfirm = getValidatedIntInput("\n1. 주문    2. 메뉴판");
            if (orderConfirm == 1) {
                UserType userType = selectUserType();
                double discountedTotal = userType.applyDiscount(cart.getTotalPrice());
                System.out.printf("주문이 완료되었습니다. 총 금액: W %.1f (할인 적용)%n", discountedTotal);
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

    private UserType selectUserType() {
        UserType.printDiscount();
        int userTypeNum = getValidatedIntInput("");
        return UserType.from(userTypeNum);
    }

    private int getValidatedIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                scanner.next();
            }
        }
    }
}
