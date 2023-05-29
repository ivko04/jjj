package classes;
//

public class Cars implements Comparable<Cars> {

    private int price;
    private String brand;
    private String model;
    private int FirstRegistrationFrom;
    private int kilometerage;
    private int FuelType;
    private String ExteriorColour;
    private int power;
    private String OwnerNumber;
    private String OwnerEMail;

    private String vinNumber;

    public Cars() {
        this.price = 0; // Car
        this.brand = ""; //
        this.model = ""; // 
        this.FirstRegistrationFrom = 0; // 
        this.kilometerage = 0; // 
        this.FuelType = 0;
        this.ExteriorColour = "";
        this.power = 0; //
        this.OwnerNumber = "";
        this.OwnerEMail = "";
        this.vinNumber = "";
    }

    public Cars(int price, String brand, String model, int FirstRegistrationFrom, int kilometerage, int FuelType, String ExteriorColour, int power, String OwnerNumber, String OwnerEMail, String vinNumber) {
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.FirstRegistrationFrom = FirstRegistrationFrom;
        this.kilometerage = kilometerage;
        this.FuelType = FuelType;
        this.ExteriorColour = ExteriorColour;
        this.power = power;
        this.OwnerNumber = OwnerNumber;
        this.OwnerEMail = OwnerEMail;
        this.vinNumber = vinNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getFirstRegistrationFrom() {
        return FirstRegistrationFrom;
    }

    public void setFirstRegistrationFrom(int FirstRegistrationFrom) {
        this.FirstRegistrationFrom = FirstRegistrationFrom;
    }

    public int getKilometerage() {
        return kilometerage;
    }

    public void setKilometerage(int kilometerage) {
        this.kilometerage = kilometerage;
    }

    public int getFuelType() {
        return FuelType;
    }

    public void setFuelType(int FuelType) {
        this.FuelType = FuelType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getExteriorColour() {
        return ExteriorColour;
    }

    public void setExteriorColour(String ExteriorColour) {
        this.ExteriorColour = ExteriorColour;
    }

    public String getOwnerNumber() {
        return OwnerNumber;
    }

    public void setOwnerNumber(String OwnerNumber) {
        this.OwnerNumber = OwnerNumber;
    }

    public String getOwnerEMail() {
        return OwnerEMail;
    }

    public void setOwnerEMail(String OwnerEMail) {
        this.OwnerEMail = OwnerEMail;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public void print(int num) {
        System.out.println(num + "\t" + price + "\t\t" + brand + "\t\t" + model + "\t\t" + FirstRegistrationFrom + "\t\t\t" + kilometerage + "\t\t\t" + ((FuelType == 1) ? "petrol" : (FuelType == 2) ? "diesel" : (FuelType == 3) ? "electricity" : (FuelType == 4) ? "hybrid" : "Unknown") + "\t\t\t" + ExteriorColour + "\t\t\t" + power + "\t\t\t" + OwnerNumber + "\t\t\t" + OwnerEMail);
    }

    @Override
    public int compareTo(Cars otherCar) {
        return this.brand.compareTo(otherCar.brand);
    }

}
