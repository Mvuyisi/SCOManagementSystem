package scomanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import scomanagementsystem.domain.SubcomsAndMinistries;

/**
 * Created by student on 2015/05/21.
 */
public interface SubcomsAndMinistriesRepository extends CrudRepository<SubcomsAndMinistries, Integer>{
    public SubcomsAndMinistries findBySmNo(Integer smNo);

    public SubcomsAndMinistries findOne(String studentNo);
}
