package scomanagementsystem.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/05/21.
 */

@Embeddable
public class GatheringTimes implements Serializable{
    private String day;
    private String startingTime;
    private String endTime;

    private GatheringTimes() {
    }

    public GatheringTimes(Builder builder) {
        day=builder.day;
        startingTime=builder.startingTime;
        endTime=builder.endTime;
    }

    public String getDay() {
        return day;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public static class Builder {

        private String day;
        private String startingTime;
        private String endTime;

        public Builder(String day) {
            this.day = day;
        }


        public Builder startingTime(String value) {
            this.startingTime = value;
            return this;
        }

        public Builder endTime(String value) {
            this.endTime = value;
            return this;
        }

        public Builder copy(GatheringTimes value) {
            this.day = value.getDay();
            this.startingTime = value.getStartingTime();
            this.endTime = value.getEndTime();
            return this;
        }

        public GatheringTimes build() {
            return new GatheringTimes(this);
        }

    }
}
