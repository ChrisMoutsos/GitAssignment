package edu.fsu.cs.cen4021.armory;

import java.io.*;

/**
 * @author Chris
 */
class TheChosenOneAxe extends BasicWeapon implements Weapon {

    TheChosenOneAxe() {
        super(0);

        int damage = 1;

        String filename = new File("").getAbsolutePath();
        filename = filename + "/conf/thechosenone.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            try {
                String line = br.readLine();
                String lastLine = line;
                while (line != null) {
                    line = br.readLine();

                    if (line.equals(lastLine)) {
                    /* we found another string A */
                        damage++;
                        lastLine = line;
                    } else {
                    /* we've found string B */

                        if (damage == 1) {
                        /* special case where string B is on line 1 or 2 */
                            line = br.readLine();
                            if (line.equals(lastLine)) {
                            /* string B is on line 2 */
                                damage++;
                            }
                        } else {
                            damage++;
                        }
                        break;
                    }
                }
            } catch(IOException ex) {
                System.err.println("File reading error!");
                ex.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch(IOException ex){
                    System.err.println("File closing error!");
                    ex.printStackTrace();
                }
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
        armor = (armor > 0 && armor < 20) ? 0 : armor;
        int damage = DAMAGE - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }

}
