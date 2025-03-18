package org.KioskProject.challenge.level2;

import org.KioskProject.challenge.level2.cart.Cart;
import java.util.Scanner;
import static org.KioskProject.challenge.level2.util.InputUtil.getValidatedIntInput;

public class Order {
    private Cart cart;
    private Scanner scanner;

    // 생성자
    public Order(Cart cart){
        this.cart = cart;
        this.scanner = new Scanner(System.in);
    }

    /*
     *  주문 처리 또는 주문 취소를 처리하는 메서드
     */
    public void handleOrderOrCancel(int orderChoice) {
        // 장바구니가 비어있는지 확인
        if (cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다. 주문을 진행할 수 없습니다.");
            return;
        }

        // 사용자가 선택한 옵션이 '4'일 경우 (주문 확인)
        if (orderChoice == 4) {
            cart.showCart();
            int orderConfirm = getValidatedIntInput(scanner,"\n1. 주문    2. 메뉴판");
            // 주문을 진행할 경우
            if (orderConfirm == 1) {
                // 사용자 유형 선택
                UserType userType = selectUserType();
                // 선택한 사용자 유형에 맞는 할인 적용
                double discountedTotal = userType.applyDiscount(cart.getTotalPrice());
                System.out.printf("주문이 완료되었습니다. 총 금액: W %.1f (할인 적용)%n", discountedTotal);
                cart.clearCart();
            } else if (orderConfirm == 2) {
                System.out.println("메뉴판으로 돌아갑니다.");
            } else {
                System.out.println("잘못된 입력입니다.");
            }

        // 사용자가 선택한 옵션이 '5'일 경우 (주문 취소)
        } else if (orderChoice == 5) {
            System.out.println("진행 중인 주문을 취소합니다.");
            cart.clearCart();
        }
    }

    /*
     *  사용자 유형을 선택하는 메서드
     */
    private UserType selectUserType() {
        UserType.printDiscount();
        int userTypeNum = getValidatedIntInput(scanner, "");
        return UserType.from(userTypeNum);
    }
}
