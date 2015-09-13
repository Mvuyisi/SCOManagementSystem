package scomanagementsystem.conf.factory;


import scomanagementsystem.domain.CellGroups;

import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class CellGroupsFactory {
    public static CellGroups createCell(Integer cgNo,String studNo, Map<String, String> values){

        CellGroups cellGroup = new CellGroups
                .Builder(cgNo)
                .studentNo(studNo)
                .leader(values.get("leader"))
                .venue(values.get("venue"))
                .build();
        return cellGroup;
    }
}
