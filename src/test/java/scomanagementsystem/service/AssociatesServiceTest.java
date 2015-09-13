package scomanagementsystem.service;

import org.junit.Assert;
import org.junit.Test;
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
import scomanagementsystem.repository.AssociatesRepository;
import scomanagementsystem.services.AssociateService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class AssociatesServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    AssociateService associateService;

    @Autowired
    AssociatesRepository associatesRepository;

    private String idNo;

    @Test
    public void create() throws Exception
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
                .createAddress(10, "Dorset", address1, 8001);

        PersonalDetails personalDetails = PersonalDetailsFactory
                .createDetails(fullName, contact);


        Associates associate = AssociatesFactory
                .createAssociate("9304250000000", "Former Chairperson", address, personalDetails);

        associatesRepository.save(associate);
        idNo = associate.getIdNo();
        Assert.assertNotNull(associate.getIdNo());
    }

    public void cleanUp() throws Exception
    {
        associatesRepository.deleteAll();
    }
}
