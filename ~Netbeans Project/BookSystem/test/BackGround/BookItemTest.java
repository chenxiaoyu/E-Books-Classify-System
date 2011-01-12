/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class BookItemTest {

    public BookItemTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setBookName method, of class BookItem.
     */
    @Test
    public void testSetBookName() {
        System.out.println("setBookName");
        String name = "Database";
        BookItem instance = new BookItem();
        instance.setBookName(name);
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(name,instance.getBookName());

    }

    /**
     * Test of setBookISBN method, of class BookItem.
     */
    @Test
    public void testSetBookISBN() {
        System.out.println("setBookISBN");
        String name = "888-888-888";
        BookItem instance = new BookItem();
        instance.setBookISBN(name);
        //TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals (name,instance.getBookISBN());
    }

    /**
     * Test of setLocation method, of class BookItem.
     */
    @Test
    public void testSetLocation() {
        System.out.println("setLocation");
        String name = "./sxe";
        BookItem instance = new BookItem();
        instance.setLocation(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals (name,instance.getBookLocation());
    }

    /**
     * Test of setBranch method, of class BookItem.
     */
    @Test
    public void testSetBranch() {
        System.out.println("setBranch");
        String name = "Item1";
        BookItem instance = new BookItem();
        instance.setBranch(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals (name,instance.getBranch());
    }

    /**
     * Test of setAuthor method, of class BookItem.
     */
    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String name = "Wang";
        BookItem instance = new BookItem();
        instance.setAuthor(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals (name,instance.getAuthor());
    }

    /**
     * Test of setId method, of class BookItem.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String name = "00";
        BookItem instance = new BookItem();
        instance.setId(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals (name,instance.getId());
    }

    /**
     * Test of SetDescription method, of class BookItem.
     */
     @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        BookItem instance = new BookItem( );
        String descreiption  = "Unkown";
        instance.setDescription(descreiption);
        assertEquals(descreiption, instance.getDescription());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getBookName method, of class BookItem.
     */
    @Test
    public void testGetBookName() {
        System.out.println("getBookName");
        BookItem instance = new BookItem();
        String expResult = "Database";
        instance.setBookName(expResult);
        String result = instance.getBookName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBookISBN method, of class BookItem.
     */
    @Test
    public void testGetBookISBN() {
        System.out.println("getBookISBN");
        BookItem instance = new BookItem();
        String expResult = "888-888-888";
        instance.setBookISBN(expResult);
        String result = instance.getBookISBN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBookLocation method, of class BookItem.
     */
    @Test
    public void testGetBookLocation() {
        System.out.println("getBookLocation");
        BookItem instance = new BookItem();
        String expResult = "./sxe";
        instance.setLocation(expResult);
        String result = instance.getBookLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBranch method, of class BookItem.
     */
    @Test
    public void testGetBranch() {
        System.out.println("getBranch");
        BookItem instance = new BookItem();
        String expResult = "Item1";
        instance.setBranch(expResult);
        String result = instance.getBranch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class BookItem.
     */
    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        BookItem instance = new BookItem();
        String expResult = "Wang";
        instance.setAuthor(expResult);
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class BookItem.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        BookItem instance = new BookItem();
        String expResult = "00";
        instance.setId(expResult);
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of getDescription method, of class BookItem.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        BookItem instance = new BookItem( );
        String expResult = "Unkown";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

   
}