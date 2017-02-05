package edu.fsu.cs.cen4021.armory;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Chris
 */
class AncientMagicStaff extends BasicWeapon implements Weapon {

    @SuppressWarnings("unchecked")
    AncientMagicStaff() {
        super(0);

        int damage = 0;
        List<Integer> list;
        String filename = new File("").getAbsolutePath();
        filename = filename + "/conf/ancientstaff.obj";
        try {
            FileInputStream in = new FileInputStream(filename);
            try {
                ObjectInputStream ois = new ObjectInputStream(in);
                try {
                    Object obj = ois.readObject();
                    if (!(obj instanceof List)) {
                        System.err.println("Object was not a List");
                        System.exit(1);
                    }

                    list = (List<Integer>) obj;
                     /* raise each element to the second power */
                    for (ListIterator<Integer> it = list.listIterator(); it.hasNext();) {
                            Integer e = it.next();
                        it.set((int) Math.pow(e, 2));
                    }

                    /* remove the second and fifth elements */
                                list.remove(4);
                                list.remove(1);

                    /* reverse the order of the list */
                                Collections.reverse(list);
                    /* damage is sum of first, third, and seventh elements */
                    damage = list.get(0) + list.get(2) + list.get(6);
                } catch (ClassNotFoundException ex) {
                    System.err.println("Class not found exception!");
                    ex.printStackTrace();
                }
            } catch(IOException ex) {
                System.err.println("Object input stream error!");
                ex.printStackTrace();
            }

        } catch(FileNotFoundException ex) {
            System.err.println("File " + filename + " not found!");
            ex.printStackTrace();
        }

        this.DAMAGE = damage;
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        armor *= 0.75;
        int damage = Math.round(DAMAGE - armor);
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}
