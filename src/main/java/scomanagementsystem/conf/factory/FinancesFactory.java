package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.Finances;

import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class FinancesFactory {
    public static Finances createFinances(Integer transNo,Map<String, String> values, double tithe, double offering, Integer serviceNo, String transDate){

        Finances finances = new Finances
                .Builder(transNo)
                .transName(values.get("transName"))
                .offeringAndTitheDate(values.get("offeringAndTitheDate"))
                .tithe(tithe)
                .offering(offering)
                .serviceNo(serviceNo)
                .transDate(transDate)
                .build();
        return finances;
    }
}
