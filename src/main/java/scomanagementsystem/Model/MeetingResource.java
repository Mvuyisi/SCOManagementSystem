package scomanagementsystem.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/09/12.
 */
public class MeetingResource extends ResourceSupport {
    private Integer meetingNo;
    private String meetingDate;
    private String meetingName;

    private MeetingResource() {
    }

    public MeetingResource(Builder builder) {
        meetingNo=builder.meetingNo;
        meetingDate=builder.meetingDate;
        meetingName=builder.meetingName;
    }

    public Integer getMeetingNo() {
        return meetingNo;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public static class Builder {

        private Integer meetingNo;
        private String meetingDate;
        private String meetingName;

        public Builder(Integer meetingNo) {
            this.meetingNo = meetingNo;
        }


        public Builder meetingDate(String value) {
            this.meetingDate = value;
            return this;
        }

        public Builder meetingName(String value) {
            this.meetingName = value;
            return this;
        }

        public Builder copy(MeetingResource value) {
            this.meetingNo = value.getMeetingNo();
            this.meetingDate = value.getMeetingDate();
            this.meetingName = value.getMeetingName();
            return this;
        }

        public MeetingResource build() {
            return new MeetingResource(this);
        }
    }
}
