package org.KioskProject.mandatory.level45;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Menu 객체 생성하면서 카테고리 이름 설정
        Menu burgerMenu = new Menu("Burgers");
        Menu drinkMenu = new Menu("Drinks");
        Menu dessertMenu = new Menu("Desserts");

        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        // 버거 메뉴 생성
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료 메뉴 생성
        drinkMenu.addMenuItem(new MenuItem("Coca Cola", 2.5, "시원한 코카콜라"));
        drinkMenu.addMenuItem(new MenuItem("Sprite", 2.5, "청량한 스프라이트"));

        // 디저트 메뉴 생성
        dessertMenu.addMenuItem(new MenuItem("Chocolate Cake", 4.5, "달콤한 초콜릿 케이크"));
        dessertMenu.addMenuItem(new MenuItem("Bubble tea", 5.5, "쫀득한 버블티"));

        // Kiosk에 메뉴 추가
        List<Menu> menus = new ArrayList<>();
        menus.add(burgerMenu);
        menus.add(drinkMenu);
        menus.add(dessertMenu);

        // Kiosk 실행
        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
