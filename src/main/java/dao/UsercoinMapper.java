package dao;

import entity.Usercoin;
import entity.UsercoinExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsercoinMapper {
    int countByExample(UsercoinExample example);

    int deleteByExample(UsercoinExample record);

    int deleteByidcoll(@Param("userid") String userid, @Param("coin") String coin);
    
    int insert(Usercoin record);

    int insertSelective(Usercoin record);

    List<Usercoin> selectByExample(UsercoinExample example);
    
    List<Usercoin> selectById(@Param("userid") String userid);

    int updateByExampleSelective(@Param("record") Usercoin record, @Param("example") UsercoinExample example);

    int updateByExample(@Param("record") Usercoin record, @Param("example") UsercoinExample example);
}