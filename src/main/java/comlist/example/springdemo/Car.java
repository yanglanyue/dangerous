package comlist.example.springdemo;

public class Car {
    private String brand;
    private String Model;
    private Integer maxSpeed;

    public Car() {
    }

    public Car(String brand, String model, Integer maxSpeed) {
        this.brand = brand;
        Model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", Model='" + Model + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
