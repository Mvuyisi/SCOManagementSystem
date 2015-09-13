package scomanagementsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.*;
import scomanagementsystem.domain.*;
import scomanagementsystem.repository.SubcomsAndMinistriesRepository;
import scomanagementsystem.services.SubcomsAndMinistriesService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class SubcomsAndMinistriesServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    SubcomsAndMinistriesService subcomsAndMinistriesService;

    private Integer smNo;
    private String studentNo;

    @Autowired
    private SubcomsAndMinistriesRepository subcomsAndMinistriesRepository;

    List<Membership> membership = new ArrayList<>();

    @Test
    public void create() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();
        Map<String,String> time = new HashMap<String,String>();


        List<Membership> membership = new ArrayList<Membership>();

        Map<String,String> values3 = new HashMap<String,String>();

        Map<String,String> fullName = new HashMap<String,String>();
        Map<String,String> values2 = new HashMap<String,String>();
        Map<String,String> address = new HashMap<String,String>();

        values3.put("studentNo", "212030086");
        values3.put("salvationStatus", "Born Again");

        fullName.put("name", "Mvuyisi");
        fullName.put("surname", "Jezile");

        values2.put("cell", "0789750473");
        values2.put("email", "jezz@gmail.com");

        address.put("suburb", "Woodstock");
        address.put("city", "Cape Town");

        Address address2 = AddressFactory
                .createAddress(10, "Dorset", address, 8001);

        PersonalDetails personalDetails = PersonalDetailsFactory
                .createDetails(fullName, values2);

        Membership membership1 = MembershipFactory
                .createMember(values3, address2, personalDetails);


        membership.add(membership1);


        values.put("leader", "Mvuyisi");
        values.put("venue", "2.70");

        time.put("startTime", "08:00");
        time.put("endTime", "12:00");

        GatheringTimes gatheringTimes1 = GatheringTimesFactory
                .createTimes("Friday", time);

        SubcomsAndMinistries subcomsAndMinistries = SubcomsAndMinistriesFactory
                .createSubcomOrMinistry(20, "South Point", values, "212030086", membership, gatheringTimes1);

        subcomsAndMinistriesRepository.save(subcomsAndMinistries);
        smNo = subcomsAndMinistries.getSmNo();
        Assert.assertNotNull(subcomsAndMinistries.getSmNo());
    }

    @Test
    public void testGetMembership() throws Exception
    {
        membership = subcomsAndMinistriesService.getMembership(studentNo);
        Assert.assertEquals(1, membership.size());
    }

    public void cleanUp() throws Exception
    {
        subcomsAndMinistriesRepository.deleteAll();
    }
}
