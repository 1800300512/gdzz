package cn.edu.guet.service.impl;

import cn.edu.guet.bean.seek;
import cn.edu.guet.mapper.seekMapper;
import cn.edu.guet.service.seekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class seekServiceImpl implements seekService {
    @Autowired
    private seekMapper seekMapper;
    @Override
    public void insertseek(seek seek) {
        seekMapper.insertseek(seek);
    }

    @Override
    public List<seek> selectseek(int curPage) {
        return seekMapper.selectseek(curPage);
    }

    @Override
    public List<seek> searchname(int curpage, String name) {
        return seekMapper.searchname(curpage,name);
    }
}
