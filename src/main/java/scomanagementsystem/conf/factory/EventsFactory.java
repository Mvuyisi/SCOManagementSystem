package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.Events;

import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class EventsFactory {
    public static Events createEvent(Integer eventNo,Map<String, String> date, Map<String, String> values, Integer smNo, double budget){

        Events event = new Events
                .Builder(eventNo)
                .eventName(values.get("eventName"))
                .venue(values.get("venue"))
                .startingDate(date.get("startingDate"))
                .endDate(date.get("endDate"))
                .smNo(smNo)
                .budget(budget)
                .build();
        return event;
    }
}
