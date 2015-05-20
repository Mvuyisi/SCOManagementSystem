package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.Services;

import java.util.Map;

/**
 * Created by student on 2015/05/10.
 */
public class ServicesFactory {
    public static Services createService(int serviceNo,String serviceName, Map<String, String> values){

        Services service = new Services
                .Builder(serviceNo)
                .serviceName(serviceName)
                .date(values.get("date"))
                .venue(values.get("venue"))
                .build();
        return service;
    }
}