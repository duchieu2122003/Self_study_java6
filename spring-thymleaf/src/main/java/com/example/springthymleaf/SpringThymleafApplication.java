package com.example.springthymleaf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.springthymleaf.entity.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SpringThymleafApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringThymleafApplication.class, args);

    }

    static List<Student> list = Arrays.asList(new Student("Hieu", true, 9.0),
            new Student("A", true, 7.4), new Student("B", false, 8.5),
            new Student("C", false, 8.9), new Student("D", true, 2.0));
//
//    private static void demo10AstractClass() {
//        Canh c1 = new Canh(2);
//        Canh c2 = new Canh(5);
//        Hinh hinhChuNhat = new HinhChuNhat(c1,5,3);
//        Hinh hinhVuong = new HinhVuong(c2,5,5);
//        System.out.println("S HCN: " + hinhChuNhat.tinhDienTich());
//        System.out.println("S HV: " + hinhVuong.tinhDienTich());
//    }

    private static void demo9() throws IOException {
        //WRite JSON
        String json = "D:\\FPOLYK17\\6_SUMMER2023\\Block2\\SOF306_Java6_ca2thu6\\Self_study\\spring-thymleaf\\src\\main\\resources\\people0.json";
//        TypeReference<List<People0>> type =  new TypeReference<List<People0>>(){};
        TypeReference<List<People0>> typeReference = new TypeReference<List<People0>>() {
        };
        ObjectMapper mapper = new ObjectMapper();
        //  People0 people = mapper.readValue(new File(json), People0.class);
        List<People0> people0List = mapper.readValue(new File(json), typeReference);
        System.out.println(people0List.get(0).toString());

//        people.forEach(n -> System.out.println(n));
    }

    private static void demo8() throws IOException {
        // READING JSON
        String json = "D:\\FPOLYK17\\6_SUMMER2023\\Block2\\SOF306_Java6_ca2thu6\\Self_study\\spring-thymleaf\\src\\main\\resources\\people0.json";
        ObjectMapper mapper = new ObjectMapper();//được sử dụng để chuyển đổi giữa các đối tượng Java và các định dạng
        // dữ liệu như JSON hoặc XML. Đặc biệt, ObjectMapper được sử dụng phổ biến để chuyển đổi giữa các đối tượng Java
        // và chuỗi JSON và ngược lại.
        JsonNode people0 = mapper.readTree(new File(json));
        // trong Java được sử dụng để lặp qua tập hợp people0 và in ra màn hình các phần tử của tập hợp đó.
        //people0: Đây là tập hợp (collection) chứa các phần tử mà chúng ta muốn lặp qua.
        //iterator(): trả về một đối tượng Iterator, cho phép chúng ta lặp qua các phần tử của tập hợp.
        //forEachRemaining():lặp qua tất cả các phần tử còn lại của tập hợp
        people0.iterator().forEachRemaining(people -> System.out.println(people));
    }

    private static void demo7() {
        // TiM NHAN VIEN CO LUONG THAP NHAT
        Student result = list.stream().reduce(list.get(0), (min, staff) -> {
            if (staff.getMarks() < min.getMarks()) {
                return staff;
            }
            return min;
        });
        System.out.println("Diem thap nhat: " + result);
    }

    private static void demo6() {
        double tongDiemLop = list.stream()
                .map(n -> n.getMarks())
                .reduce(0.0, (a, student) -> a + student);// a la tong cong gop, student la mark tung phan tu
        System.out.println("demo6 tong diem lop : " + tongDiemLop);
    }

    private static void demo5() {
        // demo forech tang diem
        list.stream().forEach(n -> n.setMarks(n.getMarks() + 1));
        System.out.println(list);
    }

    private static void demo4Filter() {
        List<Integer> lists = Arrays.asList(2, 1, 3, 7, 8, 4, 5);
        double a = lists.stream()
                .filter(i -> i % 2 == 0)
                .peek(System.out::println)
                .map(n -> Math.sqrt(n))
                .mapToDouble(d -> d)
                .average().getAsDouble();
        System.out.println("a: " + a);
    }

    private static void demo3() {
        Collections.sort(list, ((o1, o2) -> o1.getMarks().compareTo(o2.getMarks())
        ));
    }

    private static void demo2() {
        System.out.println("----------------------------------Demo2------------------------------------");
        List<Student> list = Arrays.asList(new Student("Hieu", true, 10.0),
                new Student("A", true, 7.4), new Student("B", false, 8.5),
                new Student("C", false, 8.9), new Student("D", true, 2.0));
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
