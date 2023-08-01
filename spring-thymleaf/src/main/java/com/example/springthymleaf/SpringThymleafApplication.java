package com.example.springthymleaf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.springthymleaf.entity.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

@SpringBootApplication
class HocSinh {
    private String ten;
    private Integer diem;

    public HocSinh() {
    }

    public HocSinh(String ten, Integer diem) {
        this.ten = ten;
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "HocSinh{" +
                "ten='" + ten + '\'' +
                ", diem=" + diem +
                '}';
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDiem(Integer diem) {
        this.diem = diem;
    }

    public String getTen() {
        return ten;
    }

    public Integer getDiem() {
        return diem;
    }
}

public class SpringThymleafApplication {


    public static void main(String[] args) throws IOException {
        // SpringApplication.run(SpringThymleafApplication.class, args);
        hoc1();
    }

    private static void hoc1() {
        // int tong =  listSoNguyen.stream().filter(a -> a%2==0).reduce(0,(a1,a2)-> a1+a2);
        int tong = listSoNguyen.stream().filter(a -> a % 2 == 0).reduce(0, Integer::sum);
        //.sum();
        double tich = listSoNguyen.stream()
                .filter(a -> a % 2 != 0).reduce(1, (a1, a2) -> a1 * a2);
        int tongBinhP = listSoNguyen.stream()
                .filter(a -> a % 2 != 0).reduce(0, (a1, a2) ->
                        (int) Math.pow(a1 + a2, 2));
        // trung binh cong cac so le
        System.out.println("sum: " + tong);
        System.out.println("tich: " + tich);
        System.out.println("tongBinhPhuongSoLe: " + tongBinhP);
        // b2 •	Lọc ra các sản phẩm có giá bán từ 100.000 đồng tới 500.000 đồng.
//        List<Product> result  = listSP.stream()
//                .filter(n -> n.getGiaSanPham() >= 100000 && n.getGiaSanPham() <= 500000)
//                .collect(Collectors.toList());
//        result.forEach(sp -> {
//            System.out.println("Sản phẩm có giá > 100.000 và < 500.000: "+ sp.getTenSanPham());
//        });
        List<Product> listPro = new ArrayList<>();
        listPro.add(new Product("A", 1200F));
        listPro.add(new Product("B", 2F));
        listPro.add(new Product("C", 80000F));
        listPro.add(new Product("D", 15F));
        listPro.stream().filter(a -> a.getGia() <= 500 && a.getGia() >= 2).forEach(System.out::println);
        //•	Tính tổng giá bán của tất cả các sản phẩm.
        Float sumLi = listPro.stream().map(o -> o.getGia()).reduce(0f, Float::sum);
        System.out.println("sum k: " + sumLi);
        //•	Tìm sản phẩm có giá bán cao nhất.
        //c1
        Optional<Product> productWithMaxPrice = listPro.stream()
                .max(Comparator.comparing(Product::getGia));
        // c2
//        Product productWithMaxPrice = listPro.stream()
//                .max((o1,o2) -> o1.getGia() > o2.getGia() ? 1:-1).get();
        System.out.println("sp gia max: " + productWithMaxPrice.toString());
        //3.	Tạo một danh sách các học sinh với thông tin gồm tên học sinh và điểm số. Hãy sử dụng Stream để thực hiện các tác vụ sau:
        //•	Lọc ra các học sinh có điểm số lớn hơn hoặc bằng 8.
        //•	Tính điểm trung bình của tất cả các học sinh.
        //•	Tìm học sinh có điểm số cao nhất.
        List<HocSinh> listStudent = new ArrayList<>();
        listStudent.add(new HocSinh("A", 5));
        listStudent.add(new HocSinh("B", 6));
        listStudent.add(new HocSinh("C", 7));
        listStudent.add(new HocSinh("D", 8));
        listStudent.add(new HocSinh("E", 9));
        //diem >= 8
        listStudent.stream()
                .filter(a -> a.getDiem() >= 8).forEach(System.out::println);
        // diem trung binh all student
        Double avg = listStudent.stream().mapToDouble(n -> n.getDiem()).average().getAsDouble();
       // c2 avg
       // int avg2 = listStudent.stream().map(HocSinh::getDiem).reduce(0, Integer::sum)/listStudent.size();
        System.out.println("Diem trung binh all: " + avg);
        // student cos diem max 2 cach
        Optional<HocSinh> hsDiemMax = listStudent.stream().max(Comparator.comparing(HocSinh::getDiem));
        HocSinh max_sv = listStudent.stream().reduce(listStudent.get(0), (max, sv) -> sv.getDiem() > max.getDiem() ? sv : max);
        System.out.println("Hoc sinh diem max: " + max_sv);
    }

    static List<Integer> listSoNguyen = Arrays.asList(1, 24, 34, 4, 5, 7);

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
