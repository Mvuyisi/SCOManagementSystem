package scomanagementsystem.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.FinancesFactory;
import scomanagementsystem.domain.Finances;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class FinancesCrudTest extends AbstractTestNGSpringContextTests {
    private Integer transNo;
    private String transName;
    private String transDate;
    private double tithe;
    private double offering;
    private String offeringAndTitheDate;
    private Integer serviceNo;

    @Autowired
    FinancesRepository financesRepository;

    @Test
    public void testCreate() throws Exception
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

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        Finances finances = financesRepository.findOne(transNo);
        Assert.assertNotNull(finances);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        Finances finances = financesRepository.findOne(transNo);

        Finances newfinances = new Finances
                .Builder(finances.getTransNo())
                .copy(finances)
                .transName("Deposit")
                .offeringAndTitheDate("15 August 15")
                .tithe(1000)
                .offering(2000)
                .serviceNo(15)
                .transDate("12 August 15")
                .build();

        financesRepository.save(newfinances);

        Finances updatedFinances = financesRepository.findOne(transNo);
        Assert.assertEquals(updatedFinances.getOffering(), offering);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        Finances finances = financesRepository.findOne(transNo);
        financesRepository.delete(finances);
        Finances deletedfinances = financesRepository.findOne(transNo);
        Assert.assertNull(deletedfinances);
    }
}
