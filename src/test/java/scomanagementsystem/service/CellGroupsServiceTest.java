package scomanagementsystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.CellGroupsFactory;
import scomanagementsystem.domain.CellGroups;
import scomanagementsystem.repository.CellGroupsRepository;
import scomanagementsystem.services.CellGroupsService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/09/12.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class CellGroupsServiceTest extends AbstractTestNGSpringContextTests{
    @Autowired
    CellGroupsService cellGroupsService;

    @Autowired
    CellGroupsRepository cellGroupsRepository;

    private Integer cgNo;
    @Test
    public void create() throws Exception
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

    public void cleanUp() throws Exception
    {
        cellGroupsRepository.deleteAll();
    }
}
