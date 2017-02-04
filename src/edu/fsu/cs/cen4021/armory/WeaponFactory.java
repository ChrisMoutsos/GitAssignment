/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fsu.cs.cen4021.armory;

/**
 * @author Javier
 */
public class WeaponFactory {

    public static Weapon getWeapon(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "sword":
                return new Sword();
            case "thechosenoneaxe":
                return new TheChosenOneAxe();
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

}
