package rpg_lab;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DummyTest {
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private final int attackPoints = 10;
    Dummy dummy = new Dummy(DUMMY_HEALTH,DUMMY_XP);

    @Test
    public void dummyLosesHealthIfAttackedTest() {
        dummy.takeAttack(attackPoints);
        assertEquals(10,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttackedTest() {
        dummy.takeAttack(attackPoints + 10);
        dummy.takeAttack(attackPoints);
    }

    @Test
    public void deadDummyGiveExperienceTest() {
       dummy.takeAttack(attackPoints + 20);
       assertEquals(10,dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveExperienceTest() {
        dummy.giveExperience();
    }
}