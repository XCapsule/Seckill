package xin.ncuflag.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.ncuflag.entity.SecKill;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vince on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecKillDaoTest {

    @Resource
    private SecKillDao secKillDao;

    @Test
    public void reduceNumber() throws Exception {
        secKillDao.reduceNumber(1001L,new Date());
    }

    @Test
    public void queryById() throws Exception {
         secKillDao.queryById(1001L);
    }

    @Test
    public void queryAll() throws Exception {
        List<SecKill> secKills= secKillDao.queryAll(0,5);
        for(SecKill secKill:secKills){
            System.out.println(secKill.getName());
        }
    }

}