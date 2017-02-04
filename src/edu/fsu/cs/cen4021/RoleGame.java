package edu.fsu.cs.cen4021;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import edu.fsu.cs.cen4021.armory.Weapon;
import edu.fsu.cs.cen4021.armory.WeaponFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Javier
 */
public class RoleGame {

    public static void main(String[] args) {
        List<String> weaponNames = Arrays.asList(
                "Sword",
                "SimpleArrow",
                "SimpleAxe",
                "SimpleMagicStaff",
                "TheChosenOneAxe",
                "AncientMagicStaff"
        );

        List<Integer> armors = Arrays.asList(
                0,
                20
        );

        for (Iterator<String> it = weaponNames.iterator(); it.hasNext();) {
            String weaponName = it.next();

            printWeaponInfo(weaponName, armors);
        }
    }

    private static void printWeaponInfo(String weaponName, List<Integer> armors) {
        Weapon weapon = WeaponFactory.getWeapon(weaponName);
        System.out.println(weaponName + " has " + weapon.hit() + " of damage.");
        for (Iterator<Integer> it = armors.iterator(); it.hasNext();) {
            Integer armor = it.next();
            System.out.println(weaponName + " was able to do " + weapon.hit(armor) +
                    " of damage due to an armor with " + armor + " points.");
        }
        System.out.println("");
    }
}
