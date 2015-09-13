package scomanagementsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.GatheringTimesFactory;
import scomanagementsystem.conf.factory.ServicesFactory;
import scomanagementsystem.domain.GatheringTimes;
import scomanagementsystem.domain.Services;
import scomanagementsystem.repository.ServiceRepository;
import scomanagementsystem.services.ServicesService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class ServicesServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    ServicesService servicesService;

    private Integer serviceNo;

    @Autowired
    ServiceRepository serviceRepository;

    @Test
    public void create() throws Exception
    {
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

        serviceRepository.save(services);
        serviceNo = services.getServiceNo();
        Assert.assertNotNull(services.getServiceNo());
    }

    public void cleanUp() throws Exception
    {
        serviceRepository.deleteAll();
    }
}
