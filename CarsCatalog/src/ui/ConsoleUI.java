/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import carscatalog.CarsFileWork;

import carscatalog.CarsCatalog;
import carscatalog.SellersFileWork;
import classes.Cars;
import classes.Sellers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import utils.CarsComparator;
import utils.CatalogInterface;

public class ConsoleUI {

    private CatalogInterface catalog;
    static Scanner sc = new Scanner(System.in);
    int price;
    String brand = "any";
    String model = "any";
    int FirstRegistrationFrom = 0;
    int maxKilometerage = 0;
    int FuelType = 0;
    String ExteriorColour = "any";
    int minPower = 0;
    int maxPrice = 0;

    int regPrice;
    String regBrand;
    String regModel;
    int regFirstRegistration;
    int regKilometerage;
    int regFuelType;
    String regExteriorColour;
    int regPower;
    String regOwnerNumber;
    String regOwnerEMail;
    String regVinNumber;

    String usrMail;
    String usrPassword;

    String usrPasswordFirstTry;
    String usrPasswordSecondTry;

    String newUsrMailCheck;
    String newUsrPasswordFirstTry;
    String newUsrPasswordSecondTry;

    String usrMailCheck;

    String removeVinNumber;

    Scanner sIn = new Scanner(System.in);
    Scanner sf = new Scanner(System.in);

    String CarsPath;
    String SellersPath;

    ArrayList<Cars> arr = new ArrayList<Cars>();
    ArrayList<Sellers> arr2 = new ArrayList<Sellers>();
    ArrayList<Cars> usrArr = new ArrayList<Cars>();
    ArrayList<Cars> delArr = new ArrayList<Cars>();

    int choice1;
    boolean work, work2, work3, work4, work1, swork, swork1, swork2, ScndWork1, ScndWork2;

