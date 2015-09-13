package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/21.
 */

@Entity
public class Events implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Integer eventNo;
    private String eventName;
    private String startingDate;
    private String endDate;
    private Integer smNo;
    private String venue;
    private double budget;

    private Events() {
    }

    public Events(Builder builder) {
        id=builder.id;
        eventNo=builder.eventNo;
        eventName=builder.eventName;
        startingDate=builder.startingDate;
        endDate=builder.endDate;
        smNo=builder.smNo;
        venue=builder.venue;
        budget=builder.budget;
    }

    public Long getId() {
        return id;
    }

    public Integer getEventNo() {
        return eventNo;
    }

    public String getEventName() {
        return eventName;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Integer getSmNo() {
        return smNo;
    }

    public String getVenue() {
        return venue;
    }

    public double getBudget() {
        return budget;
    }


    public static class Builder {

        private Long id;
        private Integer eventNo;
        private String eventName;
        private String startingDate;
        private String endDate;
        private Integer smNo;
        private String venue;
        private double budget;

        public Builder(Integer eventNo) {
            this.eventNo = eventNo;
        }


        public Builder eventName(String value) {
            this.eventName = value;
            return this;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder startingDate(String value) {
            this.startingDate = value;
            return this;
        }

        public Builder endDate(String value) {
            this.endDate = value;
            return this;
        }

        public Builder smNo(Integer value) {
            this.smNo = value;
            return this;
        }

        public Builder venue(String value) {
            this.venue = value;
            return this;
        }

        public Builder budget(double value) {
            this.budget = value;
            return this;
        }

        public Builder copy(Events value) {
            this.eventNo = value.getEventNo();
            this.eventName = value.getEventName();
            this.id = value.getId();
            this.startingDate = value.getStartingDate();
            this.endDate = value.getEndDate();
            this.smNo = value.getSmNo();
            this.venue = value.getVenue();
            this.budget = value.getBudget();
            return this;
        }


        public Events build() {
            return new Events(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Events)) return false;

        Events events = (Events) o;

        if (!id.equals(events.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", eventNo=" + eventNo +
                ", eventName='" + eventName + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", smNo=" + smNo +
                ", venue='" + venue + '\'' +
                ", budget=" + budget +
                '}';
    }
}
