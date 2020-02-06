package ca.ubc.cs.cpsc210.servicecard.tests;

import ca.ubc.cs.cpsc210.servicecard.model.FoodServicesCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for FoodServiceCard class
class FoodServicesCardTest {

    FoodServicesCard c1;
    FoodServicesCard c2;
    FoodServicesCard c3;
    FoodServicesCard c4;
    FoodServicesCard cEmpty;

    @BeforeEach
    void runBefore(){
        c1 = new FoodServicesCard(2600);
        c2 = new FoodServicesCard(900);
        cEmpty = new FoodServicesCard(0);
    }

    @Test
    void testConstructor() {
        c3 = new FoodServicesCard(200);
        c4 = new FoodServicesCard(0);
        assertEquals(200, c3.getBalance());
        assertEquals(0, c3.getRewardPoints());
        assertEquals(0, c4.getBalance());
        assertEquals(0, c4.getRewardPoints());
    }

    @Test
    void testReload() {
        c1.reload(200);
        cEmpty.reload(0);
        assertEquals(2800,c1.getBalance());
        assertEquals(0,c1.getRewardPoints());
        assertEquals(0,cEmpty.getBalance());
        assertEquals(0,cEmpty.getRewardPoints());
        cEmpty.reload(200);
        assertEquals(200,cEmpty.getBalance());
        assertEquals(0,cEmpty.getRewardPoints());
    }

    @Test
    void testMakePurchase(){
        assertTrue(c1.makePurchase(2000));
        c1.makePurchase(2000);
        assertEquals(610,c1.getBalance());
        assertEquals(0,c1.getRewardPoints());
        c1.makePurchase(200);
        assertEquals(410,c1.getBalance());
        assertEquals(200,c1.getRewardPoints());
        c1.reload(200);
        assertEquals(610,c1.getBalance());
        assertEquals(200,c1.getRewardPoints());
        assertFalse(c2.makePurchase(2000));
        cEmpty.reload(10000);
        assertTrue(cEmpty.makePurchase(6100));
        cEmpty.makePurchase(6100);
        assertEquals(3930,cEmpty.getBalance());
        assertEquals(100,cEmpty.getRewardPoints());
    }

}