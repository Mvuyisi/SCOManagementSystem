package scomanagementsystem.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.*;
import scomanagementsystem.domain.GatheringTimes;
import scomanagementsystem.domain.Services;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class ServiceCrudTest extends AbstractTestNGSpringContextTests {
    private Integer serviceNo;
    private String serviceName;
    private String date;
    private String venue;
    private GatheringTimes gatheringTimes;

    @Autowired
    ServiceRepository serviceRepository;

    @Test
    public void testCreate() throws Exception
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

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Services services = serviceRepository.findOne(serviceNo);
        Assert.assertNotNull(services);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Services services = serviceRepository.findOne(serviceNo);

        Services newservice = new Services
                .Builder(services.getServiceNo())
                .copy(services)
                .serviceName("Academic")
                .date("15 August 15")
                .venue("2.70")
                .gatheringTimes(services.getGatheringTimes())
                .build();

        serviceRepository.save(newservice);

        Services updatedService = serviceRepository.findOne(serviceNo);
        Assert.assertEquals(updatedService.getServiceName(), serviceName);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Services services = serviceRepository.findOne(serviceNo);
        serviceRepository.delete(services);
        Services deleteservice = serviceRepository.findOne(serviceNo);
        Assert.assertNull(deleteservice);
    }
}
