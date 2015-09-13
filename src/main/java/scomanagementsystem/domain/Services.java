package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Entity
public class Services implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Integer serviceNo;
    private String serviceName;
    private String date;
    private String venue;
    @Embedded
    private GatheringTimes gatheringTimes;

    private Services() {
    }

    public Services(Builder builder) {
        id=builder.id;
        serviceNo=builder.serviceNo;
        serviceName=builder.serviceName;
        date=builder.date;
        venue=builder.venue;
        gatheringTimes=builder.gatheringTimes;
    }

    public Long getId() {
        return id;
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

        private Long id;
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

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder copy(Services value) {
            this.id = value.getId();
            this.serviceNo = value.getServiceNo();
            this.serviceName = value.getServiceName();
            this.date = value.getDate();
            this.venue = value.getVenue();
            this.gatheringTimes = value.getGatheringTimes();
            return this;
        }

        public Services build() {
            return new Services(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Services)) return false;

        Services services = (Services) o;

        if (!id.equals(services.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", serviceNo=" + serviceNo +
                ", serviceName='" + serviceName + '\'' +
                ", date='" + date + '\'' +
                ", venue='" + venue + '\'' +
                ", gatheringTimes=" + gatheringTimes +
                '}';
    }
}
