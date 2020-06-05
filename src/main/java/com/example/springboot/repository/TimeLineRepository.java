package com.example.springboot.repository;

import com.example.springboot.entity.TimeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimeLineRepository {


    List<TimeLine> queryAllTimeLine();

    Integer insertTimeLine(TimeLine timeLine);
}
