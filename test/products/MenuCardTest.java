/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package products;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jaime
 */
public class MenuCardTest {
    
    public MenuCardTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getSection method, of class MenuCard.
     */
    @Test
    public void testGetSection() {
        System.out.println("getSection");
        int index = 0;
        MenuCard instance = null;
        MenuCardSection expResult = null;
        MenuCardSection result = instance.getSection(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfSections method, of class MenuCard.
     */
    @Test
    public void testGetNumberOfSections() {
        System.out.println("getNumberOfSections");
        MenuCard instance = null;
        int expResult = 0;
        int result = instance.getNumberOfSections();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadFromDisk method, of class MenuCard.
     */
    @Test
    public void testLoadFromDisk() {
        System.out.println("loadFromDisk");
        MenuCard expResult = null;
        MenuCard result = MenuCard.loadFromDisk();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
