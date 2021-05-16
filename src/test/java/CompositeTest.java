import composite.Coupon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CompositeTest {
    private static Coupon c;

    @BeforeAll
    public static void setUp() {
        c = new Coupon(1, 1, 1, 1);
    }

    @Test
    public void getPriceTest() {
        assertEquals(0f, c.getPrice(), 0f);
    }

    @Test
    public void getNameTest() {
        assertEquals("S-burger-S-hotDrink-S-NOsauceFries-", c.getName());
    }
}
