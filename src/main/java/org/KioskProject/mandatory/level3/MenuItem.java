package org.KioskProject.mandatory.level3;


public class MenuItem {
    String menuName; // 이름
    double price; // 가격
    String description; // 설명

    // 생성자
    public MenuItem(String menuName, double price, String description){
        this.menuName = menuName;
        this.price = price;
        this.description = description;
    };

    public String getMenuName(){
        return menuName;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
