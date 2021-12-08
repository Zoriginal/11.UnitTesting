package rpg_lab;

import java.util.List;
import java.util.Random;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> possibleLoot;


    public Hero(String name,Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target,RandomProvider random) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
