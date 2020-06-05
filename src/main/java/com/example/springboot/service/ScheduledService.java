package com.example.springboot.service;

import com.example.springboot.repository.SysLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScheduledService {
    @Autowired
    private SysLogRepository sysLogRepository;

    /**
     * Cron有如下两种语法格式:
     * （1） Seconds Minutes Hours DayofMonth Month DayofWeek Year
     * (2）Seconds Minutes Hours DayofMonth Month DayofWeek
     * 各字段的含义:
     * 字段	                            允许值	                                        允许的特殊字符
     * 秒（Seconds）	                      0~59的整数	                                       , - * /              四个字符
     * 分（Minutes）	                  0~59的整数	                                        , - * /                 四个字符
     * 小时（Hours）	                  0~23的整数	                                        , - * /                 四个字符
     * 日期（DayofMonth）	              1~31的整数（但是你需要考虑你月的天数）	            ,- * ? / L W C      八个字符
     * 月份（Month）	                  1~12的整数或者 JAN-DEC	                            , - * /                 四个字符
     * 星期（DayofWeek）	              1~7的整数或者 SUN-SAT （1=SUN）                	, - * ? / L C #         八个字符
     * 年(可选，留空)（Year）	          1970~2099                                        	, - * /              四个字符
     * 星号(*)：可用在所有字段中，表示对应时间域的每一个时刻，例如，*在分钟字段时，表示“每分钟”；
     * 问号（?）：该字符只在日期和星期字段中使用
     * 减号(-)：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点触发，即10,11,12；
     * 逗号(,)：表达一个列表值，如在星期字段中使用“MON,WED,FRI”，则表示星期一，星期三和星期五触发；
     * 斜杠(/)：x/y表达一个等步长序列，x为起始值，y为增量步长值。如在分钟字段中使用0/15，则表示为0,15,30和45秒，而5/15在分钟字段中表示5,20,35,50
     * L：表示最后，只能出现在DayofWeek和DayofMonth域。如果在DayofWeek域使用5L,意味着在最后的一个星期四触发
     * W:表示有效工作日(周一到周五),只能出现在DayofMonth域，系统将在离指定日期的最近的有效工作日触发事件。例如：在 DayofMonth使用5W，如果5日是星期六，则将在最近的工作日：星期五，即4日触发。如果5日是星期天，则在6日(周一)触发；如果5日在星期一到星期五中的一天，则就在5日触发。另外一点，W的最近寻找不会跨过月份 。
     * LW:这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五。
     * #:用于确定每个月第几个星期几，只能出现在DayofMonth域。例如在4#2，表示某月的第二个星期三。
     */
    @Scheduled(cron = "59 59 8 * * ?")//：秒，分，时，天，月，周
    public void print() {
        log.info("--------执行定时任务--------------");
        sysLogRepository.deleteLog();
    }
}
