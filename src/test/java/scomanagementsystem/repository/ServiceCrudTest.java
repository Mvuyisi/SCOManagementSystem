package scomanagementsystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scomanagementsystem.ScomanagementsystemApplication;
import scomanagementsystem.conf.factory.ServicesFactory;
import scomanagementsystem.domain.Services;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
@SpringApplicationConfiguration(classes= ScomanagementsystemApplication.class)
@WebAppConfiguration
public class ServiceCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private ServiceRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
       // repository.deleteAll();

    }

    @Test
    public void create() throws Exception {

        Map<String,String> values = new HashMap<String,String>();

        values.put("date", "15 May 2015");
        values.put("venue", "2.70 Science Building");

        Services services = ServicesFactory
                .createService(100, "Academic Service", values);

        repository.save(services);
        id=services.getId();
        Assert.assertNotNull(services.getId());
    }

    /*@Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Services services = repository.findOne(id);
        Assert.assertNotNull(services.getId());
        Assert.assertEquals("Academic Service", services.getServiceName());
        Assert.assertTrue(Services.getDepartments().size() == 2);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

    }

    //    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Services services = repository.findOne(id);
        repository.delete(services);
        Services deletedFaculty = repository.findOne(id);
        Assert.assertNull(deletedFaculty);

    }*/
}
