package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.AddressFactory;
import scomanagementsystem.conf.factory.AssociatesFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class AddressTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateAssociate() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("suburb","Woodstock");
        values.put("city", "Cape Town");

        Address address = AddressFactory
                .createAddress(10,"Dorset Street", values, 8001);

        Assert.assertEquals(10, address.getHouseNo());
    }

    @Test
    public void testUpadteAssociate() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("suburb","Woodstock");
        values.put("city", "Cape Town");

        Address address =AddressFactory
                .createAddress(10, "Dorset Street", values, 8001);
        //updating
        Map<String,String> updatedvalues = new HashMap<String,String>();

        updatedvalues.put("suburb","Salt River");
        updatedvalues.put("city", "Cape Town");

        Address newaddress = new Address
                .Builder(address.getHouseNo())
                .streetNm("Dorset Street")
                .copy(address)
                .suburb(updatedvalues.get("suburb"))
                .city(updatedvalues.get("city"))
                .build();

        Assert.assertEquals("Salt River",newaddress.getSuburb());
    }
}
