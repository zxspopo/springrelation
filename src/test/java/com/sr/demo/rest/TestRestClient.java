package com.sr.demo.rest;

import com.sr.demo.entity.FavUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2015/6/29.
 */

@ContextConfiguration(locations = {"/applicationContext-restclient.xml"})
public class TestRestClient extends AbstractJUnit4SpringContextTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGet() {
        FavUser user = restTemplate.getForObject("http://localhost:8080/sr/getFavUser?userName=aaa&userId=1&userAge=23", FavUser.class);
        System.out.println(user);
    }

    @Test
    public void testPost() {
        FavUser user = restTemplate.getForObject("http://localhost:8080/sr/getFavUser", FavUser.class);
        FavUser saveUser = restTemplate.postForObject("http://localhost:8080/sr/getFavUser", user, FavUser.class);
        System.out.println(saveUser);

    }

    @Test
    public void getParam() {
        FavUser user = restTemplate.getForObject("http://localhost:8080/sr/getUserName/name=aa", FavUser.class);
        System.out.println(user);
    }
}
