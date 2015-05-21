package scomanagementsystem.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scomanagementsystem.conf.factory.AssociatesFactory;

/**
 * Created by student on 2015/05/10.
 */
public class AssociatesTest{
        @Before
        public void setUp() throws Exception {


        }

        @Test
        public void testCreateAssociate() throws Exception {

            Associates associates = AssociatesFactory
                    .createAssociate("9304255751089", "2015 Chairperson");

            Assert.assertEquals("9304255751089", associates.getIdNo());
        }

        @Test
        public void testUpadteAssociate() throws Exception {

            Associates associates =AssociatesFactory
                    .createAssociate("9304255751089", "2015 Chairperson");
            //updating
            Associates newassociate = new Associates
                    .Builder(associates.getIdNo())
                    .copy(associates)
                    .alumniStatus("2014/2015 Chairperson")
                    .build();

            Assert.assertEquals("2014/2015 Chairperson",newassociate.getAlumniStatus());
        }
}
