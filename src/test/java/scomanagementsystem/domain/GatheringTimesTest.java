package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.GatheringTimesFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/02.
 */
public class GatheringTimesTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateGatheringTimes() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("startingTime", "19:00");
        values.put("endTime", "20:00");

        GatheringTimes gatheringTimes = GatheringTimesFactory
                .createTimes("Wednesday", values);

        Assert.assertEquals("Wednesday", gatheringTimes.getDay());
    }

    @Test
    public void testUpadteEvents() throws Exception {
        Map<String, String> updateValues = new HashMap<String, String>();

        updateValues.put("startingTime", "19:00");
        updateValues.put("endTime", "20:00");

        GatheringTimes gatheringTimes = GatheringTimesFactory
                .createTimes("Wednesday", updateValues);
        //updating
        GatheringTimes newgatimes = new GatheringTimes
                .Builder(gatheringTimes.getDay())
                .startingTime(updateValues.get("19:00"))
                .copy(gatheringTimes)
                .endTime(updateValues.get("21:00"))
                .build();

        Assert.assertEquals("21:00", newgatimes.getEndTime());
    }
}
