package com.sr.demo.jpa;

import com.sr.demo.entity.FavUser;
import com.sr.demo.respository.FavUserRespository;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2015/5/29.
 */
@Transactional
@ContextConfiguration(locations = {"/applicationContext-jdbc.xml"})
public class JPATest extends AbstractJUnit4SpringContextTests {


    @Autowired
    private FavUserRespository favUserRespository;


    @Test
    public void saveUser() {

        favUserRespository.save(new FavUser("test", "test", 12, new Date()));
    }
}
