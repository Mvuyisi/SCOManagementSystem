package scomanagementsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.FinancesFactory;
import scomanagementsystem.domain.Finances;
import scomanagementsystem.repository.FinancesRepository;
import scomanagementsystem.services.FinancesService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class FinancesServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    FinancesService financesService;

    private Integer transNo;

    @Autowired
    FinancesRepository financesRepository;

    @Test
    public void create() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();

        values.put("transName", "Deposit");
        values.put("offeringAndTitheDate", "15 June 15");

        Finances finances = FinancesFactory
                .createFinances(10, values, 1000, 200, 15, "12 August 15");


        financesRepository.save(finances);
        transNo = finances.getTransNo();
        Assert.assertNotNull(finances.getTransNo());
    }

    public void cleanUp() throws Exception
    {
        financesRepository.deleteAll();
    }
}
