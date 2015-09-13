package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.AddressFactory;
import scomanagementsystem.conf.factory.MembershipFactory;
import scomanagementsystem.conf.factory.PersonalDetailsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/02.
 */
public class MembershipTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateMembership() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        Map<String,String> fullName = new HashMap<String,String>();
        Map<String,String> values2 = new HashMap<String,String>();
        Map<String,String> address = new HashMap<String,String>();

        values.put("studentNo", "212030086");
        values.put("salvationStatus", "Born Again");

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

        Membership membership = MembershipFactory
                .createMember(values, address2,personalDetails);

        Assert.assertEquals("212030086", membership.getStudentNo());
    }

    @Test
    public void testUpadteAssociate() throws Exception {
        Map<String,String> updateValues = new HashMap<String,String>();

        Map<String,String> updateFullName = new HashMap<String,String>();
        Map<String,String> updateValues2 = new HashMap<String,String>();
        Map<String,String> updateAddress = new HashMap<String,String>();

        updateValues.put("studentNo", "212030086");
        updateValues.put("salvationStatus", "Born Again");

        updateFullName.put("name", "Mvuyisi");
        updateFullName.put("surname", "Jezile");

        updateValues2.put("cell", "0789750473");
        updateValues2.put("email", "jezz@gmail.com");

        updateAddress.put("suburb", "Woodstock");
        updateAddress.put("city", "Cape Town");

        Address address2 = AddressFactory
                .createAddress(10, "Dorset", updateAddress, 8001);

        PersonalDetails personalDetails = PersonalDetailsFactory
                .createDetails(updateFullName, updateValues2);

        Membership membership = MembershipFactory
                .createMember(updateValues, address2,personalDetails);
        //updating
        Membership newmember = new Membership
                .Builder(membership.getStudentNo())
                .address(membership.getAddress())
                .personalDetails(membership.getPersonalDetails())
                .copy(membership)
                .salvationStatus("Born Again")
                .build();

        Assert.assertEquals("Born Again",newmember.getSalvationStatus());
    }
}
