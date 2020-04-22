package comlist.example.springdemo;

import java.util.List;

public class person {

    private String name;
    private Integer age;
    private String gender;
    private List<Car> carList;
    private List<person> spouseList;

    public person() {
    }

    public person(String name, Integer age, String gender, List<Car> carList) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.carList = carList;
    }

    public person(String name, Integer age, String gender, List<Car> carList, List<person> personList) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.carList = carList;
        this.spouseList = personList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<person> getPersonList() {
        return spouseList;
    }

    public void setPersonList(List<person> personList) {
        this.spouseList = personList;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", carList=" + carList +
                ", spouseList=" + spouseList +
                '}';
    }
}
