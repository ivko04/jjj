/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carscatalog;

import classes.Sellers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mcivko04
 */
public class SellersFileWork {

    public static ArrayList<Sellers> SellersFileReader(String path) {

        ArrayList<Sellers> sellersList = new ArrayList<Sellers>();

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\+");

                String mail = parts[0];
                String password = parts[1];

                Sellers seller = new Sellers(mail, password);
                sellersList.add(seller);

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        return sellersList;
    }

    public static void SellersFileWriter(ArrayList<Sellers> sellersList, String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Sellers seller : sellersList) {
                String line = seller.getSellersMail() + "+" + seller.getSellersPassword();
                writer.write(line);
                writer.newLine();
            }

            System.out.println("You were successfully registered.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
