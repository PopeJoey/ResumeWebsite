package com.resumeweb.DAO;

import com.resumeweb.entity.Pattern;

import java.util.List;

public interface PatternDao {
    /**
     * 获取模板列表
     * @return List<Pattern>
     */
    public List<Pattern> getPatternList();
}
