package com.example.springboot.service.impl;

import com.example.springboot.entities.TimeLine;
import com.example.springboot.repository.TimeLineRepository;
import com.example.springboot.service.TimeLineService;
import com.example.springboot.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.example.springboot.constant.Constant.NUM_ZERO;

@Service
@Transactional(rollbackFor = Exception.class)
public class TimeLineServiceImpl implements TimeLineService {

    @Autowired
    private TimeLineRepository timeLineRepository;

    @Override
    public List<TimeLine> selectAll() {
        return timeLineRepository.selectAll(null);
    }

    @Override
    public boolean addTimeLine(TimeLine timeLine) {
        timeLine.setTimeLineTitle(timeLine.getTimeLineTitle() + "  " + DateUtil.format() + "  " + DateUtil.getWeek(new Date()));
        return timeLineRepository.insert(timeLine) > NUM_ZERO;
    }
}
