package xin.ncuflag.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.ncuflag.entity.SecKill;
import xin.ncuflag.service.SeckillService;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vince on 2017/7/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-service.xml","classpath:/spring/spring-dao.xml"})
public class SeckillServiceImplTest {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getList() throws Exception {
        List<SecKill> list= seckillService.getList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        SecKill secKill=seckillService.getById(1001L);
        logger.info("secKill={}",secKill);
    }

    @Test
    public void getExposerById() throws Exception {
    }

    @Test
    public void executeSeckill() throws Exception {
    }

}