package week5.PBL.package1;

import week3.PBL.role.Lion;
import week3.PBL.role.Person;
import week3.PBL.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MemberService service = new MemberService();

        while (true) {

            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step1) ===== 🦁");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {

                System.out.print("역할 선택 (1. 아기사자, 2. 운영진): ");
                int role = sc.nextInt();
                sc.nextLine();

                System.out.print("이름: ");
                String name = sc.nextLine();

                System.out.print("전공: ");
                String major = sc.nextLine();

                System.out.print("기수: ");
                int generation = sc.nextInt();
                sc.nextLine();

                System.out.print("파트: ");
                String part = sc.nextLine();

                Person person;

                if (role == 1) {

                    System.out.print("학번: ");
                    String studentId = sc.nextLine();

                    person = new Lion(
                            name,
                            major,
                            generation,
                            part,
                            studentId
                    );

                } else {

                    System.out.print("직책: ");
                    String position = sc.nextLine();

                    person = new Staff(
                            name,
                            major,
                            generation,
                            part,
                            position
                    );
                }

                boolean result = service.register(person);

                if (result) {
                    System.out.println("✅ 등록 완료!");
                } else {
                    System.out.println("❌ 이미 존재하는 이름입니다.");
                }

            } else if (menu == 2) {

                List<Person> members = service.getAllMembers();

                System.out.println("\n===== 전체 멤버 조회 =====");

                for (Person person : members) {
                    System.out.println(person.getInfo());
                    System.out.println();
                }

            } else if (menu == 3) {

                System.out.print("검색할 이름: ");
                String name = sc.nextLine();

                Person person = service.searchByName(name);

                if (person == null) {
                    System.out.println("❌ 검색 결과 없음");
                } else {
                    System.out.println(person.getInfo());
                }

            } else if (menu == 4) {

                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}