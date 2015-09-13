package scomanagementsystem.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import scomanagementsystem.domain.Services;
import scomanagementsystem.repository.ServiceRepository;
import scomanagementsystem.services.ServicesService;

import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public class ServicesServiceImpl implements ServicesService{
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Services> getAllServices()
    {
        List<Services> services = new ArrayList<>();
        Iterable<Services> values = serviceRepository.findAll();
        for(Services value: values)
        {
            services.add(value);
        }

        return services;
    }

    @Override
    public Services getServices(Integer serviceNo)
    {
        return serviceRepository.findOne(serviceNo);
    }
}
