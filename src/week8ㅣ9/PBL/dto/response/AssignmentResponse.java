package week8ㅣ9.PBL.dto.response;

import week8ㅣ9.PBL.domain.Assignment;

public class AssignmentResponse {

    private Long id;
    private String title;
    private String description;

    private Long memberId;
    private String memberName;

    public AssignmentResponse(Assignment assignment) {

        this.id = assignment.getId();
        this.title = assignment.getTitle();
        this.description = assignment.getDescription();

        this.memberId = assignment.getMember().getId();
        this.memberName = assignment.getMember().getName();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }
}