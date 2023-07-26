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
@Builder
public class HinhChuNhat extends Hinh {

    private Integer chieuDai;
    private Integer chieuRong;

    public HinhChuNhat(Canh c1, int i, int i1) {
        super(c1);
        this.chieuDai = i;
        this.chieuRong = i1;
    }

    @Override
    public double tinhDienTich() {
        return (this.chieuDai + this.chieuRong)*2;
    }
}
