package org.KioskProject.challenge.level2.cart;

import org.KioskProject.challenge.level2.menu.MenuItem;

public class CartItem {
    private MenuItem menuItem; // 메뉴명
    private int quantity; // 수량

    CartItem(MenuItem menuItem, int quantity){
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem(){
        return menuItem;
    }

    public int getQuantity(){
        return quantity;
    }

    public void increaseQuantity() { this.quantity++; }

    public double getTotalPrice(){
        return  menuItem.getPrice() * quantity;
    }
}