    public void console() {
        catalog = new CarsCatalog();
        getCarCatalogInfo();

        System.out.println("Write please path of file with list of cars:");
        CarsPath = sIn.nextLine();
        //CarsPath = "C:\\Users\\mcivko04\\Documents\\NetBeansProjects\\CarsCatalog\\src\\data\\cars.txt";
        arr = CarsFileWork.CarsFileReader(CarsPath);
        System.out.println("Write please path of file with list of sellers:");

        SellersPath = sIn.nextLine();
        //SellersPath = "C:\\Users\\mcivko04\\Documents\\NetBeansProjects\\CarsCatalog\\src\\data\\sellers.txt";
        arr2 = SellersFileWork.SellersFileReader(SellersPath);

        work = true;
        while (work) {

            System.out.println("\nCars Catalog\n1 - find a car\n2 - sell/remove a car\n0 - end");

            try {
                switch (sc.nextInt()) {
                    case 1:

                        System.out.println("At the moment there are " + CarsFileWork.CarsListSize(CarsPath) + " cars.");
                        work1 = true;
                        while (work1) {

                            String StringFirstRegistrationFrom = (FirstRegistrationFrom == 0) ? "any" : ("year " + Integer.toString(+FirstRegistrationFrom));
                            String StringMaxKilometerage = (maxKilometerage == 0) ? "any" : (Integer.toString(maxKilometerage) + " km");
                            String StringMinPower = (minPower == 0) ? "any" : (Integer.toString(minPower) + " hp");

                            String StringFuelType = (FuelType == 1) ? "petrol" : (FuelType == 2) ? "diesel" : (FuelType == 3) ? "electricity" : (FuelType == 4) ? "hybrid" : "any";
                            System.out.println("\nSelect the desired characteristics and go search"
                                    + "\n(The characteristics that have already been selected are indicated in brackets):"
                                    + "\n1 - car brand (" + brand + ")"
                                    + "\n2 - model (" + model + ")"
                                    + "\n3 - 1st registration from (" + StringFirstRegistrationFrom + ")"
                                    + "\n4 - maximum kilometerage (" + StringMaxKilometerage + ")"
                                    + "\n5 - fuel (" + StringFuelType + ")"
                                    + "\n6 - minimum horse powers (" + StringMinPower + ")"
                                    + "\n7 - Exterior colour (" + ExteriorColour + ")"
                                    + "\n8 - maximum price (" + maxPrice + ")"
                                    + "\n9 - Go search\n0 - back");

                            work3 = true;
                            while (work3) {
                                try {
                                    switch (sc.nextInt()) {
                                        case 1 -> {
                                            sc.nextLine();
                                            case1();
                                        }
                                        case 2 -> {
                                            sc.nextLine();
                                            case2();
                                        }
                                        case 3 -> {
                                            sc.nextLine();
                                            case3();
                                        }
                                        case 4 -> {
                                            sc.nextLine();
                                            case4();
                                        }
                                        case 5 -> {
                                            sc.nextLine();
                                            case5();
                                        }
                                        case 6 -> {
                                            sc.nextLine();
                                            case6();
                                        }
                                        case 7 -> {
                                            sc.nextLine();
                                            case7();
                                        }
                                        case 8 -> {
                                            sc.nextLine();
                                            case8();
                                        }
                                        case 9 -> {
                                            sc.nextLine();
                                            case9();
                                        }
                                        case 0 -> {
                                            sc.nextLine();
                                            work3 = false;
                                            work1 = false;
                                        }
                                        default -> {
                                            System.out.println("!Wrong choice, try again!");
                                            work3 = false;
                                        }
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("!Something went wrong, try again!");
                                    sc.nextLine();
                                    work3 = false;
                                }
                            }
                        }
                        break;

                    case 0:
                        work = false;
                        break;
                    case 2:
                        swork = true;
                        while (swork) {
                            try {
                                System.out.println("\nFirst you need to log in/register. Are you registered? If so, log in(1). If not, register(2).\n1 - log in\n2 - register\n0 - return");
                                switch (sc.nextInt()) {
                                    case 1 ->
                                        ScndCase1();
                                    case 2 ->
                                        ScndCase2();
                                    case 0 ->
                                        ScndCase0();
                                    default ->
                                        System.out.println("!Wrong choice, try again!");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("!Something went wrong, try again!");
                                sc.nextLine();
                            }
                        }
                        break;

                    default:
                        System.out.println("!Wrong choice, try again!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("!Something went wrong, try again!");
                sc.nextLine();
            }
        }

        //CarsFileReader.CarsFileReader("C:\\Users\\mcivko04\\Documents\\NetBeansProjects\\CarsCatalog\\src\\carscatalog\\cars.txt");
    }

    private void case1() {

        try {
            System.out.println("Write the brand and press enter(if you want any then write 0):");
            String ch = sIn.nextLine();
            if (!"0".equals(ch)) {
                brand = ch;
            } else if ("0".equals(ch)) {
                brand = "any";
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer value.");
            brand = "any";
        }
        work3 = false;
    }

    private void case2() {

        try {
            System.out.println("Write the model and press enter(if you want any then write 0):");
            String ch = sIn.nextLine();
            if (!"0".equals(ch)) {
                model = ch;
            } else if ("0".equals(ch)) {
                model = "any";
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer value.");
            model = "any";
        }
        work3 = false;
    }

    private void case3() {

        try {
            System.out.println("Write 1st registration from and press enter(if you want any then write 0):");

            int ch = sIn.nextInt();
            sIn.nextLine();
            if (ch > 0 && ch <= 2023) {
                FirstRegistrationFrom = ch;
            } else {
                FirstRegistrationFrom = 0;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer value.");
            FirstRegistrationFrom = 0;
        }
        work3 = false;
    }

    private void case4() {

        try {
            System.out.println("Write the maximum kilometerage and press enter(if you want any then write 0):");
            int ch = sIn.nextInt();
            sIn.nextLine();

            if (ch > 0) {
                maxKilometerage = ch;
            } else {
                maxKilometerage = 0;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer value.");
            maxKilometerage = 0;
        }
        work3 = false;
    }

    private void case5() {

        try {
            System.out.println("Choose the type of fuel:\n1 - petrol\n2 - diesel\n3 - electric\n4 - hybrid\n0 - any.");
            int ch = sIn.nextInt();
            sIn.nextLine();
            if (ch > 0 && ch <= 4) {
                FuelType = ch;
            } else {
                FuelType = 0;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer value.");
            FuelType = 0;
        }
        work3 = false;
    }

    private void case6() {

        try {
            System.out.println("Write the minimal horsepower and press enter(if you want any then write 0):");
            int ch = sIn.nextInt();
            sIn.nextLine();
            if (ch > 0) {
                minPower = ch;
            } else {
                minPower = 0;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer value.");
            minPower = 0;
        }
        work3 = false;
    }

    private void case7() {

        try {
            System.out.println("Write the exterior colour you want(if you want any then write 0):");
            String ch = sIn.nextLine();
            if (!"0".equals(ch)) {
                ExteriorColour = ch;
            } else if ("0".equals(ch)) {
                ExteriorColour = "any";
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer value.");
            minPower = 0;
        }
        work3 = false;
    }

    private void case8() {

        try {
            System.out.println("Write the maximum price you want(if you want any then write 0):");
            int ch = sIn.nextInt();
            sIn.nextLine();
            if (ch > 0) {
                maxPrice = ch;
            } else {
                maxPrice = 0;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer value.");
            maxPrice = 0;
        }
        work3 = false;
    }

    private void case9() {

        work4 = true;
        while (work4) {
            try {
                for (Cars car : CarsFileWork.CarsFileReader(CarsPath)) {
                    if (((brand.equals("any")) ? car.getBrand() : brand).equals(car.getBrand())
                            && ((model.equals("any")) ? car.getModel() : model).equals(car.getModel())
                            && ((FirstRegistrationFrom == 0) ? car.getFirstRegistrationFrom() : FirstRegistrationFrom) <= car.getFirstRegistrationFrom()
                            && ((maxKilometerage == 0) ? car.getKilometerage() : maxKilometerage) >= car.getKilometerage()
                            && ((FuelType == 0) ? car.getFuelType() : FuelType) == car.getFuelType()
                            && ((minPower == 0) ? car.getPower() : minPower) <= car.getPower()
                            && ((maxPrice == 0) ? car.getPrice() : maxPrice) >= car.getPrice()
                            && (((ExteriorColour.equals("any")) ? car.getExteriorColour() : ExteriorColour).equals(car.getExteriorColour()))) {
                        arr.add(car);
                    }
                }
                System.out.println("Select the type of filtering:\n1 - From max price\n2 - From min price\n3 - From max kilometerage\n4 - From min kilometerage\n5 - From oldest reg. date\n6 - From newest reg. date");
                switch (sc.nextInt()) {
                    case 1:
                        sc.nextLine();
                        int carNumber1 = 1;
                        Collections.reverse(sortByPrice(arr));
                        if (!arr.isEmpty()) {
                            System.out.println("According to your filters: ");
                            System.out.println("\n\n№\tPrice\t\tBrand\t\tModel\t\t1st reg. from\t\tKilometerage\t\tFuel type\t\tExterior colour\t\tPower");

                            for (Cars car : arr) {
                                car.print(carNumber1);
                                carNumber1++;
                            }
                        } else {
                            System.out.println("We didn't find anything for you. Use other characteristics, maybe something else interesting will be found.");

                        }
                        work4 = false;
                        work3 = false;
                        work1 = false;
                        break;
                    case 2:
                        sc.nextLine();
                        int carNumber2 = 1;
                        sortByPrice(arr);
                        if (!arr.isEmpty()) {
                            System.out.println("According to your filters: ");
                            System.out.println("\n\n№\tPrice\t\tBrand\t\tModel\t\t1st reg. from\t\tKilometerage\t\tFuel type\t\tExterior colour\t\tPower\t\tOwner's number\t\tOwner's e-mail");

                            for (Cars car : arr) {
                                car.print(carNumber2);
                                carNumber2++;
                            }
                        } else {
                            System.out.println("We didn't find anything for you. Use other characteristics, maybe something else interesting will be found.");

                        }
                        work4 = false;
                        work3 = false;
                        work1 = false;
                        break;
                    case 3:
                        sc.nextLine();
                        int carNumber3 = 1;
                        Collections.reverse(sortByKMage(arr));
                        if (!arr.isEmpty()) {
                            System.out.println("According to your filters: ");
                            System.out.println("\n\n№\tPrice\t\tBrand\t\tModel\t\t1st reg. from\t\tKilometerage\t\tFuel type\t\tExterior colour\t\tPower");

                            for (Cars car : arr) {
                                car.print(carNumber3);
                                carNumber3++;
                            }
                        } else {
                            System.out.println("We didn't find anything for you. Use other characteristics, maybe something else interesting will be found.");

                        }
                        work4 = false;
                        work3 = false;
                        work1 = false;
                        break;
                    case 4:
                        sc.nextLine();
                        int carNumber4 = 1;
                        sortByKMage(arr);
                        if (!arr.isEmpty()) {
                            System.out.println("According to your filters: ");
                            System.out.println("\n\n№\tPrice\t\tBrand\t\tModel\t\t1st reg. from\t\tKilometerage\t\tFuel type\t\tExterior colour\t\tPower");

                            for (Cars car : arr) {
                                car.print(carNumber4);
                                carNumber4++;
                            }
                        } else {
                            System.out.println("We didn't find anything for you. Use other characteristics, maybe something else interesting will be found.");

                        }
                        work4 = false;
                        work3 = false;
                        work1 = false;
                        break;
                    case 5:
                        sc.nextLine();
                        int carNumber5 = 1;
                        sortByFirstReg(arr);
                        if (!arr.isEmpty()) {
                            System.out.println("According to your filters: ");
                            System.out.println("\n\n№\tPrice\t\tBrand\t\tModel\t\t1st reg. from\t\tKilometerage\t\tFuel type\t\tExterior colour\t\tPower");

                            for (Cars car : arr) {
                                car.print(carNumber5);
                                carNumber5++;
                            }
                        } else {
                            System.out.println("We didn't find anything for you. Use other characteristics, maybe something else interesting will be found.");

                        }
                        work4 = false;
                        work3 = false;
                        work1 = false;
                        break;
                    case 6:
                        sc.nextLine();
                        int carNumber6 = 1;
                        Collections.reverse(sortByFirstReg(arr));
                        if (!arr.isEmpty()) {
                            System.out.println("According to your filters: ");
                            System.out.println("\n\n№\tPrice\t\tBrand\t\tModel\t\t1st reg. from\t\tKilometerage\t\tFuel type\t\tExterior colour\t\tPower");

                            for (Cars car : arr) {
                                car.print(carNumber6);
                                carNumber6++;
                            }
                        } else {
                            System.out.println("We didn't find anything for you. Use other characteristics, maybe something else interesting will be found.");

                        }
                        work4 = false;
                        work3 = false;
                        work1 = false;
                        break;
                    default:
                        System.out.println("!Wrong choice, try again!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("!Something went wrong, try again!");
                sc.nextLine();
            }
        }
    }

    private void ScndCase1() {
        sc.nextLine();
        try {
            ScndWork2 = true;
            while (ScndWork2) {
                System.out.println("Enter your e-mail:");
                usrMailCheck = sIn.nextLine();
                System.out.println("Enter your password:");
                usrPasswordFirstTry = sIn.nextLine();

                if (EmailCheck(usrMailCheck)) {
                    usrMail = usrMailCheck;
                    usrPassword = usrPasswordFirstTry;
                    ScndWork2 = false;
                    boolean logined = false;

                    for (Sellers seller : arr2) {
                        if (seller.getSellersMail().equals(usrMail) && seller.getSellersPassword().equals(usrPassword)) {
                            logined = true;
                            break;
                        }

                    }
                    if (logined) {
                        System.out.println("\nDo you want to add a car or remove it from the list?\n1 - add\n2 - remove\n0 - return.");
                        switch (sc.nextInt()) {
                            case 1:
                                sc.nextLine();
                                RegCarCase();
                                break;
                            case 2:
                                sc.nextLine();
                                DelCarCase();
                                break;
                            case 0:
                                sc.nextLine();
                                ScndWork2 = false;
                                break;
                            default:
                                System.out.println("!Wrong choice, try again!");
                                break;
                        }
                    } else {
                        System.out.println("You entered something incorrectly or such a user is not yet registered. Try again.");
                        ScndWork2 = false;
                    }

                } else {
                    System.out.println("You entered something incorrectly. Try again.");
                    ScndWork2 = false;
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("!Something went wrong, try again!");
            sc.nextLine();
        }
    }

    private void ScndCase2() {
        sc.nextLine();
        try {
            ScndWork2 = true;
            while (ScndWork2) {
                System.out.println("Enter your e-mail:");
                newUsrMailCheck = sIn.nextLine();
                System.out.println("Enter new password:");
                newUsrPasswordFirstTry = sIn.nextLine();
                System.out.println("Enter password once more:");
                newUsrPasswordSecondTry = sIn.nextLine();

                if (EmailCheck(newUsrMailCheck) && newUsrPasswordFirstTry != null && newUsrPasswordFirstTry.equals(newUsrPasswordSecondTry)) {
                    Sellers newUsr = new Sellers();
                    usrMail = newUsrMailCheck;
                    usrPassword = newUsrPasswordSecondTry;
                    newUsr.setSellersMail(usrMail);
                    newUsr.setSellersPassword(usrPassword);

                    boolean MailCheck = true;
                    for (Sellers seller : arr2) {
                        if (seller.getSellersMail().equals(usrMail)) {
                            MailCheck = false;
                            break;
                        }
                    }
                    if (MailCheck) {
                        arr2.add(newUsr);
                        SellersFileWork.SellersFileWriter(arr2, SellersPath);
                    } else {
                        System.out.println("The user with this email is already registered. Use a different email, or sign in if that's you.");
                    }
                    ScndWork2 = false;
                } else {
                    System.out.println("You entered something incorrectly. Try again.");
                    ScndWork2 = false;
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("!Something went wrong, try again!");
            sc.nextLine();
        }
    }

    private void ScndCase0() {
        sc.nextLine();
        swork = false;
    }

    private void RegCarCase() {
        sc.nextLine();
        System.out.println("To add a car, you must enter all characteristics:");
        try {
            System.out.println("Write price and press enter(to return back type 0):");
            int ch0 = sIn.nextInt();
            sIn.nextLine();

            if (0 < ch0) {
                regPrice = ch0;
            } else if (ch0 == 0) {
                ScndWork2 = false;

            } else {
                System.out.println("!Incorrect data. Try again!");
            }
            System.out.println("Write the brand and press enter(to return back type 0):");
            String ch = sIn.nextLine();
            if (!"0".equals(ch)) {
                regBrand = ch;
            } else {
                ScndWork2 = false;

            }

            System.out.println("Write the model and press enter(to return back type 0):");
            String ch1 = sIn.nextLine();
            if (!"0".equals(ch1)) {
                regModel = ch1;
            } else {
                ScndWork2 = false;

            }
            System.out.println("Write year of 1st registration and press enter(to return back type 0):");
            int ch2 = sIn.nextInt();
            sIn.nextLine();
            if (0 < ch2 && ch2 < 2023) {
                regFirstRegistration = ch2;
            } else if (ch2 == 0) {
                ScndWork2 = false;

            } else {
                System.out.println("!Incorrect data. Try again!");
            }
            System.out.println("Write kilometerage and press enter(to return back type 0):");
            int ch3 = sIn.nextInt();
            sIn.nextLine();
            if (0 < ch3) {
                regKilometerage = ch3;
            } else {
                ScndWork2 = false;

            }
            System.out.println("Choose the type of fuel:\n1 - petrol\n2 - diesel\n3 - electric\n4 - hybrid\n0 - return.");
            int ch4 = sIn.nextInt();
            sIn.nextLine();
            if (0 != ch4 && 5 > ch4 && ch4 > 0) {
                regFuelType = ch4;
            } else if (ch4 == 0) {
                ScndWork2 = false;

            } else {
                System.out.println("!Wrong choice. Try again!");
            }
            System.out.println("Write the exterior colour and press enter(to return back type 0):");
            String ch5 = sIn.nextLine();
            if (!"0".equals(ch5)) {
                regExteriorColour = ch5;
            } else {
                ScndWork2 = false;

            }
            System.out.println("Write the number of horsepower and press enter(to return back type 0):");
            int ch6 = sIn.nextInt();
            sIn.nextLine();
            if (0 < ch6) {
                regPower = ch6;
            } else {
                ScndWork2 = false;

            }
            System.out.println("Write your tel. number and press enter(to return back type 0):");
            String ch7 = sIn.nextLine();
            if (!"0".equals(ch7)) {
                regOwnerNumber = ch7;
                regOwnerEMail = usrMail;
            } else {
                ScndWork2 = false;

            }
            System.out.println("Write VIN and press enter(to return back type 0):");
            String ch8 = sIn.nextLine();
            if (!"0".equals(ch8)) {
                regVinNumber = ch8;
                Cars auto = new Cars(regPrice, regBrand, regModel, regFirstRegistration, regKilometerage, regFuelType, regExteriorColour, regPower, regOwnerNumber, regOwnerEMail, regVinNumber);
                arr.add(auto);
                CarsFileWork.CarsFileWriter(arr, CarsPath);

            } else {
                ScndWork2 = false;

            }

        } catch (InputMismatchException e) {
            System.out.println("!Something went wrong, try again!");

        }
        ScndWork2 = false;

    }

    private void DelCarCase() {
        System.out.println("Now the catalog contains your:");

        for (Cars car : arr) {
            if (car.getOwnerEMail() == usrMail) {
                delArr.add(car);

            }
        }
        Collections.sort(delArr);
        int CN = 1;
        for (Cars car : arr) {
            car.print(CN);
            CN++;
        }

        System.out.println(
                "To remove a car from the catalog, write its VIN number.");
        removeVinNumber = sIn.nextLine();

        CarsFileWork.removeCarByVIN(removeVinNumber, CarsPath);

    }

    private boolean EmailCheck(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private void getCarCatalogInfo() {
        System.out.println("*************** " + catalog.getProgName() + " ***************");
        System.out.println("************** " + catalog.getAuthorName() + " *************");
    }

    private ArrayList<Cars> sortByKMage(ArrayList<Cars> arr) {
        Collections.sort(arr, CarsComparator.byKMage());
        return arr;
    }

    private ArrayList<Cars> sortByPrice(ArrayList<Cars> arr) {
        Collections.sort(arr, CarsComparator.byPrice());
        return arr;
    }

    private ArrayList<Cars> sortByFirstReg(ArrayList<Cars> arr) {
        Collections.sort(arr, CarsComparator.byFirstReg());
        return arr;
    }

}
