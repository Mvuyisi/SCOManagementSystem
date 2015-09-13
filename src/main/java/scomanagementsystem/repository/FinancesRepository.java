package scomanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import scomanagementsystem.domain.Finances;

/**
 * Created by student on 2015/05/21.
 */
public interface FinancesRepository extends CrudRepository<Finances, Integer>{
    public Finances findByTransNo(Integer transNo);
}
