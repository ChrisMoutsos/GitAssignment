package edu.fsu.cs.cen4021;

import edu.fsu.cs.cen4021.armory.Weapon;
import edu.fsu.cs.cen4021.armory.WeaponFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Chris
 */
public class RoleGame {

    public static void main(String[] args) {
        List<String> weaponNames = Arrays.asList(
                "Sword",
                "SimpleArrow",
                "SimpleAxe",
                "SimpleMagicStaff",
                "TheChosenOneAxe",
                "AncientMagicStaff",
                "WebRitualArrow"
        );

        List<Integer> armors = Arrays.asList(
                0,
                20
        );

        weaponNames.forEach(weaponName -> printWeaponInfo(weaponName, armors));
    }

    private static void printWeaponInfo(String weaponName, List<Integer> armors) {
        Weapon weapon = WeaponFactory.getWeapon(weaponName);
        System.out.println(weaponName + " has " + weapon.hit() + " of damage.");
        armors.forEach(armor ->
                System.out.println(weaponName + " was able to do " + weapon.hit(armor) +
                " of damage due to an armor with " + armor + " points."));
        System.out.println("");
    }
}
