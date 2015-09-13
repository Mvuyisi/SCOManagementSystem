package scomanagementsystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.repository.AssociatesRepository;
import scomanagementsystem.services.AssociateService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
@Service
public class AssociateServiceImpl implements AssociateService{
    @Autowired
    AssociatesRepository associatesRepository;

    @Override
    public List<Associates> getAllAssociates()
    {
        List<Associates> associates = new ArrayList<>();
        Iterable<Associates> values = associatesRepository.findAll();
        for(Associates value: values)
        {
            associates.add(value);
        }

        return associates;
    }

    @Override
    public Associates getAssociates(String idNo)
    {
        return associatesRepository.findOne(idNo);
    }
}
