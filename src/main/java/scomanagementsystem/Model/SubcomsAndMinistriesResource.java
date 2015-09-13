package scomanagementsystem.Model;

import org.springframework.hateoas.ResourceSupport;
import scomanagementsystem.domain.GatheringTimes;
import scomanagementsystem.domain.Membership;

import javax.persistence.Embedded;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public class SubcomsAndMinistriesResource extends ResourceSupport {
    private Integer smNo;
    private String name;
    private String studNo;
    private String leader;
    private String venue;
    private List<Membership> membership;
    private GatheringTimes gatheringTimes;

    private SubcomsAndMinistriesResource() {
    }

    public SubcomsAndMinistriesResource(Builder builder) {
        smNo=builder.smNo;
        name=builder.name;
        studNo=builder.studNo;
        leader=builder.leader;
        venue=builder.venue;
        membership=builder.membership;
        gatheringTimes=builder.gatheringTimes;
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

    public String  getVenue() {
        return venue;
    }

    public List<Membership> getMembership() { return membership; }

    public GatheringTimes getGatheringTimes() { return gatheringTimes; }

    public static class Builder {

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


        public Builder copy(SubcomsAndMinistriesResource value) {
            this.smNo = value.getSmNo();
            this.name = value.getName();
            this.studNo = value.getStudNo();
            this.leader = value.getLeader();
            this.venue = value.getVenue();
            this.membership = value.getMembership();
            this.gatheringTimes = value.getGatheringTimes();
            return this;
        }

        public SubcomsAndMinistriesResource build() {
            return new SubcomsAndMinistriesResource(this);
        }
    }
}
