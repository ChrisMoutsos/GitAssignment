package edu.fsu.cs.cen4021.armory;

/**
 * @author Chris 
 */
class SimpleArrow extends BasicWeapon implements Weapon {

    SimpleArrow() {
        super(70);
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        armor = Math.max(0, armor - 5);
        int damage = DAMAGE - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}
