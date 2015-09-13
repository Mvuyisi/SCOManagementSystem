package scomanagementsystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.domain.CellGroups;
import scomanagementsystem.repository.AssociatesRepository;
import scomanagementsystem.repository.CellGroupsRepository;
import scomanagementsystem.services.CellGroupsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public class CellGroupsServiceImpl implements CellGroupsService{
    @Autowired
    CellGroupsRepository cellGroupsRepository;

    @Override
    public List<CellGroups> getAllCellGroups()
    {
        List<CellGroups> cellGroups = new ArrayList<>();
        Iterable<CellGroups> values = cellGroupsRepository.findAll();
        for(CellGroups value: values)
        {
            cellGroups.add(value);
        }

        return cellGroups;
    }

    @Override
    public CellGroups getCellGroups(Integer cgNo)
    {
        return cellGroupsRepository.findOne(cgNo);
    }
}
