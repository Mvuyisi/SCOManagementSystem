package scomanagementsystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.domain.Meetings;
import scomanagementsystem.repository.AssociatesRepository;
import scomanagementsystem.repository.MeetingsRepository;
import scomanagementsystem.services.MeetingsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public class MeetingsServiceImpl implements MeetingsService{
    @Autowired
    MeetingsRepository meetingsRepository;

    @Override
    public List<Meetings> getAllMeetings()
    {
        List<Meetings> meetings = new ArrayList<>();
        Iterable<Meetings> values = meetingsRepository.findAll();
        for(Meetings value: values)
        {
            meetings.add(value);
        }

        return meetings;
    }

    @Override
    public Meetings getMeeting(Integer meetingNo)
    {
        return meetingsRepository.findOne(meetingNo);
    }
}
