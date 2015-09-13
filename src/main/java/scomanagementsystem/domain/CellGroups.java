package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/21.
 */

@Entity
public class CellGroups implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Integer cgNo;
    private String studentNo;
    private String leader;
    private String venue;

    private CellGroups() {
    }

    public CellGroups(Builder builder) {
        id=builder.id;
        cgNo=builder.cgNo;
        studentNo=builder.studentNo;
        leader=builder.leader;
        venue=builder.venue;
    }

    public Long getId() {
        return id;
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

        private Long id;
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

        public Builder id(Long value) {
            this.id = value;
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

        public Builder copy(CellGroups value) {
            this.id = value.getId();
            this.cgNo = value.getCgNo();
            this.studentNo = value.getStudentNo();
            this.leader=value.getLeader();
            this.venue=value.getVenue();
            return this;
        }

        public CellGroups build() {
            return new CellGroups(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CellGroups)) return false;

        CellGroups that = (CellGroups) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "CellGroups{" +
                "id=" + id +
                ", cgNo=" + cgNo +
                ", studentNo=" + studentNo +
                ", leader='" + leader + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }
}
