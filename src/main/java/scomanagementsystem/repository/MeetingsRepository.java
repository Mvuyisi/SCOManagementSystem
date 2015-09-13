package scomanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import scomanagementsystem.domain.Meetings;

/**
 * Created by student on 2015/05/21.
 */
public interface MeetingsRepository extends CrudRepository<Meetings, Integer>{
    public Meetings findByMeetingNo(Integer meetingNo);
}
