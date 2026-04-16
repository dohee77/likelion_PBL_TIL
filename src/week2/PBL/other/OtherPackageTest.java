package week2.PBL.other;

import week2.PBL.domain.Lion;

public class OtherPackageTest {
    public static void main(String[] args) {

        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);

        // public → 가능
        lion.name = "홍길동";

        // ❌ 아래 두 개는 일부러 주석 풀면 컴파일 에러 발생해야 정상

        // lion.major = "경제학";
        // lion.generation = 20;
    }
}