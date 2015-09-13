package scomanagementsystem;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ScomanagementsystemApplication.class)
@WebAppConfiguration
public class ScomanagementsystemApplicationTests extends TestCase {

	@Test
	public void contextLoads() {
	}

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ScomanagementsystemApplicationTests( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static TestSuite suite()
    {
        return new TestSuite( ScomanagementsystemApplicationTests.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

}

