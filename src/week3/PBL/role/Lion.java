package week3.PBL.role;

import week3.PBL.policy.LionSubmitPolicy;
import week3.PBL.policy.SubmitPolicy;

public class Lion extends Person {

    private String studentId;

    public Lion(String name,
                String major,
                int generation,
                String part,
                String studentId) {

        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    protected SubmitPolicy getPolicy() {

        return new LionSubmitPolicy();
    }

    @Override
    public String getInfo() {

        return
                "👤 역할: 아기사자\n" +
                        "📌 이름: " + getName() +
                        " | 🎓 전공: " + getMajor() +
                        " | 🔢 기수: " + getGeneration() +
                        " | 💻 파트: " + getPart() + "\n" +
                        "🆔 학번: " + studentId + "\n" +
                        "📝 과제 제출 가능: "
                        + (canSubmit() ? "✅ 가능" : "❌ 불가능");
    }
}