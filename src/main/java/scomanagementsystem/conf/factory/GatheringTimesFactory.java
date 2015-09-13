package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.GatheringTimes;

import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class GatheringTimesFactory {
    public static GatheringTimes createTimes(String day, Map<String, String> values){

        GatheringTimes times = new GatheringTimes
                .Builder(day)
                .startingTime(values.get("startTime"))
                .endTime(values.get("endTime"))
                .build();
        return times;
    }
}
