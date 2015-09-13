package scomanagementsystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import scomanagementsystem.domain.Membership;
import scomanagementsystem.domain.SubcomsAndMinistries;
import scomanagementsystem.repository.SubcomsAndMinistriesRepository;
import scomanagementsystem.services.SubcomsAndMinistriesService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public class SubcomsAndMinistriesServiceImpl implements SubcomsAndMinistriesService{
    @Autowired
    SubcomsAndMinistriesRepository subcomsAndMinistriesRepository;

    @Override
    public List<SubcomsAndMinistries> getAllSubcomsAndMinistries()
    {
        List<SubcomsAndMinistries> subcomsAndMinistries = new ArrayList<>();
        Iterable<SubcomsAndMinistries> values = subcomsAndMinistriesRepository.findAll();
        for(SubcomsAndMinistries value: values)
        {
            subcomsAndMinistries.add(value);
        }

        return subcomsAndMinistries;
    }

    @Override
    public SubcomsAndMinistries getSubcomsAndMinistries(Integer smNo)
    {
        return subcomsAndMinistriesRepository.findOne(smNo);
    }

    @Override
    public List<Membership> getMembership(String studentNo)
    {
        return subcomsAndMinistriesRepository.findOne(studentNo).getMembership();
    }
}
