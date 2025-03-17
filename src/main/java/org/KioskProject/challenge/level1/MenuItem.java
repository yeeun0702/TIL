package org.KioskProject.challenge.level1;

public class MenuItem {
    private final String menuName; // 이름
    private final double price; // 가격
    private final String description; // 설명

    // 생성자
    public MenuItem(String menuName, double price, String description){
        this.menuName = menuName;
        this.price = price;
        this.description = description;
    };

    public String getMenuName(){ return menuName;}

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
