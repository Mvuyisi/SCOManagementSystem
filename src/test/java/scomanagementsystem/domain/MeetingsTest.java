package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.MeetingsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/02.
 */
public class MeetingsTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateMeetings() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("meetingDate", "25 April 2015");
        values.put("meetingName", "AGM");

        Meetings meetings = MeetingsFactory
                .createMeeting(100, values);

        Assert.assertEquals(100, meetings.getMeetingNo());
    }

    @Test
    public void testUpadteEvents() throws Exception {
        Map<String, String> updateValues = new HashMap<String, String>();

        updateValues.put("meetingDate", "25 April 2015");
        updateValues.put("meetingName", "AGM");

        Meetings meetings = MeetingsFactory
                .createMeeting(100, updateValues);
        //updating
        Meetings newmeeting = new Meetings
                .Builder(meetings.getMeetingNo())
                .meetingDate(updateValues.get("25 April 2015"))
                .copy(meetings)
                .meetingName("GC")
                .build();

        Assert.assertEquals("GC", newmeeting.getMeetingName());
    }
}
