package scomanagementsystem.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.AddressFactory;
import scomanagementsystem.conf.factory.AssociatesFactory;
import scomanagementsystem.conf.factory.PersonalDetailsFactory;
import scomanagementsystem.domain.Address;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.domain.PersonalDetails;

import java.util.HashMap;
import java.util.Map;
@SpringApplicationConfiguration(classes = ScomanagementsystemApplication.class)
@WebAppConfiguration
/**
 * Created by student on 2015/05/21.
 */
public class AssociateCrudTest extends AbstractTestNGSpringContextTests {
    private String idNo;
    private String alumniStatus;
    private Address address;
    private PersonalDetails personalDetails;

    @Autowired
    AssociatesRepository associatesRepository;

    @Test
    public void testCreate() throws Exception
    {
        Map<String,String> address1 = new HashMap<String,String>();
        Map<String,String> fullName = new HashMap<String,String>();
        Map<String,String> contact = new HashMap<String,String>();

        address1.put("suburb", "Woodstock");
        address1.put("city", "Cape Town");

        fullName.put("name", "Mvuyisi");
        fullName.put("surname", "Jezile");

        contact.put("cell", "0829856235");
        contact.put("email", "jez@gmail.com");

        Address address = AddressFactory
                .createAddress(10, "Dorset", address1,8001);

        PersonalDetails personalDetails = PersonalDetailsFactory
                .createDetails(fullName,contact);


        Associates associate = AssociatesFactory
                .createAssociate("9304250000000", "Former Chairperson",address, personalDetails);

        associatesRepository.save(associate);
        idNo = associate.getIdNo();
        Assert.assertNotNull(associate.getIdNo());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Associates associates = associatesRepository.findOne(idNo);
        Assert.assertNotNull(associates);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Associates associates = associatesRepository.findOne(idNo);

        Associates newassociates = new Associates
                .Builder(associates.getAlumniStatus())
                .copy(associates)
                .address(associates.getAddress())
                .personalDetails(associates.getPersonalDetails())
                .build();

        associatesRepository.save(newassociates);

        Associates updatedAssociates = associatesRepository.findOne(idNo);
        Assert.assertEquals(updatedAssociates.getAlumniStatus(), alumniStatus);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Associates associates = associatesRepository.findOne(idNo);
        associatesRepository.delete(associates);
        Associates deletedAssociates = associatesRepository.findOne(idNo);
        Assert.assertNull(deletedAssociates);
    }
}
