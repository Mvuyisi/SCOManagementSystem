package scomanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import scomanagementsystem.Model.CellGroupsResource;
import scomanagementsystem.domain.CellGroups;
import scomanagementsystem.services.CellGroupsService;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping(value="/cellGroups/**")
public class CellGroupsPage {
    @Autowired
    private CellGroupsService cellGroupsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "cellGroups details";
    }

    @RequestMapping(value = "/{cgNo}", method = RequestMethod.GET)
    public CellGroupsResource getCellGroups(@PathVariable Integer cgNo)
    {
        CellGroupsResource hateoas;
        CellGroups cellGroups = cellGroupsService.getCellGroups(cgNo);

        CellGroupsResource res = new CellGroupsResource
                .Builder(cellGroups.getCgNo())
                .studentNo("212030086")
                .leader("Mvuyisi")
                .venue("2.70")
                .build();

        Link cellGroupsDetails = new
                Link("http://localhost:8080/api/cellGroups/" + res.getCgNo().toString())
                .withRel("cellGroups");

        res.add(cellGroupsDetails);
        hateoas = res;

        return hateoas;
    }
}
