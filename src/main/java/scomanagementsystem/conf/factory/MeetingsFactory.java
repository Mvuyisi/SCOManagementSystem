package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.Meetings;

import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class MeetingsFactory {
    public static Meetings createMeeting(Integer meetingNo, Map<String, String> values){

        Meetings meeting = new Meetings
                .Builder(meetingNo)
                .meetingDate(values.get("meetingDate"))
                .meetingName(values.get("meetingName"))
                .build();
        return meeting;
    }
}
