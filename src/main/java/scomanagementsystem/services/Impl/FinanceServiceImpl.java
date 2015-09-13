package scomanagementsystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.domain.Finances;
import scomanagementsystem.repository.AssociatesRepository;
import scomanagementsystem.repository.FinancesRepository;
import scomanagementsystem.services.FinancesService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public class FinanceServiceImpl implements FinancesService{
    @Autowired
    FinancesRepository financesRepository;

    @Override
    public List<Finances> getAllFinances()
    {
        List<Finances> finances = new ArrayList<>();
        Iterable<Finances> values = financesRepository.findAll();
        for(Finances value: values)
        {
            finances.add(value);
        }

        return finances;
    }

    @Override
    public Finances getFinances(Integer transNo)
    {
        return financesRepository.findOne(transNo);
    }
}
