package org.KioskProject.challenge.level2.cart;

import org.KioskProject.challenge.level2.menu.MenuItem;

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


    public void removeCart(MenuItem menuItem){
        cartItems.remove(new CartItem(menuItem, 1));
        System.out.println(menuItem.getMenuName() + "이(가) 장바구니에서 삭제되었습니다.");
    }

    // 장바구니가 비어있지 않을 경우 [ ORDER MENU ] 출력
    public void printOrderMenu() {
        if (!cartItems.isEmpty()) {
            System.out.println("\n[ ORDER MENU ]\n" +
                    "4. Orders       | 장바구니를 확인 후 주문합니다.\n" +
                    "5. Cancel       | 진행 중인 주문을 취소합니다.");
        }
    }

    // 장바구니 출력
    public void showCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }
        System.out.println("\n아래와 같이 주문 하시겠습니까?\n[ Orders ]");
        printCartItems();
        System.out.printf("\n[ Total ]\nW %.1f%n", getTotalPrice());
    }

    // 장바구니 내 모든 항목 출력
    private void printCartItems() {
        cartItems.forEach(cartItem -> System.out.printf("%s | W %.1f | %s | 수량: %d%n",
                cartItem.getMenuItem().getMenuName(),
                cartItem.getMenuItem().getPrice(),
                cartItem.getMenuItem().getDescription(),
                cartItem.getQuantity()));
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
    public double getTotalPrice() {
        return cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

}