package scomanagementsystem.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/12.
 */
public class CellGroupsResource extends ResourceSupport {
    private Integer cgNo;
    private String studentNo;
    private String leader;
    private String venue;

    private CellGroupsResource() {
    }

    public CellGroupsResource(Builder builder) {
        cgNo=builder.cgNo;
        studentNo=builder.studentNo;
        leader=builder.leader;
        venue=builder.venue;
    }

    public Integer getCgNo() {
        return cgNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public String getLeader() {
        return leader;
    }

    public String getVenue() {
        return venue;
    }

    public static class Builder {

        private Integer cgNo;
        private String studentNo;
        private String leader;
        private String venue;

        public Builder(Integer cgNo) {
            this.cgNo = cgNo;
        }


        public Builder studentNo(String value) {
            this.studentNo = value;
            return this;
        }

        public Builder leader(String value){
            this.leader = value;
            return this;
        }

        public Builder venue(String value){
            this.venue = value;
            return this;
        }

        public Builder copy(CellGroupsResource value) {
            this.cgNo = value.getCgNo();
            this.studentNo = value.getStudentNo();
            this.leader=value.getLeader();
            this.venue=value.getVenue();
            return this;
        }

        public CellGroupsResource build() {
            return new CellGroupsResource(this);
        }

    }
}
