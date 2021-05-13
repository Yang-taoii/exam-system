package com.exam.controller;



import com.exam.entity.TUserEventLog;
import com.exam.service.TUserEventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户事件日志，记录用户操作信息 前端控制器
 * </p>
 *
 * @author yangtao
 * @since 2021-04-26
 */
@Controller
public class TUserEventLogController {

    @Autowired
    private TUserEventLogService logService;

    @ResponseBody
    @RequestMapping("/consumer/userLog/add")
    public boolean add(TUserEventLog log){
        return logService.save(log);
    }


}

