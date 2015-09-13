package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/09/02.
 */
public class SubcomsAndMinistriesTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateSubcomsAndMinistries() throws Exception {
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
                .createMember(values3, address2,personalDetails);


        membership.add(membership1);


        values.put("leader", "Mvuyisi");
        values.put("venue", "2.70");

        time.put("startTime", "08:00");
        time.put("endTime", "12:00");

        GatheringTimes gatheringTimes1 = GatheringTimesFactory
                .createTimes("Friday", time);

        SubcomsAndMinistries subcomsAndMinistries = SubcomsAndMinistriesFactory
                .createSubcomOrMinistry(100, "South Point", values, "212030086", membership, gatheringTimes1);

        Assert.assertEquals("South Point", subcomsAndMinistries.getVenue());
    }

    @Test
    public void testUpadteEvents() throws Exception {
        Map<String,String> updateValues = new HashMap<String,String>();
        Map<String,String> time = new HashMap<String,String>();
        List<Membership> membership = new ArrayList<Membership>();

        updateValues.put("leader", "Mvuyisi");
        updateValues.put("venue", "2.70");

        time.put("startTime", "08:00");
        time.put("endTime", "12:00");

        GatheringTimes gatheringTimes1 = GatheringTimesFactory
                .createTimes("Friday", time);

        SubcomsAndMinistries subcomsAndMinistries = SubcomsAndMinistriesFactory
                .createSubcomOrMinistry(100, "South Point", updateValues, "212030086", membership,gatheringTimes1);
        //updating
        SubcomsAndMinistries newsubcomsandministries = new SubcomsAndMinistries
                .Builder(subcomsAndMinistries.getSmNo())
                .leader(updateValues.get("Mvuyisi"))
                .venue(updateValues.get("room 2.70"))
                .copy(subcomsAndMinistries)
                .name("Worship Team")
                .membership(membership)
                .build();

        Assert.assertEquals("Worship Team", newsubcomsandministries.getName());
    }
}
