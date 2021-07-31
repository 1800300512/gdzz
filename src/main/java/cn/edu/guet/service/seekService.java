package cn.edu.guet.service;

import cn.edu.guet.bean.seek;

import java.util.List;

public interface seekService {
    void insertseek(seek seek);
    List<seek> selectseek(int curPage);
}
