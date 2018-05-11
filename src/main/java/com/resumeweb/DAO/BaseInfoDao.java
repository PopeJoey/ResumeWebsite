package com.resumeweb.DAO;

import com.resumeweb.entity.BaseInfo;

public interface BaseInfoDao {
    public int addBaseInfo(BaseInfo baseInfo);
    public void updateBaseInfo(BaseInfo baseInfo);
    public void deleteBaseInfo(BaseInfo baseInfo);
    public BaseInfo getBaseInfo(int user_id);
}
