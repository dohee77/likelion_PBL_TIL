package week3.PBL.role;

import week3.PBL.policy.LionSubmitPolicy;
import week3.PBL.policy.SubmitPolicy;

public class Lion extends Person {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    protected SubmitPolicy getPolicy() {
        return new LionSubmitPolicy();
    }

    @Override
    public String getInfo() {
        return "======== \uD83D\uDCDD 결과 출력 ========\n" + "\n" +
                "🎭 역할: 아기사자\n" +
                "\uD83D\uDC64 이름: " + getName() + " | \uD83C\uDF93 전공: " + getMajor() +
                " | \uD83D\uDCCC 기수: " + getGeneration() +
                " | \uD83D\uDCBB 파트 (벡엔드/프론트엔드/기획/디자인): " + getPart() + "\n" +
                "\uD83C\uDD94 학번: " + studentId;
    }
}
