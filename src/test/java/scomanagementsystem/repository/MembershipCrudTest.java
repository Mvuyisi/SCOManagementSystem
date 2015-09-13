package scomanagementsystem.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
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

import java.util.HashMap;
import java.util.Map;
@SpringApplicationConfiguration(classes = ScomanagementsystemApplication.class)
@WebAppConfiguration
/**
 * Created by student on 2015/09/12.
 */
public class MembershipCrudTest extends AbstractTestNGSpringContextTests{
    private String studentNo;
    private String salvationStatus;
    private Address address;
    private PersonalDetails personalDetails;

    @Autowired
    MembershipRepository membershipRepository;

    @Test
    public void testCreate() throws Exception
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

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Membership membership = membershipRepository.findOne(studentNo);
        Assert.assertNotNull(membership);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Membership membership = membershipRepository.findOne(studentNo);

        Membership newmember = new Membership
                .Builder(membership.getStudentNo())
                .copy(membership)
                .salvationStatus("Born Again")
                .address(membership.getAddress())
                .personalDetails(membership.getPersonalDetails())
                .build();

        membershipRepository.save(newmember);

        Membership updatedMember = membershipRepository.findOne(studentNo);
        Assert.assertEquals(updatedMember.getSalvationStatus(), salvationStatus);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Membership membership = membershipRepository.findOne(studentNo);
        membershipRepository.delete(membership);
        Membership deletedMember = membershipRepository.findOne(studentNo);
        Assert.assertNull(deletedMember);
    }
}
