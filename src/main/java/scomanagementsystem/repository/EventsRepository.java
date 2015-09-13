package scomanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import scomanagementsystem.domain.Events;

/**
 * Created by student on 2015/05/21.
 */
public interface EventsRepository extends CrudRepository<Events, Integer>{
    public Events findByEventNo(Integer eventNo);
}
