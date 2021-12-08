package rpg_lab;

public interface HeroInventory {
    Iterable<Weapon> getInventory();
    void attack(Target target,RandomProvider random);

}
