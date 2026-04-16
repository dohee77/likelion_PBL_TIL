package week3.PBL;

import week3.PBL.role.Lion;
import week3.PBL.role.Person;
import week3.PBL.role.Staff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 아기사자 입력
        System.out.println("======== 🦁 아기사자 정보 입력 ========");
        System.out.print("\uD83D\uDC64 이름: ");
        String name1 = sc.nextLine();
        System.out.print("\uD83C\uDF93 전공: ");
        String major1 = sc.nextLine();
        System.out.print("\uD83D\uDCCC 기수: ");
        int gen1 = sc.nextInt();
        sc.nextLine();
        System.out.print("\uD83D\uDCBB 파트: ");
        String part1 = sc.nextLine();
        System.out.print("\uD83C\uDD94 학번: ");
        String id = sc.nextLine();

        Person lion = new Lion(name1, major1, gen1, part1, id);

        // 운영진 입력
        System.out.println("======== \uD83E\uDDD1\u200D\uD83D\uDCBC 운영진 정보 입력 ========");
        System.out.print("\uD83D\uDC64 이름: ");
        String name2 = sc.nextLine();
        System.out.print("\uD83C\uDF93 전공: ");
        String major2 = sc.nextLine();
        System.out.print("\uD83D\uDCCC 기수: ");
        int gen2 = sc.nextInt();
        sc.nextLine();
        System.out.print("\uD83D\uDCBB 파트: ");
        String part2 = sc.nextLine();
        System.out.print("⭐ 직책: ");
        String position = sc.nextLine();

        Person staff = new Staff(name2, major2, gen2, part2, position);

        // 출력
        printResult(lion);
        printResult(staff);
    }

    private static void printResult(Person p) {
        System.out.println(p.getInfo());
        System.out.println("\uD83D\uDCDD 과제 제출 가능 여부: " +
                (p.canSubmit() ? "✅ 가능" : "❌ 불가능"));
        System.out.println("----------------------");
    }
}