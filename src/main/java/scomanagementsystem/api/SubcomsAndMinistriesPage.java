package scomanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scomanagementsystem.Model.SubcomsAndMinistriesResource;
import scomanagementsystem.domain.SubcomsAndMinistries;
import scomanagementsystem.services.SubcomsAndMinistriesService;

/**
 * Created by student on 2015/09/13.
 */
public class SubcomsAndMinistriesPage {
    @Autowired
    private SubcomsAndMinistriesService subcomsAndMinistriesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "subcomsAndMinistries details";
    }

    @RequestMapping(value = "/{smNo}", method = RequestMethod.GET)
    public SubcomsAndMinistriesResource getSubcomsAndMinistries(@PathVariable Integer smNo)
    {
        SubcomsAndMinistriesResource hateoas;
        SubcomsAndMinistries subcomsAndMinistries = subcomsAndMinistriesService.getSubcomsAndMinistries(smNo);

        SubcomsAndMinistriesResource res = new SubcomsAndMinistriesResource
                .Builder(subcomsAndMinistries.getSmNo())
                .name("Ushering")
                .studNo("212030086")
                .leader("Mvuyisi")
                .venue("Office")
                .membership(subcomsAndMinistries.getMembership())
                .gatheringTimes(subcomsAndMinistries.getGatheringTimes())
                .build();

        Link subcomsAndMinistriesDetails = new
                Link("http://localhost:8080/api/subcomsAndMinistries/" + res.getSmNo().toString())
                .withRel("subcomsAndMinistries");

        res.add(subcomsAndMinistriesDetails);
        hateoas = res;

        return hateoas;
    }
}
