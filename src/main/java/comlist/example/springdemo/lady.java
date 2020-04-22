package comlist.example.springdemo;


import java.util.Map;

public class lady {

    private String name;
    private Integer age;
    private String gender;
    private Map<String,Car> car;

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

    public Map<String, Car> getCar() {
        return car;
    }

    public void setCar(Map<String, Car> car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "lady{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", car=" + car +
                '}';
    }
}
