package scomanagementsystem.services;

import scomanagementsystem.domain.Events;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface EventsService {
    List<Events> getAllEvents();

    Events getEvents(Integer eventNo);
}
