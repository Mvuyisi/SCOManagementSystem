package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@Entity
public class SubcomsAndMinistries implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Integer smNo;
    private String name;
    private String studNo;
    private String leader;
    private String venue;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "smNo")
    private List<Membership> membership;
    @Embedded
    private GatheringTimes gatheringTimes;

    private SubcomsAndMinistries() {
    }

    public SubcomsAndMinistries(Builder builder) {
        id=builder.id;
        smNo=builder.smNo;
        name=builder.name;
        studNo=builder.studNo;
        leader=builder.leader;
        venue=builder.venue;
        membership=builder.membership;
        gatheringTimes=builder.gatheringTimes;
    }

    public Long getId() {
        return id;
    }

    public Integer getSmNo() {
        return smNo;
    }

    public String getName() {
        return name;
    }

    public String getStudNo() {
        return studNo;
    }

    public String getLeader() {
        return leader;
    }

    public String getVenue() {
        return venue;
    }

    public List<Membership> getMembership() { return membership; }

    public GatheringTimes getGatheringTimes() { return gatheringTimes; }

    public static class Builder {

        private Long id;
        private Integer smNo;
        private String name;
        private String studNo;
        private String leader;
        private String venue;
        private List<Membership> membership;
        private GatheringTimes gatheringTimes;

        public Builder(Integer smNo) {
            this.smNo = smNo;
        }


        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder studNo(String value) {
            this.studNo = value;
            return this;
        }

        public Builder leader(String value) {
            this.leader = value;
            return this;
        }

        public Builder venue(String value) {
            this.venue = value;
            return this;
        }

        public Builder membership(List<Membership> value) {
            this.membership = value;
            return this;
        }

        public Builder gatheringTimes(GatheringTimes value) {
            this.gatheringTimes = value;
            return this;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder copy(SubcomsAndMinistries value) {
            this.id = value.getId();
            this.smNo = value.getSmNo();
            this.name = value.getName();
            this.studNo = value.getStudNo();
            this.leader = value.getLeader();
            this.venue = value.getVenue();
            this.membership = value.getMembership();
            this.gatheringTimes = value.getGatheringTimes();
            return this;
        }

        public SubcomsAndMinistries build() {
            return new SubcomsAndMinistries(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubcomsAndMinistries)) return false;

        SubcomsAndMinistries that = (SubcomsAndMinistries) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "SubcomsAndMinistries{" +
                "id=" + id +
                ", smNo=" + smNo +
                ", name='" + name + '\'' +
                ", studNo='" + studNo + '\'' +
                ", leader='" + leader + '\'' +
                ", venue='" + venue + '\'' +
                ", membership=" + membership +
                ", gatheringTimes=" + gatheringTimes +
                '}';
    }
}
