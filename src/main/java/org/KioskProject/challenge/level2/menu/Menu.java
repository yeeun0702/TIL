package org.KioskProject.challenge.level2.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // 카테고리 이름 필드 추가
    private final String categoryName;

    // MenuItem 클래스를 List로 관리
    private final List<MenuItem> menuItems;

    // 생성자
    public Menu(String categoryName, List<MenuItem> menuItems ) {
        this.categoryName = categoryName;
        this.menuItems = menuItems;
    }

    // List에 포함된 MenuItem을 순차적으로 보여주는 함수
    public void showMenuItems() {
        System.out.println("\n[ " + categoryName + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.printf("%d. %-15s | W %-4.1f | %s%n",
                    i + 1, item.getMenuName(), item.getPrice(), item.getDescription());
        }
        System.out.println("0. 뒤로가기");
    }

    // List를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // getter
    public String getCategoryName() {
        return categoryName;
    }

}

