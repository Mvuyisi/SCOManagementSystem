package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.CellGroupsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/02.
 */
public class CellGroupsTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateCell() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("leader","Mvuyisi");
        values.put("venue", "South Point");

        CellGroups cellGroups = CellGroupsFactory
                .createCell((long) 10, "212030086", values);

        Assert.assertEquals(10, cellGroups.getCgNo());
    }

    @Test
    public void testUpadteCell() throws Exception {
        Map<String,String> values = new HashMap<String,String>();

        values.put("leader","Mvuyisi");
        values.put("venue", "South Point");

        CellGroups cellGroups =CellGroupsFactory
                .createCell(10, "212030086", values);
        //updating
        Map<String,String> updatedvalues = new HashMap<String,String>();

        updatedvalues.put("leader","Mvuyisi");
        updatedvalues.put("venue", "South Point Woodstock");

        CellGroups newacell = new CellGroups
                .Builder(cellGroups.getCgNo())
                .studentNo("212030086")
                .copy(cellGroups)
                .leader(updatedvalues.get("Mvuyisi"))
                .venue(updatedvalues.get("South Point Woodstock"))
                .build();

        Assert.assertEquals("Mvuyisi",newacell.getLeader());
    }
}
