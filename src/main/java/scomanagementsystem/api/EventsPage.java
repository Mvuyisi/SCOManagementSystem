package scomanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import scomanagementsystem.Model.EventsResource;
import scomanagementsystem.domain.Events;
import scomanagementsystem.services.EventsService;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping(value="/events/**")
public class EventsPage {
    @Autowired
    private EventsService eventsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "events details";
    }

    @RequestMapping(value = "/{eventNo}", method = RequestMethod.GET)
    public EventsResource getEvents(@PathVariable Integer eventNo)
    {
        EventsResource hateoas;
        Events events = eventsService.getEvents(eventNo);

        EventsResource res = new EventsResource
                .Builder(events.getEventNo())
                .eventName("Camp")
                .startingDate("12 April 15")
                .endDate("21 April 15")
                .smNo(10)
                .venue("Gordins")
                .budget(5000)
                .build();

        Link eventsDetails = new
                Link("http://localhost:8080/api/events/" + res.getEventNo().toString())
                .withRel("events");

        res.add(eventsDetails);
        hateoas = res;

        return hateoas;
    }
}
