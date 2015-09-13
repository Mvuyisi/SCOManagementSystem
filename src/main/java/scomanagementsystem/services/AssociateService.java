package scomanagementsystem.services;

import scomanagementsystem.domain.Associates;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface AssociateService {
    List<Associates> getAllAssociates();

    Associates getAssociates(String idNo);
}
