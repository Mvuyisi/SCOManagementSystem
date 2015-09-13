package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.Address;
import scomanagementsystem.domain.Membership;
import scomanagementsystem.domain.PersonalDetails;

import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class MembershipFactory {
    public static Membership createMember(Map<String, String> values, Address address, PersonalDetails personalDetails){

        Membership membership = new Membership
                .Builder(values.get("212030086"))
                .salvationStatus(values.get("Born Again"))
                .address(address)
                .personalDetails(personalDetails)
                .build();
        return membership;
    }
}