/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import classes.*;
import java.util.Comparator;

public class CarsComparator {

    public static Comparator<Cars> byKMage() {
        return Comparator.comparing(Cars::getKilometerage);
    }

    public static Comparator<Cars> byPrice() {
        return Comparator.comparing(Cars::getPrice);
    }

    public static Comparator<Cars> byFirstReg() {
        return Comparator.comparing(Cars::getFirstRegistrationFrom);
    }

}
