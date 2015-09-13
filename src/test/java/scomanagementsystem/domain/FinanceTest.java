package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.FinancesFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/02.
 */
public class FinanceTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateFinance() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("transName", "Deposit");
        values.put("offeringAndTitheDate", "17 June 2015");

        Finances finances = FinancesFactory
                .createFinances(100, values,900, 500, 10, "15 September 2015");

        Assert.assertEquals(100, finances.getTransNo());
    }

    @Test
    public void testUpadteEvents() throws Exception {
        Map<String, String> updateValues = new HashMap<String, String>();

        updateValues.put("transName", "Deposit");
        updateValues.put("offeringAndTitheDate", "17 June 2015");

        Finances finances = FinancesFactory
                .createFinances(100, updateValues, 900, 500, 10, "16 September 2015");
        //updating
        Finances newfinances = new Finances
                .Builder(finances.getTransNo())
                .transName(updateValues.get("transName"))
                .offeringAndTitheDate(updateValues.get("offeringAndTitheDate"))
                .tithe(900)
                .offering(500)
                .serviceNo(10)
                .copy(finances)
                .offeringAndTitheDate("16 September 2015")
                .build();

        Assert.assertEquals("15 September 2015", newfinances.getOfferingAndTitheDate());
    }
}
