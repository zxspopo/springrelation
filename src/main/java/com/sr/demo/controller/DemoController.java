package com.sr.demo.controller;

import com.sr.demo.entity.FavUser;

/**
 * Created by Administrator on 2015/5/24.
 */
@RestController
public class DemoController {

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
