package scomanagementsystem.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/05/21.
 */
@Entity
public class Meetings implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Integer meetingNo;
    private String meetingDate;
    private String meetingName;

    private Meetings() {
    }

    public Meetings(Builder builder) {
        id=builder.id;
        meetingNo=builder.meetingNo;
        meetingDate=builder.meetingDate;
        meetingName=builder.meetingName;
    }

    public Long getId() {
        return id;
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

        private Long id;
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

        public Builder copy(Meetings value) {
            this.id = value.getId();
            this.meetingNo = value.getMeetingNo();
            this.meetingDate = value.getMeetingDate();
            this.meetingName = value.getMeetingName();
            return this;
        }

        public Meetings build() {
            return new Meetings(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meetings)) return false;

        Meetings meetings = (Meetings) o;

        if (!id.equals(meetings.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Meetings{" +
                "id=" + id +
                ", meetingNo=" + meetingNo +
                ", meetingDate='" + meetingDate + '\'' +
                ", meetingName='" + meetingName + '\'' +
                '}';
    }
}
