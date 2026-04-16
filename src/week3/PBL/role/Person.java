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

    protected abstract SubmitPolicy getPolicy();

    public boolean canSubmit() {
        return getPolicy().canSubmit();
    }

    public abstract String getInfo();

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
}
