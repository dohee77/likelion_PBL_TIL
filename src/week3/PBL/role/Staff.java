package week3.PBL.role;

import week3.PBL.policy.StaffSubmitPolicy;
import week3.PBL.policy.SubmitPolicy;

public class Staff extends Person {
    private String position;

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    protected SubmitPolicy getPolicy() {
        return new StaffSubmitPolicy();
    }

    @Override
    public String getInfo() {
        return "🎭 역할: 운영진\n" +
                "\uD83D\uDC64 이름: " + getName() + " | \uD83C\uDF93 전공: " + getMajor() +
                " | \uD83D\uDCCC 기수: " + getGeneration() +
                " | \uD83D\uDCBB 파트 (벡엔드/프론트엔드/기획/디자인): " + getPart() + "\n" +
                "⭐ 직책 (대표/부대표/파트장/멘토): " + position;
    }
}