package scomanagementsystem.api;
import org.springframework.hateoas.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import scomanagementsystem.Model.AssociateResource;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.services.AssociateService;

/**
 * Created by student on 2015/09/13.
 */
@RestController
@RequestMapping(value="/associate/**")
public class AssociatePage {
    @Autowired
    private AssociateService associateService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "associates details";
    }

    @RequestMapping(value = "/{idNo}", method = RequestMethod.GET)
    public AssociateResource getAssociates(@PathVariable String idNo)
    {
        AssociateResource hateoas;
        Associates associates = associateService.getAssociates(idNo);

        AssociateResource res = new AssociateResource
                .Builder(associates.getIdNo())
                .alumniStatus("Born Again")
                .address(associates.getAddress())
                .personalDetails(associates.getPersonalDetails())
                .build();

        Link associatesDetails = new
                Link("http://localhost:8080/api/associates/" + res.getIdNo().toString())
                .withRel("associates");

        res.add(associatesDetails);
        hateoas = res;

        return hateoas;
    }
}
