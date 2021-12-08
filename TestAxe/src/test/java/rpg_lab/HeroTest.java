package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private static final int TARGET_EX = 10;
    private Hero hero;

    @Before
    public void setUp() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        hero = new Hero("Hero", weaponMock);
    }

    @Test
    public void attackGainsExperienceIfTargetIsDeadTest() {
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_EX);
        RandomProvider randomProvider = new RandomProvider() {
        };
        hero.attack(targetMock, randomProvider);
        Assert.assertEquals(TARGET_EX, hero.getExperience());
    }

    @Test
    public void testAttackNoGainsExWhenTargetIsAlive(){
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(false);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_EX);
        RandomProvider randomProvider = new RandomProvider() {
        };
        hero.attack(targetMock, randomProvider);
        Assert.assertEquals(0, hero.getExperience());
    }

   /* private static final int TARGET_EX = 10;

    Target fakeTarget = new Target() {
        public int getHealth() {
            return 0;
        }
        public void takeAttack(int attackPoints) {
        }

        public int giveExperience() {
            return TARGET_EX;
        }

        public boolean isDead() {
            return true;
        }
    };
    Weapon fakeWeapon = new Weapon() {

        public int getAttackPoints() {
            return 10;
        }

        public int getDurabilityPoints() {
            return 0;
        }

        public void attack(Target target) {

        }
    };
    Hero hero = new Hero("Hero",fakeWeapon);
    @Test
    public void attackGainsExperienceIfTargetIsDeadTest(){
        hero.attack(fakeTarget);
        Assert.assertEquals(TARGET_EX,hero.getExperience());
    }*/

}