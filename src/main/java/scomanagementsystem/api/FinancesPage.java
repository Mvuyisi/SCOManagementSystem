package scomanagementsystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scomanagementsystem.Model.FinanceResource;
import scomanagementsystem.domain.Finances;
import scomanagementsystem.services.FinancesService;

/**
 * Created by student on 2015/09/13.
 */
public class FinancesPage {
    @Autowired
    private FinancesService financesService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "finances details";
    }

    @RequestMapping(value = "/{transNo}", method = RequestMethod.GET)
    public FinanceResource getFinances(@PathVariable Integer transNo)
    {
        FinanceResource hateoas;
        Finances finances = financesService.getFinances(transNo);

        FinanceResource res = new FinanceResource
                .Builder(finances.getTransNo())
                .transName("Deposit")
                .transDate("12 April 15")
                .tithe(1000)
                .offering(2000)
                .offeringAndTitheDate("12 April 15")
                .serviceNo(20)
                .build();

        Link financesDetails = new
                Link("http://localhost:8080/api/finances/" + res.getTransNo().toString())
                .withRel("finances");

        res.add(financesDetails);
        hateoas = res;

        return hateoas;
    }
}
