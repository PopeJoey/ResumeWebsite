package com.resumeweb.service;

import com.resumeweb.entity.BaseInfo;

public interface base_infoDao {
    public void addBaseInfo(BaseInfo baseInfo);
    public void updateBaseInfo(BaseInfo baseInfo);
    public void deleteBaseInfo(BaseInfo baseInfo);
    public BaseInfo getBaseInfo(int user_id);
}
