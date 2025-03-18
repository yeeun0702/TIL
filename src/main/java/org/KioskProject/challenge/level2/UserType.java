package org.KioskProject.challenge.level2;

public enum UserType {
    NATIONALMERIT(10), // 국가유공자 (10% 할인)
    SOLDIER(5), // 군인 (5% 할인)
    STUDENT(3), // 학생 (3% 할인)
    GENERAL(0); // 일반인 (할인 없음)

    private final int discountRate; // 할인율

    UserType(int discountRate){
        this.discountRate = discountRate;
    }

    /**
     *  할인을 적용하여 계산하는 메서드
     */
    public double applyDiscount(double price) {
        return price * (1 - discountRate / 100.0);
    }

    /**
     *  할인 정보를 입력하는 메서드
     */
    public static void printDiscount(){
        System.out.println("할인 정보를 입력해주세요.\n" +
                "1. 국가유공자 : 10% \n" +
                "2. 군인     :  5%\n" +
                "3. 학생     :  3%\n" +
                "4. 일반     :  0%");
    }


    /**
     *  입력에 따른 UserType 반환
     */
    public static UserType from(int userTypeNum) {
        switch (userTypeNum) {
            case 1: return NATIONALMERIT;
            case 2: return SOLDIER;
            case 3: return STUDENT;
            case 4: return GENERAL;
            default:
                System.out.println("잘못된 입력입니다. 기본값(일반)으로 설정합니다.");
                return GENERAL;
        }
    }
}
