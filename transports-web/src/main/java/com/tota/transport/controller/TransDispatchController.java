package com.tota.transport.controller;


import com.tota.se.common.domain.Result;
import com.tota.se.common.domain.ResultCode;
import com.tota.se.common.exception.BusinessException;
import com.tota.se.common.util.date.DateUtil;
import com.tota.transport.common.domain.Callback;
import com.tota.transport.common.enums.TransTypeEnum;
import com.tota.transport.common.tools.DadaTransport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 约定基本前端入参  transType 物流类型 1 达达 2 顺丰,service 服务接口名
 */

@Controller
@RequestMapping("/")
public class TransDispatchController {


    @RequestMapping("/index")
    public String index(HttpServletRequest req) {

        return "welcome";
    }

    @RequestMapping("/toCallback")
    public String toCallback(HttpServletRequest req) {

        return "callback";
    }

    @RequestMapping("/transport")
    @ResponseBody
    public String transport(HttpServletRequest req) {
        String transType = req.getParameter("transType");
        String service = req.getParameter("service");
        String body = req.getParameter("body");
        try {
            if (TransTypeEnum.Dada.getKey().equals(transType)) {
                Object resultObj = DadaTransport.invoke(service, body);

                return resultObj.toString();
            }
        } catch (Exception e) {
            throw new BusinessException("请求接口失败！");
        }
        return "";
    }

    @RequestMapping("/transport1")
    @ResponseBody
    public Result transport1(HttpServletRequest req) {
        String transType = req.getParameter("transType");
        String service = req.getParameter("service");
        String body = req.getParameter("body");
        try {
            if (TransTypeEnum.Dada.getKey().equals(transType)) {
                Object resultObj = DadaTransport.invoke(service, body);
                Result result = new Result(ResultCode.COMMON_SUCCESS, true);
                result.setProperty("resultMap", resultObj);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(ResultCode.COMMON_SYSTEM_ERROR, false);
    }



    @RequestMapping(value ="/callback", method = RequestMethod.POST)
    @ResponseBody
    public Result callback(@ModelAttribute("callback") Callback callback) {

        Result result = new Result(ResultCode.COMMON_SUCCESS, true);
        result.setUseDateFormat(true);
        result.setDateFormat(DateUtil.LONG_DATE_FORMAT_STR);

        result.setProperty("resultMap",callback);

        return result;
    }

}
