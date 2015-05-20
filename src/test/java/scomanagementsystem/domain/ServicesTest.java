package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

        values.put("date","15 May 2015");
        values.put("venue", "2.70 Science Building");

        Services course = ServicesFactory
                .createService(100, "Academic Service", values);

        Assert.assertEquals(100, course.getServiceNo());
    }

    @Test
    public void testUpadteService() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("date","15 May 2015");
        values.put("venue", "2.70 Science Building");

        Services service =ServicesFactory
                .createService(100, "Academic Service", values);
        //updating
        Map<String,String> updatevalues = new HashMap<String,String>();

        updatevalues.put("date","22 May 2015");
        updatevalues.put("venue", "2.71 Science Building");
        Services newservice = new Services
                .Builder(service.getServiceNo())
                .serviceName("Academic Service")
                .copy(service)
                .date(updatevalues.get("date"))
                .venue(updatevalues.get("venue"))
                .build();

        Assert.assertEquals("22 May 2015",newservice.getDate());
        Assert.assertEquals("2.71 Science Building",newservice.getServiceName());
    }
}
