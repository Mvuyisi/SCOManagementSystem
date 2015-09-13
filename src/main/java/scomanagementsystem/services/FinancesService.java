package scomanagementsystem.services;

import scomanagementsystem.domain.Finances;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface FinancesService {
    List<Finances> getAllFinances();

    Finances getFinances(Integer transNo);
}
