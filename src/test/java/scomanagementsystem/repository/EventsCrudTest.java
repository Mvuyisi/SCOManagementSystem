package scomanagementsystem.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.EventsFactory;
import scomanagementsystem.domain.Events;

import java.util.HashMap;
import java.util.Map;
@SpringApplicationConfiguration(classes = ScomanagementsystemApplication.class)
@WebAppConfiguration
/**
 * Created by student on 2015/09/12.
 */
public class EventsCrudTest extends AbstractTestNGSpringContextTests {
    private Integer eventNo;
    private String eventName;
    private String startingDate;
    private String endDate;
    private Integer smNo;
    private String venue;
    private double budget;

    @Autowired
    EventsRepository eventsRepository;

    @Test
    public void testCreate() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();
        Map<String,String> values2 = new HashMap<String,String>();

        values.put("eventName", "Camp");
        values.put("vanue", "Gordins");

        values2.put("startingDate", "12 June 15");
        values2.put("endDate", "15 June 15");

        Events events = EventsFactory
                .createEvent(10, values, values2, 10, 500);


        eventsRepository.save(events);
        eventNo = events.getEventNo();
        Assert.assertNotNull(events.getEventNo());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Events events = eventsRepository.findOne(eventNo);
        Assert.assertNotNull(events);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Events events = eventsRepository.findOne(eventNo);

        Events newevent = new Events
                .Builder(events.getEventNo())
                .copy(events)
                .eventName("Camp")
                .venue("Gordins")
                .startingDate("12 June 15")
                .endDate("15 June 15")
                .smNo(10)
                .budget(500)
                .build();

        eventsRepository.save(newevent);

        Events updatedEvent = eventsRepository.findOne(eventNo);
        Assert.assertEquals(updatedEvent.getBudget(), budget);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Events events = eventsRepository.findOne(eventNo);
        eventsRepository.delete(events);
        Events deletedevent = eventsRepository.findOne(eventNo);
        Assert.assertNull(deletedevent);
    }
}
