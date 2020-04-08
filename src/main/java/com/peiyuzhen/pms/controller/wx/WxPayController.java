package com.peiyuzhen.pms.controller.wx;

import com.peiyuzhen.pms.service.PayService;
import com.peiyuzhen.pms.vo.PayVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api")
@ResponseBody
@Slf4j
public class WxPayController {
    @Autowired
    private PayService payService;
    @RequestMapping("payPerson")
    public Map<String,Object> payPerson(@RequestParam(value = "ownerId")String  ownerId){
        List<PayVo> payVos=payService.findAllByOwnerId(ownerId);
        Map map=new HashMap();
        map.put("payVos",payVos);
        return map;
    }
    @RequestMapping("payMoney")
    public Map<String,Object> payMoney(@RequestParam(value = "payId")String payId){
        int result=payService.payMoney(payId);
        Map map=new HashMap();
        map.put("result",result);
        log.info("{}result",result);
        return map;
    }
}
