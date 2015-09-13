package scomanagementsystem.services;

import scomanagementsystem.domain.Membership;
import scomanagementsystem.domain.SubcomsAndMinistries;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface SubcomsAndMinistriesService {
    List<SubcomsAndMinistries> getAllSubcomsAndMinistries();

    SubcomsAndMinistries getSubcomsAndMinistries(Integer smNo);

    List<Membership> getMembership(String studentNo);
}
