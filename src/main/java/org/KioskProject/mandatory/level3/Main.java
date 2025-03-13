package org.KioskProject.mandatory.level3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 메뉴 아이템 리스트 생성 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();

        // Item> menuItems는 Kiosk 생성자를 통해 값을 할당 (메뉴 추가)
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menuItems);

        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
