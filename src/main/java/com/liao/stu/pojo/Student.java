package com.liao.stu.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author lzp
 * @version 1.0
 * lzpnb!
 */

@Data
public class Student {
    public Integer id;
    public String name;
    public Integer age;
    public Date birthday;
}
