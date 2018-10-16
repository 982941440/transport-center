package com.tota.transport.controller;


import com.tota.se.common.domain.Result;
import com.tota.se.common.domain.ResultCode;
import com.tota.transport.enums.TransTypeEnum;
import com.tota.transport.platform.ITransportBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 约定基本前端入参  transType 物流类型 1 达达 2 顺丰,service 服务接口名
 */

@Controller
@RequestMapping("/")
public class TransDispatchController {

    @Autowired
    ITransportBaseService dadaTransport;


    @RequestMapping("/index")
    public String index(HttpServletRequest req) {

        return "welcome";
    }

    @RequestMapping("/transport")
    @ResponseBody
    public Result transport(HttpServletRequest req) {
        String transType = req.getParameter("transType");
        String service = req.getParameter("service");
        String body = req.getParameter("body");
        try {
            if (TransTypeEnum.Dada.getKey().equals(transType)) {
                Object resultObj = dadaTransport.invokeService(service, body);
                Result result = new Result(ResultCode.COMMON_SUCCESS, true);
                result.setProperty("resultMap", resultObj);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(ResultCode.COMMON_SYSTEM_ERROR, false);
    }

}
