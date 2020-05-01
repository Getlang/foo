package dao;

import entity.Userlikes;
import entity.UserlikesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserlikesMapper {
    int countByExample(UserlikesExample example);

    int deleteByExample(UserlikesExample record);

    int deleteByidcoll(@Param("userid") String userid, @Param("likes") String likes);
    
    int insert(Userlikes record);

    int insertSelective(Userlikes record);

    List<Userlikes> selectByExample(UserlikesExample example);
    
    List<Userlikes> selectById(@Param("userid") String userid);

    int updateByExampleSelective(@Param("record") Userlikes record, @Param("example") UserlikesExample example);

    int updateByExample(@Param("record") Userlikes record, @Param("example") UserlikesExample example);
}