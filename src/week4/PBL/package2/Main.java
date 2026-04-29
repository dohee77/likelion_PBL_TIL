package week4.PBL.package2;

import week3.PBL.role.*;
import java.util.*;

public class Main {

    static List<Person> members = new ArrayList<>();
    static Map<String, List<Person>> partMap = new HashMap<>();

    // 중복 검사
    static boolean isDuplicate(String name) {
        for (Person p : members) {
            if (p.getName().equals(name)) return true;
        }
        return false;
    }

    // 멤버 등록
    static void register(Scanner sc) {
        System.out.println("\n── 📝 멤버 등록 ──");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        if (isDuplicate(name)) {
            System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
            return;
        }

        System.out.print("🎓 전공: ");
        String major = sc.nextLine();

        System.out.print("📌 기수: ");
        int gen = sc.nextInt();
        sc.nextLine();

        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = sc.nextLine();

        Person p;

        if (choice == 1) {
            System.out.print("🆔 학번: ");
            String studentId = sc.nextLine();
            p = new Lion(name, major, gen, part, studentId);
        } else {
            System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
            String position = sc.nextLine();
            p = new Staff(name, major, gen, part, position);
        }

        members.add(p);

        // 🔥 핵심: Map에도 추가
        partMap.putIfAbsent(part, new ArrayList<>());
        partMap.get(part).add(p);

        System.out.println("✅ 등록 완료: " + name);
    }

    // 전체 조회
    static void showAll() {
        System.out.println("\n── 📋 전체 멤버 목록 ──");

        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        int idx = 1;
        for (Person p : members) {
            String role = (p instanceof Lion) ? "아기사자" : "운영진";
            System.out.println(idx + ". [" + role + "] " + p.getName() + " - " + p.getGeneration() + "기");
            idx++;
        }

        System.out.println("📊 총 " + members.size() + "명");
    }

    // 이름 검색
    static void search(Scanner sc) {
        System.out.println("\n── 🔍 이름으로 검색 ──");
        System.out.print("검색할 이름: ");
        String name = sc.nextLine();

        for (Person p : members) {
            if (p.getName().equals(name)) {
                System.out.println("\n✨ [검색 결과]");
                System.out.println(p.getInfo());
                System.out.println("📌 과제 제출 가능 여부: " + (p.canSubmit() ? "✅ 가능" : "❌ 불가능"));
                return;
            }
        }

        System.out.println("❌ 해당 멤버 없음");
    }

    // 파트별 조회
    static void showByPart(Scanner sc) {
        System.out.println("\n── 📂 파트별 조회 ──");
        System.out.println("📁 등록된 파트: " + partMap.keySet());

        System.out.print("조회할 파트: ");
        String part = sc.nextLine();

        if (!partMap.containsKey(part)) {
            System.out.println("❌ 해당 파트 없음");
            return;
        }

        System.out.println("\n✨ [" + part + " 파트 멤버]");

        int idx = 1;
        for (Person p : partMap.get(part)) {
            String role = (p instanceof Lion) ? "아기사자" : "운영진";
            System.out.println(idx + ". " + p.getName() + " (" + role + ") - " + p.getGeneration() + "기");
            idx++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== 🦁 멤버 관리 시스템 ======");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 파트별 조회");
            System.out.println("5. 종료");
            System.out.print("선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) register(sc);
            else if (menu == 2) showAll();
            else if (menu == 3) search(sc);
            else if (menu == 4) showByPart(sc);
            else if (menu == 5) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("❌ 잘못된 입력");
            }
        }
    }
}