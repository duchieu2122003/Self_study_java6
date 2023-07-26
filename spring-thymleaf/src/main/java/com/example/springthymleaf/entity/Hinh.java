package com.example.springthymleaf.entity;

import lombok.*;

/**
 * @author hieundph25894
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public abstract class Hinh {
    protected Canh canh;

    public abstract double tinhDienTich();
}
