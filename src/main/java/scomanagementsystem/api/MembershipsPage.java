package scomanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scomanagementsystem.Model.MembershipResource;
import scomanagementsystem.domain.Membership;
import scomanagementsystem.services.MembershipService;

/**
 * Created by student on 2015/09/13.
 */
public class MembershipsPage {
    @Autowired
    private MembershipService membershipService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "membership details";
    }

    @RequestMapping(value = "/{studentNo}", method = RequestMethod.GET)
    public MembershipResource getMembership(@PathVariable String studentNo)
    {
        MembershipResource hateoas;
        Membership membership = membershipService.getMembership(studentNo);

        MembershipResource res = new MembershipResource
                .Builder(membership.getStudentNo())
                .salvationStatus("Born Again")
                .address(membership.getAddress())
                .personalDetails(membership.getPersonalDetails())
                .build();

        Link membershipDetails = new
                Link("http://localhost:8080/api/membership/" + res.getStudentNo().toString())
                .withRel("membership");

        res.add(membershipDetails);
        hateoas = res;

        return hateoas;
    }
}
