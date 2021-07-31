package cn.edu.guet.mapper;

import cn.edu.guet.bean.seek;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface seekMapper {
    void insertseek(seek seek);
    List<seek> selectseek(int curPage);
}
