package scomanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import scomanagementsystem.domain.CellGroups;

/**
 * Created by student on 2015/05/21.
 */
public interface CellGroupsRepository extends CrudRepository<CellGroups,Integer> {
    public CellGroups findByCgNo(Long idNo);
}
