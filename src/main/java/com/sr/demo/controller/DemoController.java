package com.sr.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sr.demo.entity.FavUser;
import com.sr.demo.respository.FavUserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by Administrator on 2015/5/24.
 */
@RestController
public class DemoController {

    @Autowired
    private FavUserRespository favUserRespository;

    @RequestMapping("saveFavUser")
    public FavUser createUser(@RequestBody String body) {

        ObjectMapper mapper = new ObjectMapper();
        FavUser favUser = null;
        try {
            favUser = mapper.readValue(URLDecoder.decode(body), FavUser.class);
            Long id = favUserRespository.findNextId();
            favUser.setId(id);
            favUserRespository.save(favUser);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favUser;
    }

    @RequestMapping(value = "/getUserName", method = RequestMethod.POST)
    public String getUserName(@RequestParam(value = "name") String name) {
        return name;
    }

    @RequestMapping("getFavUser")
    public FavUser getFavUser(@RequestParam("userName") String userName, String userId, int userAge) {
        FavUser favUser = new FavUser();
        favUser.setUserId(userId);
        favUser.setUserName(userName);
        favUser.setUserAge(userAge);
        return favUser;
    }

    @RequestMapping("getFavUserBody")
    public FavUser getFavUserBody(@RequestBody String body) {
        ObjectMapper mapper = new ObjectMapper();
        FavUser favUser = null;
        try {
            favUser = mapper.readValue(body, FavUser.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favUser;
    }
}
