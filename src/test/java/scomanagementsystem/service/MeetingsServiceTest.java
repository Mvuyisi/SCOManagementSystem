package scomanagementsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.MeetingsFactory;
import scomanagementsystem.domain.Meetings;
import scomanagementsystem.repository.MeetingsRepository;
import scomanagementsystem.services.MeetingsService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class MeetingsServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    MeetingsService meetingsService;

    private Integer meetingNo;

    @Autowired
    MeetingsRepository meetingsRepository;

    @Test
    public void create() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();

        values.put("meetingDate", "15 June 15");
        values.put("meetingName", "AGM");

        Meetings meetings = MeetingsFactory
                .createMeeting(10, values);


        meetingsRepository.save(meetings);
        meetingNo = meetings.getMeetingNo();
        Assert.assertNotNull(meetings.getMeetingNo());
    }

    public void cleanUp() throws Exception
    {
        meetingsRepository.deleteAll();
    }
}
