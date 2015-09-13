package scomanagementsystem.services;

import scomanagementsystem.domain.Membership;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface MembershipService {
    List<Membership> getAllMembers();

    Membership getMembership(String studentNo);
}
