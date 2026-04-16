package week3.PBL.role;

import week3.PBL.policy.SubmitPolicy;

public abstract class Person {
    private String name;
    private String major;
    private int generation;
    private String part;

    public Person(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    // 🔥 정책 반환 (다형성 핵심)
    protected abstract SubmitPolicy getPolicy();

    // 🔥 제출 가능 여부 판단 (위임)
    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    // 🔥 정보 출력 (추상)
    public abstract String getInfo();

    // getter (private 필드 접근용)
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
}
