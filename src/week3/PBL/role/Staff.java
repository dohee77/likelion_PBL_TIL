package week3.PBL.role;

import week3.PBL.policy.StaffSubmitPolicy;
import week3.PBL.policy.SubmitPolicy;

public class Staff extends Person {

    private String position;

    public Staff(String name,
                 String major,
                 int generation,
                 String part,
                 String position) {

        super(name, major, generation, part);
        this.position = position;
    }

    @Override
    protected SubmitPolicy getPolicy() {

        return new StaffSubmitPolicy();
    }

    @Override
    public String getInfo() {

        return
                "👤 역할: 운영진\n" +
                        "📌 이름: " + getName() +
                        " | 🎓 전공: " + getMajor() +
                        " | 🔢 기수: " + getGeneration() +
                        " | 💻 파트: " + getPart() + "\n" +
                        "⭐ 직책: " + position + "\n" +
                        "📝 과제 제출 가능: "
                        + (canSubmit() ? "✅ 가능" : "❌ 불가능");
    }
}