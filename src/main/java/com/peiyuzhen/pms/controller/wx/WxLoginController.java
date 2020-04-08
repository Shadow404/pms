package com.peiyuzhen.pms.controller.wx;

import com.peiyuzhen.pms.domain.Owner;
import com.peiyuzhen.pms.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class WxLoginController {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    @ResponseBody
    @RequestMapping("/wxLogin")
    public Map<String,Object> wxLogin(@RequestBody Owner owner, HttpServletRequest request){
        ValueOperations<String ,String> valueOperations=redisTemplate.opsForValue();
        Owner owner1=ownerRepository.findByOwnerPhone(owner.getOwnerPhone());
        String message="登录失败！";
        String sessionId=request.getSession().getId();
        Map<String,Object> map=new HashMap<>();
        map.put("flag",false);
        if(owner1!=null&&owner1.getOwnerPassWord().equals(owner.getOwnerPassWord())){
            ownerRepository.save(owner1);
            message="登录成功！";
            log.info("JSESSIONID={} 微信登录",sessionId);
            String jSessionId="JSESSIONID="+sessionId;
            valueOperations.set(String.valueOf(jSessionId.hashCode()),jSessionId);
            map.put("sessionId",sessionId);
            map.put("flag",true);
            map.put("owner",owner1);
        }
        map.put("message",message);

        log.info("{}user1 {}",owner1,owner);
        return map;
    }
}
