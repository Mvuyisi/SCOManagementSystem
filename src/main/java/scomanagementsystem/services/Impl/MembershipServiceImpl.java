package scomanagementsystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.domain.Membership;
import scomanagementsystem.repository.AssociatesRepository;
import scomanagementsystem.repository.MembershipRepository;
import scomanagementsystem.services.MembershipService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public class MembershipServiceImpl implements MembershipService{
    @Autowired
    MembershipRepository membershipRepository;

    @Override
    public List<Membership> getAllMembers()
    {
        List<Membership> membership = new ArrayList<>();
        Iterable<Membership> values = membershipRepository.findAll();
        for(Membership value: values)
        {
            membership.add(value);
        }

        return membership;
    }

    @Override
    public Membership getMembership(String studentNo)
    {
        return membershipRepository.findOne(studentNo);
    }
}
