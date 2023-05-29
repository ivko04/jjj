package carscatalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import classes.Cars;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

public class CarsFileWork {

    public static ArrayList<Cars> CarsFileReader(String path) {

        ArrayList<Cars> carsList = new ArrayList<Cars>();

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\+");

                int price = Integer.parseInt(parts[0]);
                String brand = parts[1];
                String model = parts[2];
                int FirstRegistrationFrom = Integer.parseInt(parts[3]);
                int kilometerage = Integer.parseInt(parts[4]);
                int FuelType = Integer.parseInt(parts[5]);
                String ExteriorColour = parts[6];
                int power = Integer.parseInt(parts[7]);
                String OwnerNumber = parts[8];
                String OwnerEMail = parts[9];
                String vinNumber = parts[10];

                Cars car = new Cars(price, brand, model, FirstRegistrationFrom, kilometerage, FuelType, ExteriorColour, power, OwnerNumber, OwnerEMail, vinNumber);
                carsList.add(car);

            }

            br.close();
            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }

        //System.out.println("According to your filters: ");
        //System.out.println("\n\n№\tPrice\t\tBrand\t\tModel\t\t1st reg. from\t\tKilometerage\t\tFuel type\t\tExterior colour\t\tPower\t\tIs working\t\tOriginal condition\tIs new");
        //int carNumber = 1;
        //for (Cars car : carsList) {
        //  car.print(carNumber);
        //carNumber++;
        //}
        return carsList;
    }

    public static int CarsListSize(String path) {
        int size = 0;
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                size++;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
        return size;
    }

    public static void CarsFileWriter(ArrayList<Cars> carsList, String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Cars car : carsList) {
                String line = car.getPrice() + "+" + car.getBrand() + "+" + car.getModel() + "+" + car.getFirstRegistrationFrom() + "+" + car.getKilometerage() + "+" + car.getFuelType() + "+" + car.getExteriorColour() + "+" + car.getPower() + "+" + car.getOwnerNumber() + "+" + car.getOwnerEMail() + "+" + car.getVinNumber();
                writer.write(line);
                writer.newLine();
            }

            System.out.println("The car has been successfully added.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void removeCarByVIN(String vin, String path) {
        try {
            File inputFile = new File(path);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = vin;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(lineToRemove)) {
                    continue;
                }

                writer.write(currentLine);
                writer.newLine();
            }

            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            System.out.println("The car with VIN: " + vin + " has been removed.");
        } catch (IOException e) {
            System.out.println("An error occurred while removing the car: " + e.getMessage());
        }
    }
}
