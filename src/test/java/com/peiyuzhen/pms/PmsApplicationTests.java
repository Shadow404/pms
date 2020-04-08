package com.peiyuzhen.pms;

import com.peiyuzhen.pms.service.RepairService;
import com.peiyuzhen.pms.vo.RcVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PmsApplicationTests {
    @Autowired
    private RepairService repairService;
    @Test
    public void contextLoads() {
        List<RcVo> rcVos=repairService.findAllRcByOwnerId("1");
        log.info("{}rcvos",rcVos);
    }

}
