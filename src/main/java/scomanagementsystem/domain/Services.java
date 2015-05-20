package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/10.
 */
@Entity
public class Services implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private int serviceNo;
    private String serviceName;
    private String date;
    private String venue;

    private Services() {
    }

    public Services(Builder builder) {
        id=builder.id;
        serviceNo=builder.serviceNo;
        serviceName=builder.serviceName;
        date=builder.date;
        venue=builder.venue;
    }

    public Long getId() {
        return id;
    }

    public int getServiceNo() {
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

    public static class Builder {

        private Long id;
        private int serviceNo;
        private String serviceName;
        private String date;
        private String venue;

        public Builder(int serviceNo) {
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
                '}';
    }
}
