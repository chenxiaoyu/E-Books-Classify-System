/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;

import java.util.ArrayList;
import java.util.List;
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
public class BookTableModelTest {

    public BookTableModelTest() {
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
     * Test of setBookList method, of class BookTableModel.
     */
    @Test
    public void testSetBookList() {
        System.out.println("setBookList");
        List<BookItem> bookList = null;
        BookTableModel instance = new BookTableModel();
        instance.setBookList(bookList);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        assertEquals(bookList,instance.getBookList());
    }

    /**
     * Test of getRowCount method, of class BookTableModel.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        BookTableModel instance = new BookTableModel();
        List<BookItem> books = new ArrayList<BookItem>();
        int expResult = 4;
        for(int i = 0; i < expResult; ++i){
            BookItem book = new BookItem();
            books.add(book);
        }
        instance.setBookList(books);
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class BookTableModel.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        BookTableModel instance = new BookTableModel();
        int expResult = 4;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class BookTableModel.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int row = 0;
        int column = 0;
        BookTableModel instance = new BookTableModel();
        List<BookItem> books = new ArrayList<BookItem>();
        BookItem book = new BookItem();
            books.add(book);
        instance.setBookList(books);
        String expResult = "SE";
        String result = instance.getValueAt(row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isCellEditable method, of class BookTableModel.
     */
    @Test
    public void testIsCellEditable() {
        System.out.println("isCellEditable");
        int rowIndex = 0;
        int columnIndex = 0;
        BookTableModel instance = new BookTableModel();
        /*boolean expResult = true;
        boolean result = instance.isCellEditable(rowIndex, columnIndex);
        assertEquals(expResult, result);*/
        assertTrue("true",instance.isCellEditable(rowIndex, columnIndex));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class BookTableModel.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        BookTableModel instance = new BookTableModel();
        String expResult = "Name";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}