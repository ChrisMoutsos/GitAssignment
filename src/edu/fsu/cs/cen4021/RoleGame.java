package edu.fsu.cs.cen4021;

import edu.fsu.cs.cen4021.armory.Weapon;
import edu.fsu.cs.cen4021.armory.WeaponFactory;

/**
 * @author Javier
 */
public class RoleGame {

    public static void main(String[] args) {
        printWeaponInfo("Sword", 20);
        printWeaponInfo("SimpleArrow", 20);
        printWeaponInfo("SimpleAxe", 20);
        printWeaponInfo("SimpleMagicStaff", 20);
        printWeaponInfo("TheChosenOneAxe", 20);
    }

    private static void printWeaponInfo(String weaponName, int armor) {
        Weapon weapon = WeaponFactory.getWeapon(weaponName);
        System.out.println(weaponName + " has " + weapon.hit() + " of damage.");
        System.out.println(weaponName + " was able to do " + weapon.hit(armor) +
                " of damage due to an armor with " + armor + " points.");
    }
}
