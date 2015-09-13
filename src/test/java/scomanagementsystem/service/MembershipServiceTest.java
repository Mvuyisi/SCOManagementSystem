package scomanagementsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.AddressFactory;
import scomanagementsystem.conf.factory.MembershipFactory;
import scomanagementsystem.conf.factory.PersonalDetailsFactory;
import scomanagementsystem.domain.Address;
import scomanagementsystem.domain.Membership;
import scomanagementsystem.domain.PersonalDetails;
import scomanagementsystem.repository.MembershipRepository;
import scomanagementsystem.services.MembershipService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class MembershipServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    MembershipService membershipService;

    private String studentNo;

    @Autowired
    MembershipRepository membershipRepository;

    @Test
    public void create() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();
        Map<String,String> address1 = new HashMap<String,String>();
        Map<String,String> fullName = new HashMap<String,String>();
        Map<String,String> contact = new HashMap<String,String>();

        address1.put("studentNo", "212030086");
        address1.put("salvationStatus", "Born Again");

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


        Membership membership = MembershipFactory
                .createMember(values, address, personalDetails);

        membershipRepository.save(membership);
        studentNo = membership.getStudentNo();
        Assert.assertNotNull(membership.getStudentNo());
    }

    public void cleanUp() throws Exception
    {
        membershipRepository.deleteAll();
    }
}
