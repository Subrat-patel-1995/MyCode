package org.DSA.oops;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class HashUtils {

    public static void main(String[] args) {
        HashSet<Student> students=new HashSet<>();
        students.add(new Student("Sub",1));
        students.add(new Student("Sub1",1));
        students.add(new Student("Sub2",2));
        System.out.println(students);;

    }


}

class Student{
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        Student student = (Student) object;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}