package scomanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import scomanagementsystem.domain.Services;

/**
 * Created by student on 2015/05/21.
 */
public interface ServiceRepository extends CrudRepository<Services,Long> {
    public Services findByCode(int serviceNo);
}
