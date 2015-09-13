package scomanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import scomanagementsystem.domain.Membership;

/**
 * Created by student on 2015/05/21.
 */
public interface MembershipRepository extends CrudRepository<Membership, String>{
    public Membership findByStudentNo(String studentNo);
}
