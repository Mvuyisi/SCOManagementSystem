package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.AddressFactory;
import scomanagementsystem.conf.factory.AssociatesFactory;
import scomanagementsystem.conf.factory.PersonalDetailsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/10.
 */
public class AssociatesTest{
        @Before
        public void setUp() throws Exception {


        }

        @Test
        public void testCreateAssociate() throws Exception {
            Map<String,String> address1 = new HashMap<String,String>();
            Map<String,String> fullName = new HashMap<String,String>();
            Map<String,String> contact = new HashMap<String,String>();

            address1.put("suburb","Woodstock");
            address1.put("city", "Cape Town");

            fullName.put("name","Mvuyisi");
            fullName.put("surname", "Jezile");

            contact.put("cell","0829750443");
            contact.put("email", "jez@gmail.com");

            Address address = AddressFactory
                    .createAddress(10, "Dorset", address1, 8001);

            PersonalDetails personalDetails = PersonalDetailsFactory
                    .createDetails(fullName, contact);

            Associates associates = AssociatesFactory
                    .createAssociate("9304255751089", "2015 Chairperson", address, personalDetails);

            Assert.assertEquals("9304255751089", associates.getIdNo());
        }

        @Test
        public void testUpadteAssociate() throws Exception {
            Map<String,String> updateAddress1 = new HashMap<String,String>();
            Map<String,String> updateFullName = new HashMap<String,String>();
            Map<String,String> updateContact = new HashMap<String,String>();

            updateAddress1.put("suburb","Woodstock");
            updateAddress1.put("city", "Cape Town");

            updateFullName.put("name","Mvuyisi");
            updateFullName.put("surname", "Jezile");

            updateContact.put("cell","0829750443");
            updateContact.put("email", "jez@gmail.com");

            Address address = AddressFactory
                    .createAddress(10, "Dorset", updateAddress1, 8001);

            PersonalDetails personalDetails = PersonalDetailsFactory
                    .createDetails(updateFullName, updateContact);

            Associates associates = AssociatesFactory
                    .createAssociate("9304255751089", "2015 Chairperson", address, personalDetails);
            //updating
            Associates newassociate = new Associates
                    .Builder(associates.getIdNo())
                    .address(associates.getAddress())
                    .personalDetails(associates.getPersonalDetails())
                    .copy(associates)
                    .alumniStatus("2014/2015 Chairperson")
                    .build();

            Assert.assertEquals("2014/2015 Chairperson",newassociate.getAlumniStatus());
        }
}
