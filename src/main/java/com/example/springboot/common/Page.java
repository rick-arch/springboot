package com.example.springboot.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Page implements Serializable {
    private Integer page;
    private Integer limit;
}
