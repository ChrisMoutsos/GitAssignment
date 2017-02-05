package edu.fsu.cs.cen4021.armory;

/**
 * @author Chris 
 */
class SimpleMagicStaff extends BasicWeapon implements Weapon {

    SimpleMagicStaff() {
        super(80);
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        armor *= 0.8;
        int damage = Math.round(DAMAGE - armor);
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}
