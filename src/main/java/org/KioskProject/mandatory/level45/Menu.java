package org.KioskProject.mandatory.level45;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // 카테고리 이름 필드 추가
    private String categoryName;

    // MenuItem 클래스를 List로 관리
    private List<MenuItem> menuItems;

    // 생성자
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public void showMenuItems() {
        System.out.println("[ " + categoryName + " MENU ]");

        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.printf("%d. %-15s | W %-4.1f | %s%n",
                    i + 1, item.getMenuName(), item.getPrice(), item.getDescription());
        }
        System.out.print("0. 뒤로가기");
    }

    // List를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // MenuItem을 리스트에 추가하는 함수
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public String getCategoryName() {
        return categoryName;
    }

}

