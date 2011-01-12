/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BackGround;

import java.util.LinkedList;
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
public class DatabaseConnectorTest {

    public DatabaseConnectorTest() {
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
     * Test of getDatabaseConnectorInstance method, of class DatabaseConnector.
     */
    @Test
    public void testGetDatabaseConnectorInstance() {
        System.out.println("getDatabaseConnectorInstance");
        DatabaseConnector expResult = DatabaseConnector.getDatabaseConnectorInstance();

        DatabaseConnector result = DatabaseConnector.getDatabaseConnectorInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of connect method, of class DatabaseConnector.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        DatabaseConnector instance = DatabaseConnector.getDatabaseConnectorInstance();
        int expResult = ErrorCode.Success;
        int result = instance.connect();
        assertEquals(expResult, result);
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class DatabaseConnector.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        DatabaseConnector instance = DatabaseConnector.getDatabaseConnectorInstance();
        instance.connect();
        int expResult = ErrorCode.Success;
        int result = instance.close();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class DatabaseConnector.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        String userName = "lzxss";
        String password = "123456";
        DatabaseConnector instance = DatabaseConnector.getDatabaseConnectorInstance();
        instance.connect();
        int expResult = ErrorCode.Success;
        int result = instance.register(userName, password,"");
        assertEquals(expResult, result);
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class DatabaseConnector.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String userName = "曾仲";
        String password = "123456";
        DatabaseConnector instance = DatabaseConnector.getDatabaseConnectorInstance();
        instance.connect();
        int expResult = ErrorCode.Success;
        int result = instance.login(userName, password);
        instance.close();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class DatabaseConnector.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String userName = "曾仲";
        String newPassword = "888888";
        DatabaseConnector instance = DatabaseConnector.getDatabaseConnectorInstance();
        instance.connect();
        int expResult = ErrorCode.Success;
        int result = instance.changePassword(userName, newPassword);
        assertEquals(expResult, result);
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSignature method, of class DatabaseConnector.
     */
    @Test
    public void testSetSignature() {
        System.out.println("setSignature");
        String userName = "曾仲";
        String signature = "你好";
        DatabaseConnector instance = DatabaseConnector.getDatabaseConnectorInstance();
        instance.connect();
        int expResult = ErrorCode.Success;
        int result = instance.setSignature(userName, signature);
        instance.close();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of requestToBeFriend method, of class DatabaseConnector.
     */
    @Test
    public void testRequestToBeFriend() {
        System.out.println("requestToBeFriend");
        String inviterName = "吴凯发";
        String inviteeName = "李志勋";
        DatabaseConnector instance =DatabaseConnector.getDatabaseConnectorInstance();
        instance.connect();
        int expResult = ErrorCode.Success;
        int result = instance.requestToBeFriend(inviterName, inviteeName);
        instance.close();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}