package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.AddressFactory;
import scomanagementsystem.conf.factory.PersonalDetailsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class PersonalDetailsTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateAssociate() throws Exception {
        Map<String,String> fullname = new HashMap<String,String>();
        Map<String,String> values = new HashMap<String,String>();

        fullname.put("name","Mvuyisi");
        fullname.put("surname", "Jezile");

        values.put("cell","0789750473");
        values.put("email", "jmvuyisi@gmail.com");

        PersonalDetails personalDetails = PersonalDetailsFactory
                .createDetails(fullname, values);

        Assert.assertEquals("Mvuyisi", personalDetails.getName());
    }

    @Test
    public void testUpadteAssociate() throws Exception {
        Map<String,String> fullname = new HashMap<String,String>();
        Map<String,String> values = new HashMap<String,String>();

        fullname.put("name","Mvuyisi");
        fullname.put("surname", "Jezile");

        values.put("cell","07897504473");
        values.put("email", "jmvuyisi@gmail.com");

        PersonalDetails personalDetails =PersonalDetailsFactory
                .createDetails(fullname, values);
        //updating
        Map<String,String> updatedfullname = new HashMap<String,String>();
        Map<String,String> updatedvalues = new HashMap<String,String>();

        updatedfullname.put("name","Mvuyisi");
        updatedfullname.put("surname", "Jezile");

        updatedvalues.put("cell","07897504473");
        updatedvalues.put("email", "jmvuyisi93@gmail.com");

        PersonalDetails newdetails = new PersonalDetails
                .Builder(personalDetails.getName())
                .surname(updatedvalues.get("Jezile"))
                .cell(updatedfullname.get("078950473"))
                .copy(personalDetails)
                .email(updatedfullname.get("suburb"))
                .build();

        Assert.assertEquals("Mvuyisi",newdetails.getName());
    }
}
