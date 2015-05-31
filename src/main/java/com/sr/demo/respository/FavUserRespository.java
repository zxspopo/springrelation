package com.sr.demo.respository;

import com.sr.demo.entity.FavUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2015/5/29.
 */
public interface FavUserRespository extends CrudRepository<FavUser,Long> {


    @Query("select COALESCE(max(t.id)+1,0) from FavUser t")
    Long findNextId();


}
