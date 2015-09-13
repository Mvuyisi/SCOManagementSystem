package scomanagementsystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.domain.CellGroups;
import scomanagementsystem.domain.Events;
import scomanagementsystem.repository.AssociatesRepository;
import scomanagementsystem.repository.EventsRepository;
import scomanagementsystem.services.EventsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public class EventsServiceImpl implements EventsService{
    @Autowired
    EventsRepository eventsRepository;

    @Override
    public List<Events> getAllEvents()
    {
        List<Events> events = new ArrayList<>();
        Iterable<Events> values = eventsRepository.findAll();
        for(Events value: values)
        {
            events.add(value);
        }

        return events;
    }

    @Override
    public Events getEvents(Integer eventNo)
    {
        return eventsRepository.findOne(eventNo);
    }
}
