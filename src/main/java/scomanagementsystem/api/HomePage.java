package scomanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import scomanagementsystem.domain.Address;
import scomanagementsystem.domain.Membership;
import scomanagementsystem.domain.PersonalDetails;
import scomanagementsystem.services.MembershipService;

import java.util.List;

/**
 * Created by student on 2015/08/25.
 */

@RestController
@RequestMapping("/api/**")
public class HomePage {
    Address address;
    PersonalDetails personalDetails;
    @Autowired
    MembershipService membershipService;
    @RequestMapping(value = "home", method = RequestMethod.GET)

    public String index()
    {
        return "Welcome to Students' Christians Organisation";
    }
    @RequestMapping(value = "/membership",method = RequestMethod.GET)
    public Membership getMembership()
    {
        Membership membership = new Membership
                .Builder("212030086")
                .salvationStatus("Born Again")
                .address(address)
                .personalDetails(personalDetails)
                .build();

        return membership;
    }
    @RequestMapping(value = "/membership",method = RequestMethod.GET)
    public List<Membership> getMemberships()
    {
        return membershipService.getAllMembers();

    }
}
