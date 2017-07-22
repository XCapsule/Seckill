package xin.ncuflag.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.ncuflag.entity.SuccessKilled;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by vince on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() throws Exception {
        successKilledDao.insertSuccessKilled(1003L,13236L);
    }

    @Test
    public void queryByIdWithSecKill() throws Exception {
       SuccessKilled successKilled= successKilledDao.queryByIdWithSecKill(1003,13236);
       System.out.print(successKilled.getSecKill().getName());
    }

}