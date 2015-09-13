package scomanagementsystem.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.CellGroupsFactory;
import scomanagementsystem.domain.CellGroups;

import java.util.HashMap;
import java.util.Map;
@SpringApplicationConfiguration(classes = ScomanagementsystemApplication.class)
@WebAppConfiguration
/**
 * Created by student on 2015/09/12.
 */
public class CellGroupCrudTest extends AbstractTestNGSpringContextTests {
    private Integer cgNo;
    private String studentNo;
    private String leader;
    private String venue;

    @Autowired
    CellGroupsRepository cellGroupsRepository;

    @Test
    public void testCreate() throws Exception
    {
        Map<String,String> values = new HashMap<String,String>();

        values.put("leader", "Mvuyisi");
        values.put("vanue", "Room 058A");

        CellGroups cellGroups = CellGroupsFactory
                .createCell(52, "212030086", values);


        cellGroupsRepository.save(cellGroups);
        cgNo = cellGroups.getCgNo();
        Assert.assertNotNull(cellGroups.getCgNo());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception
    {
        CellGroups cellGroups = cellGroupsRepository.findOne(cgNo);
        Assert.assertNotNull(cellGroups);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception
    {
        CellGroups cellGroups = cellGroupsRepository.findOne(cgNo);

        CellGroups newacell = new CellGroups
                .Builder(cellGroups.getCgNo())
                .copy(cellGroups)
                .studentNo("212030086")
                .leader("Musa")
                .venue("Room 058A")
                .build();

        cellGroupsRepository.save(newacell);

        CellGroups updatedCell = cellGroupsRepository.findOne(cgNo);
        Assert.assertEquals(updatedCell.getLeader(), leader);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception
    {
        CellGroups cellGroups = cellGroupsRepository.findOne(cgNo);
        cellGroupsRepository.delete(cellGroups);
        CellGroups deletedCell = cellGroupsRepository.findOne(cgNo);
        Assert.assertNull(deletedCell);
    }
}
