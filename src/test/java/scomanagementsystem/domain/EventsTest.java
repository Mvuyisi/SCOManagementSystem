package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.EventsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/02.
 */
public class EventsTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateEvents() throws Exception {
        Map<String,String> date = new HashMap<String,String>();
        Map<String,String> values = new HashMap<String,String>();

        date.put( "startingDate", "15 June 2015");
        date.put("endDate","17 June 2015");
        values.put("eventName", "Camp");
        values.put("venue", "Gordins Camp");

        Events events = EventsFactory
                .createEvent(100, date, values, 10, 20000);

        Assert.assertEquals(100, events.getEventNo());
    }

    @Test
    public void testUpadteEvents() throws Exception {
        Map<String,String> updateDate = new HashMap<String,String>();
        Map<String,String> updateValues = new HashMap<String,String>();

        updateDate.put( "startingDate", "15 June 2015");
        updateDate.put("endDate","17 June 2015");
        updateValues.put("eventName", "Camp");
        updateValues.put("venue", "Gordins Camp");

        Events events = EventsFactory
                .createEvent(100, updateDate, updateValues, 10, 30000);
        //updating
        Events newevent = new Events
                .Builder(events.getEventNo())
                .startingDate(updateDate.get("startingDate"))
                .endDate(updateDate.get("endDate"))
                .eventName(updateValues.get("eventName"))
                .venue(updateValues.get("venue"))
                .smNo(10)
                .copy(events)
                .budget(30000)
                .build();

        Assert.assertEquals(30000, newevent.getBudget());
    }
}