package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private Axe axe;
    private Dummy dummy;

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;

    @Before
    public void createAxeAndDummy(){
        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH,DUMMY_XP);
    }

    @Test
    public void losesDurabilityAfterAttackTest() {
        this.axe.attack(this.dummy);
        Assert.assertEquals(0,axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void brokenAxeCantAttack() {
        this.axe.attack(this.dummy);
        this.axe.attack(this.dummy);
    }
}