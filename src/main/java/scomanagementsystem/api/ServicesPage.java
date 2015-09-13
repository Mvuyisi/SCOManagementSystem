package scomanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scomanagementsystem.Model.ServiceResourse;
import scomanagementsystem.domain.Services;
import scomanagementsystem.services.ServicesService;

/**
 * Created by student on 2015/09/13.
 */
public class ServicesPage {
    @Autowired
    private ServicesService servicesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "services details";
    }

    @RequestMapping(value = "/{serviceNo}", method = RequestMethod.GET)
    public ServiceResourse getService(@PathVariable Integer serviceNo)
    {
        ServiceResourse hateoas;
        Services services = servicesService.getServices(serviceNo);

        ServiceResourse res = new ServiceResourse
                .Builder(services.getServiceNo())
                .serviceName("Academic")
                .date("15 June 15")
                .venue("Room 2.70")
                .build();

        Link servicesDetails = new
                Link("http://localhost:8080/api/services/" + res.getServiceNo().toString())
                .withRel("services");

        res.add(servicesDetails);
        hateoas = res;

        return hateoas;
    }
}
