package scomanagementsystem.services;

import scomanagementsystem.domain.CellGroups;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface CellGroupsService {
    List<CellGroups> getAllCellGroups();

    CellGroups getCellGroups(Integer cgNo);
}
