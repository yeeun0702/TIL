package org.KioskProject.challenge.level2;

import org.KioskProject.challenge.level2.menu.Menu;
import org.KioskProject.challenge.level2.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Menu 객체 생성하면서 카테고리 이름 설정
        // 버거 메뉴 생성
        Menu burgerMenu = new Menu("BURGERS",
                new ArrayList<>(
                        List.of(
                                new MenuItem("ShackBurger", 6.5, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                                new MenuItem("SmokeBurger", 8.5, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                                new MenuItem("CheeseBurger", 5.5, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                                new MenuItem("Hamburger", 4.5, "비프패티를 기반으로 야채가 들어간 기본버거")
                        )
                )
        );
        // 음료 메뉴 생성
        Menu drinkMenu = new Menu("Drinks",
                new ArrayList<>(
                        List.of(
                                new MenuItem("Coca Cola", 2.5, "시원한 코카콜라"),
                                new MenuItem("Sprite", 2.5, "청량한 스프라이트")
                        )
                )
        );

        // 디저트 메뉴 생성
        Menu dessertMenu = new Menu("Desserts",
                new ArrayList<>(
                        List.of(
                                new MenuItem("Chocolate Cake", 4.5, "달콤한 초콜릿 케이크"),
                                new MenuItem("Vanilla Ice Cream", 3.5, "부드러운 바닐라 아이스크림"),
                                new MenuItem("Strawberry Cheesecake", 5.0, "상큼한 딸기 치즈케이크"),
                                new MenuItem("Macarons", 6.0, "다양한 맛의 마카롱 세트")
                        )
                )
        );

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
