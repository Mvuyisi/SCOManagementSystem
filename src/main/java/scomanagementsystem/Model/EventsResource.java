package scomanagementsystem.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/12.
 */
public class EventsResource extends ResourceSupport {
    private Integer eventNo;
    private String eventName;
    private String startingDate;
    private String endDate;
    private Integer smNo;
    private String venue;
    private double budget;

    private EventsResource() {
    }

    public EventsResource(Builder builder) {
        eventNo=builder.eventNo;
        eventName=builder.eventName;
        startingDate=builder.startingDate;
        endDate=builder.endDate;
        smNo=builder.smNo;
        venue=builder.venue;
        budget=builder.budget;
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

        public Builder copy(EventsResource value) {
            this.eventNo = value.getEventNo();
            this.eventName = value.getEventName();
            this.startingDate = value.getStartingDate();
            this.endDate = value.getEndDate();
            this.smNo = value.getSmNo();
            this.venue = value.getVenue();
            this.budget = value.getBudget();
            return this;
        }


        public EventsResource build() {
            return new EventsResource(this);
        }

    }
}
