package com.resumeweb.DAO;

import javax.sql.DataSource;
import java.util.List;

public interface ResumeEdusDao{
    /**
     * 增加一条简历-教育信息关系
     * @param resume_id 简历id
     * @param edu_info_id 教育信息id
     */
    public int addResumeEdus(int resume_id,int edu_info_id);

    /**
     * 删除一条简历-教育信息关系
     * @param resume_id 简历id
     * @param edu_info_id 教育信息id
     */
    public void deleteResumeEdus(int resume_id,int edu_info_id);

    /**
     * 获取简历对应的项目列表
     * @param resume_id 简历id
     * @return 教育信息id列表
     */
    public List<Integer> getEduInfoIds(int resume_id);
}
