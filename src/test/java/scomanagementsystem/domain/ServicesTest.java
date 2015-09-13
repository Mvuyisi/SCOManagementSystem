package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.GatheringTimesFactory;
import scomanagementsystem.conf.factory.ServicesFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/10.
 */
public class ServicesTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateService() throws Exception {
        Map<String,String> values = new HashMap<String,String>();
        Map<String,String> time = new HashMap<String,String>();

        values.put("date", "15 June 15");
        values.put("venue", "2.70");

        time.put("startTime", "08:00");
        time.put("endTime", "12:00");

        GatheringTimes gatheringTimes1 = GatheringTimesFactory
                .createTimes("Friday", time);

        Services services = ServicesFactory
                .createService(10, "Academic", values, gatheringTimes1);
        Assert.assertEquals("Academic", services.getServiceName());
    }

    @Test
    public void testUpadteService() throws Exception {
        Map<String,String> updateValues = new HashMap<String,String>();
        Map<String,String> time = new HashMap<String,String>();

        updateValues.put("date", "15 June 15");
        updateValues.put("venue", "2.70");

        time.put("startTime", "08:00");
        time.put("endTime", "12:00");

        GatheringTimes gatheringTimes1 = GatheringTimesFactory
                .createTimes("Friday", time);

        Services services = ServicesFactory
                .createService(10, "Academic", updateValues, gatheringTimes1);
        //updating
        Services newservice = new Services
                .Builder(services.getServiceNo())
                .serviceName("Academic Service")
                .copy(services)
                .date(updateValues.get("date"))
                .venue(updateValues.get("venue"))
                .build();

        Assert.assertEquals("22 May 2015",newservice.getDate());
        Assert.assertEquals("Academic Service",newservice.getServiceName());
    }
}
