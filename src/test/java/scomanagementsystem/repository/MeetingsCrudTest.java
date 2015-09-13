package scomanagementsystem.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.MeetingsFactory;
import scomanagementsystem.domain.Meetings;

import java.util.HashMap;
import java.util.Map;
@SpringApplicationConfiguration(classes = ScomanagementsystemApplication.class)
@WebAppConfiguration
/**
 * Created by student on 2015/09/12.
 */
public class MeetingsCrudTest extends AbstractTestNGSpringContextTests {
    private Integer meetingNo;
    private String meetingDate;
    private String meetingName;

    @Autowired
    MeetingsRepository meetingsRepository;

    @Test
    public void testCreate() throws Exception
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

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Meetings meetings = meetingsRepository.findOne(meetingNo);
        Assert.assertNotNull(meetings);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Meetings meetings = meetingsRepository.findOne(meetingNo);

        Meetings newmeeting = new Meetings
                .Builder(meetings.getMeetingNo())
                .copy(meetings)
                .meetingDate("15 August 15")
                .meetingName("AGM")
                .build();

        meetingsRepository.save(newmeeting);

        Meetings updateMeeting = meetingsRepository.findOne(meetingNo);
        Assert.assertEquals(updateMeeting.getMeetingName(), meetingName);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Meetings meetings = meetingsRepository.findOne(meetingNo);
        meetingsRepository.delete(meetings);
        Meetings deletedmeetings = meetingsRepository.findOne(meetingNo);
        Assert.assertNull(deletedmeetings);
    }
}
