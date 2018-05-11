package com.resumeweb.DAO;

import com.resumeweb.entity.EduInfo;

public interface EduInfoDao {
    public int addEduInfo(EduInfo eduInfo);
    public void updateEduInfo(EduInfo eduInfo);
    public void deleteEduInfo(EduInfo eduInfo);
    public EduInfo getEduInfo(int edu_info_id);
}
