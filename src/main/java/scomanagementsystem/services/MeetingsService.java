package scomanagementsystem.services;

import scomanagementsystem.domain.Meetings;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface MeetingsService {
    List<Meetings> getAllMeetings();

    Meetings getMeeting(Integer meetingNo);
}
