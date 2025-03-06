# CH 2 프로그래밍 기초 주차

MVC 패턴을 적용하여 각 클래스가 단일 책임 원칙 (SRP)이 지켜지도록 노력했습니다.

## **📌MVC 패턴이란?**

**MVC(Model-View-Controller) 패턴**은 **애플리케이션을 세 가지 역할로 나누어 구조화하는 디자인 패턴**이다.

즉, **비즈니스 로직, 사용자 인터페이스, 입력 처리를 분리하여 코드의 유지보수성과 확장성을 높이는 구조**다.

### 1️⃣ **Model (모델)**

👉 **비즈니스 로직을 담당하며, 데이터를 처리하는 역할**

- 데이터를 저장하고 관리 (예: 계산 결과, 사용자 정보, 데이터베이스 연결)
- 비즈니스 로직 수행 (예: 사칙연산 처리, 데이터 검증)
- 외부와 직접 상호작용하지 않으며, **Controller를 통해 접근**됨

---

### 2️⃣ **View (뷰)**

👉 **사용자와 상호작용하는 역할 (입력/출력)**

- 사용자에게 정보를 출력하고, 입력을 받을 때 사용됨
- **비즈니스 로직을 포함하지 않으며, UI 요소만 담당**
- 데이터를 **Controller를 통해 전달받아 출력**

---

### 3️⃣ **Controller (컨트롤러)**

👉 **Model과 View를 연결하여 흐름을 제어하는 역할**

- 사용자 입력을 받아 Model에 전달하고, 처리된 데이터를 View에 전달
- Model과 View를 분리하여 **비즈니스 로직이 View에 포함되지 않도록 관리**
- 프로그램의 흐름을 제어하고 예외 처리를 담당

### 필수과제

https://github.com/yeeun0702/TIL/pull/2

### Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기

### Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기

컬렉션의 경우, 다음 내용을 정리하면서 공부했습니다.

https://yeunever.tistory.com/19

```java
public void removeResult() {
    if (resultList.isEmpty()) {
        throw new CalculationException(ErrorMessage.INVALID_DELETE_NO_RESULT);
    }
    resultList.remove(0);
}
```

리스트의 **첫 번째 요소(index 0) 제거**


### 도전과제

### 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기
https://github.com/yeeun0702/TIL/pull/4

`Enum` 과 람다식을 활용하여 연산자를 선택할 때 복잡한 `switch` 문을 한결 더 간편하게 변경했습니다.

람다식의 경우, 다음을 정리하면서 공부했습니다.

https://yeunever.tistory.com/21

```java
public enum OperatorType {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new DivideByZeroException(ErrorMessage.INVALID_DIVIDEBYZERO);
        return a / b;
    });
```

### 📌 궁금한 점

도전과제에도 리뷰어님의 리뷰를 받은 후, MVC 패턴을 적용해서 리팩토링할 예정입니다 !

`Model` 에 
계산기 (`ArithmeticCalculator`)

숫자 입력 검증 (`getValidatedNumber`), 

연산자 검증 (`getValidatedOperator`), 

연산 결과 삭제 확인 (`confirmAndRemoveResult`), 

프로그램 종료 여부 (`confirmContinue`)

다음과 같은 기능으로 나누어서 적용하고, Lv2 와 동일하게 Controller와 View를 구현하려고 생각하고 있는데 혹시, 더 좋은 방향이 있다면 알려주세요 !

혹은 디자인 패턴 적용 이외의 이러한 기능이 추가되면 좋겠다 ! 라고 생각되는 기능이 있다면 추천해주시면 좋을 것 같아요. 

+++ 요구사항 조건이 맞지 않는 부분, 혹은 더 간결하게  개선할 수 있는 부분을 알고 싶습니다.
