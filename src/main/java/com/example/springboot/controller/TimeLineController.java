package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.JsonResponseVO;
import com.example.springboot.entities.TimeLine;
import com.example.springboot.service.TimeLineService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.example.springboot.constant.Constant.PERMISSION_TIMELINE_ADD;
import static com.example.springboot.constant.Constant.PERMISSION_TIMELINE_VIEW;
import static com.example.springboot.constant.WebURIConstant.TIMELINE_LIST;

@Controller
@Slf4j
public class TimeLineController {
    @Autowired
    private TimeLineService timeLineService;

    @GetMapping(TIMELINE_LIST)
    @Log("查询时间线")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_TIMELINE_ADD)
    public List<TimeLine> timeLineList() {
        return timeLineService.selectAll();
    }

    @PostMapping("/timeLine/add")
    @Log("新增时间线")
    @ResponseBody
    @RequiresPermissions(value = PERMISSION_TIMELINE_VIEW)
    public JsonResponseVO timeLineAdd(@RequestBody TimeLine timeLine) {
        return new JsonResponseVO(timeLineService.addTimeLine(timeLine));
    }
}
