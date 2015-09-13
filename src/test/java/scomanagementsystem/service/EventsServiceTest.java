package scomanagementsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.EventsFactory;
import scomanagementsystem.domain.Events;
import scomanagementsystem.repository.EventsRepository;
import scomanagementsystem.services.EventsService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class EventsServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    EventsService eventsService;

    private Integer eventNo;

    @Autowired
    EventsRepository eventsRepository;

    @Test
    public void create() throws Exception
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

    public void cleanUp() throws Exception
    {
        eventsRepository.deleteAll();
    }
}
