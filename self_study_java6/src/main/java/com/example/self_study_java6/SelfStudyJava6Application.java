package com.example.self_study_java6;

import com.example.self_study_java6.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.*;

@SpringBootApplication
public class SelfStudyJava6Application {

    static List<Student> list = Arrays.asList(new Student("Hieu", true, 10.0),
            new Student("A", true, 7.4), new Student("B", false, 8.5),
            new Student("C", false, 8.9), new Student("D", true, 2.0));

    public static void main(String[] args) {
//        SpringApplication.run(SelfStudyJava6Application.class, args);
        demo1();
        demo2();
        demo3();
    }

    private static void demo3() {
        Collections.sort(list, ((o1, o2) -> o1.getMarks().compareTo(o2.getMarks())
        ));
    }

    private static void demo2() {
        System.out.println("----------------------------------Demo2------------------------------------");
//        List<Student> list = Arrays.asList(new Student("Hieu", true, 10.0),
//                new Student("A", true, 7.4), new Student("B", false, 8.5),
//                new Student("C", false, 8.9), new Student("D", true, 2.0));
        list.forEach(n -> {
            System.out.println(n);
        });
    }

    private static void demo1() {
        System.out.println("--------------------------------Demo1--------------------------------");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(12);
        list.add(23);
        list.forEach(n -> System.out.println(n));
    }


}
