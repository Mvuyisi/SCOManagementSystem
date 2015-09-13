package scomanagementsystem.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.*;
import scomanagementsystem.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SpringApplicationConfiguration(classes = ScomanagementsystemApplication.class)
@WebAppConfiguration
/**
 * Created by student on 2015/09/12.
 */
public class SubcomsAndMinistriesCrudTest {
    private Integer smNo;
    private String name;
    private String studNo;
    private String leader;
    private String venue;
    private GatheringTimes gatheringTimes;

    @Autowired
    SubcomsAndMinistriesRepository subcomsAndMinistriesRepository;

    @Test
    public void testCreate() throws Exception
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

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        SubcomsAndMinistries subcomsAndMinistries = subcomsAndMinistriesRepository.findOne(smNo);
        Assert.assertNotNull(subcomsAndMinistries);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        SubcomsAndMinistries subcomsAndMinistries = subcomsAndMinistriesRepository.findOne(smNo);

        SubcomsAndMinistries newSubcomsAndMinistry = new SubcomsAndMinistries
                .Builder(subcomsAndMinistries.getSmNo())
                .copy(subcomsAndMinistries)
                .leader("Mvuyisi")
                .venue("office")
                .studNo("212030086")
                .membership(subcomsAndMinistries.getMembership())
                .gatheringTimes(subcomsAndMinistries.getGatheringTimes())
                .build();

        subcomsAndMinistriesRepository.save(newSubcomsAndMinistry);

        SubcomsAndMinistries updatedSubcomsAndMinistries = subcomsAndMinistriesRepository.findOne(smNo);
        Assert.assertEquals(updatedSubcomsAndMinistries.getLeader(), leader);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        SubcomsAndMinistries subcomsAndMinistries = subcomsAndMinistriesRepository.findOne(smNo);
        subcomsAndMinistriesRepository.delete(subcomsAndMinistries);
        SubcomsAndMinistries deletesubcomsAndMinistries = subcomsAndMinistriesRepository.findOne(smNo);
        Assert.assertNull(deletesubcomsAndMinistries);
    }
}
