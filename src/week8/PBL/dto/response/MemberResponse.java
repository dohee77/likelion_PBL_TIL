package week8.PBL.dto.response;

import week8.PBL.domain.Member;

public class MemberResponse {

    private Long id;
    private String name;
    private String major;
    private int generation;
    private String part;
    private String roleName;
    private String studentId;
    private String position;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.major = member.getMajor();
        this.generation = member.getGeneration();
        this.part = member.getPart();
        this.roleName = member.getRoleType().getDisplayName();
        this.studentId = member.getStudentId();
        this.position = member.getPosition();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getRoleName() { return roleName; }
    public String getStudentId() { return studentId; }
    public String getPosition() { return position; }
}