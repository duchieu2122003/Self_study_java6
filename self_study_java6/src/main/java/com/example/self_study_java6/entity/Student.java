package com.example.self_study_java6.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hieundph25894
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;

    private Boolean gender;

    private Double marks;
}
