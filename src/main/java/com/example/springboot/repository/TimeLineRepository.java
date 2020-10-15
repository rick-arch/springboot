package com.example.springboot.repository;

import com.example.springboot.entities.TimeLine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeLineRepository extends BaseRepository<TimeLine> {

}
