package scomanagementsystem.Model;

import org.springframework.hateoas.ResourceSupport;
import scomanagementsystem.domain.GatheringTimes;

/**
 * Created by student on 2015/09/12.
 */
public class ServiceResourse extends ResourceSupport {
    private Integer serviceNo;
    private String serviceName;
    private String date;
    private String venue;
    private GatheringTimes gatheringTimes;

    private ServiceResourse() {
    }

    public ServiceResourse(Builder builder) {
        serviceNo=builder.serviceNo;
        serviceName=builder.serviceName;
        date=builder.date;
        venue=builder.venue;
        gatheringTimes=builder.gatheringTimes;
    }

    public Integer getServiceNo() {
        return serviceNo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDate() {
        return date;
    }

    public String  getVenue() {
        return venue;
    }

    public GatheringTimes getGatheringTimes() { return gatheringTimes; }

    public static class Builder {

        private Integer serviceNo;
        private String serviceName;
        private String date;
        private String venue;
        private GatheringTimes gatheringTimes;

        public Builder(Integer serviceNo) {
            this.serviceNo = serviceNo;
        }


        public Builder serviceName(String value) {
            this.serviceName = value;
            return this;
        }

        public Builder date(String value) {
            this.date = value;
            return this;
        }

        public Builder venue(String value) {
            this.venue = value;
            return this;
        }

        public Builder gatheringTimes(GatheringTimes value) {
            this.gatheringTimes = value;
            return this;
        }

        public Builder copy(ServiceResourse value) {
            this.serviceNo = value.getServiceNo();
            this.serviceName = value.getServiceName();
            this.date = value.getDate();
            this.venue = value.getVenue();
            this.gatheringTimes = value.getGatheringTimes();
            return this;
        }

        public ServiceResourse build() {
            return new ServiceResourse(this);
        }
    }
}
