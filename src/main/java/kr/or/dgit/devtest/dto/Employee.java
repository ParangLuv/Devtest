package kr.or.dgit.devtest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {

    private int eno;
    private String ename;
    private int salary;
    private int dno;
    private boolean gender;
    private Date joindate;
    private int title;

}
