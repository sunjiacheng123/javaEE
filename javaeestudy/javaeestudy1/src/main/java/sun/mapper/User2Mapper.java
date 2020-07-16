package sun.mapper;

import org.apache.ibatis.annotations.Mapper;
import sun.model.User2;

import java.util.List;
@Mapper
public interface User2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User2 record);

    User2 selectByPrimaryKey(Integer id);

    List<User2> selectAll();

    int updateByPrimaryKey(User2 record);
}