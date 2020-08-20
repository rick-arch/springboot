package com.example.springboot.service;

import com.example.springboot.entities.TimeLine;

import java.util.List;

public interface TimeLineService {
    List<TimeLine> selectAll();

    boolean addTimeLine(TimeLine timeLine);
}
