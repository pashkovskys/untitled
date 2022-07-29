package java8;

import lombok.Getter;

@Getter
public class User {
    String name;
    int age;
    int weight;
    String speciality;
    boolean sex;

    public User(String name, int age, int weight, String speciality, boolean sex) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.speciality = speciality;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return " My name " + name + "," + " my age " + age + "," + " my weight " + weight + "," + " my speciality " + speciality + "," + " I'm a man " + sex;
    }
}
