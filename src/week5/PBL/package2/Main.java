package week5.PBL.package2;

import week3.PBL.role.Lion;
import week3.PBL.role.Person;
import week3.PBL.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 저장소 선택
        System.out.println("🗂 저장소를 선택하세요:");

        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");

        System.out.print("선택: ");

        int choice = sc.nextInt();
        sc.nextLine();

        // 구현체 선택
        MemberRepository repository;

        if (choice == 1) {

            repository = new MemoryMemberRepository();

        } else {

            repository = new MockMemberRepository();
        }

        // 의존성 주입
        MemberService service = new MemberService(repository);

        while (true) {

            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁");

            System.out.println("1. ➕ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");

            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            // 등록
            if (menu == 1) {

                System.out.print("\n👤 역할 선택 (1: 아기사자, 2: 운영진): ");

                int role = sc.nextInt();
                sc.nextLine();

                System.out.println("\n📝 정보 입력");

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

                // 아기사자
                if (role == 1) {

                    System.out.print("학번 : ");
                    String studentId = sc.nextLine();

                    person = new Lion(
                            name,
                            major,
                            generation,
                            part,
                            studentId
                    );
                }

                // 운영진
                else {

                    System.out.print("직책 : ");
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

                    System.out.println("\n✅ 등록 완료: " + name);

                } else {

                    System.out.println("❌ 중복된 이름입니다.");
                }
            }

            // 전체 조회
            else if (menu == 2) {

                List<Person> members = service.getAllMembers();

                System.out.println("\n📋 ===== 전체 멤버 조회 =====");

                for (Person person : members) {

                    System.out.println(person.getInfo());
                    System.out.println();
                }
            }

            // 검색
            else if (menu == 3) {

                System.out.print("🔍 검색할 이름 : ");

                String name = sc.nextLine();

                Person person = service.searchByName(name);

                if (person == null) {

                    System.out.println("❌ 검색 결과 없음");

                } else {

                    System.out.println("\n🎯 ===== 검색 결과 =====");

                    System.out.println(person.getInfo());
                }
            }

            // 종료
            else if (menu == 4) {

                System.out.println("👋 프로그램 종료");

                break;
            }

            else {

                System.out.println("❌ 잘못된 입력");
            }
        }
    }
}