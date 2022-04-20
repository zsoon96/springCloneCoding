package com.sparta.springclonecoding.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class FavoriteId  implements Serializable {
    private Long postid;
    private Long userid;

    @Override
    public boolean equals(Object object){
        if(this==object) return true;
        if(object == null || getClass()!= object.getClass()) return false;
        FavoriteId favoriteId = (FavoriteId) object;
        return Objects.equals(postid,favoriteId.postid)&& Objects.equals(userid,favoriteId.userid);
    }

    @Override
    public int hashCode(){
        return Objects.hash(postid,userid);
    }


}
