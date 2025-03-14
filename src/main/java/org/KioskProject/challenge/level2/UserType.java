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
}
