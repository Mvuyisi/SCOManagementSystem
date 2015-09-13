package scomanagementsystem.services;

import scomanagementsystem.domain.Services;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface ServicesService {
    List<Services> getAllServices();

    Services getServices(Integer serviceNo);
}
