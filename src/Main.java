import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count;

        while (true) {
            System.out.print("\uD83E\uDD81 저장할 아기사자 수를 5 이상 입력해주세요.\n");
            count = sc.nextInt();

            if (count >= 5) {
                break;
            } else {
                System.out.println("❗[오류] 5 이상의 입력해주세요.");
            }
        }

        String[] lions = new String[count];

        sc.nextLine();

        System.out.println("✏\uFE0F " + "아기사자 이름을 입력해주세요.");
        for (int i = 0; i < count; i++) {
            lions[i] = sc.nextLine();
        }

        System.out.println("\n📋 아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0; i < count; i++) {
            System.out.println("\uD83E\uDD81 " + (i + 1) + ". " + lions[i]);
        }

        sc.close();
    }
}