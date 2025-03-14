package org.KioskProject.challenge.level2;

public enum UserType {
    NATIONALMERIT(10),
    SOLDIER(5),
    STUDENT(3),
    GENERAL(0);

    private final int discountRate;

    UserType(int discountRate){
        this.discountRate = discountRate;
    }

    public double applyDiscount(double price) {
        return price * (1 - discountRate / 100.0);
    }

    public int getDiscountRate(){
        return  discountRate;
    }

    public static void printDiscount(){
        System.out.println("할인 정보를 입력해주세요.\n" +
                "1. 국가유공자 : 10% \n" +
                "2. 군인     :  5%\n" +
                "3. 학생     :  3%\n" +
                "4. 일반     :  0%");
    }

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
