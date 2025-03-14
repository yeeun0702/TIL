package org.KioskProject.challenge.level1;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    // 장바구니에 물건 담기
    public void addCart(MenuItem menuItem) {
        for (CartItem item : cartItems) {
            if (item.getMenuItem().getMenuName().equals(menuItem.getMenuName())) {
                item.increaseQuantity();
                return;
            }
        }
        cartItems.add(new CartItem(menuItem, 1));
        System.out.println(menuItem.getMenuName() + "이(가) 장바구니에 추가되었습니다.");
    }

    // 장바구니가 비어있지 않을 경우 [ ORDER MENU ] 출력
    public void printOrderMenu() {
        if (!cartItems.isEmpty()) {
            System.out.println("\n[ ORDER MENU ]\n" +
                    "4. Orders       | 장바구니를 확인 후 주문합니다.\n" +
                    "5. Cancel       | 진행 중인 주문을 취소합니다.");
        }
    }


    // 장바구니에 담긴 목록 및 금액 출력
    public void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        double total = 0;
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n[ Orders ]");
        for (CartItem cartItem : cartItems) {
            System.out.printf("%s | W %.1f | %s | \n",
                    cartItem.getMenuItem().getMenuName(),
                    cartItem.getMenuItem().getPrice(),
                    cartItem.getMenuItem().getDescription());
            total += cartItem.getTotalPrice();
        }
        System.out.printf("\n[ Total ]\nW %.1f" , total);
    }

    // 장바구니 비우기
    public void clearCart() {
        cartItems.clear();
    }

    // 장바구니가 비어있는지 확인하기
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    // 전체 금액 계산
    public double getTotalPrice(){
        double total = 0;
        for(CartItem cartItem : cartItems){
            total += cartItem.getTotalPrice();
        }
        return total;
    }
}

