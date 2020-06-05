package com.example.springboot.service;

import com.example.springboot.entity.TimeLine;

import java.util.List;

public interface TimeLineService {
    List<TimeLine> selectAll();

    boolean addTimeLine(TimeLine timeLine);
}
