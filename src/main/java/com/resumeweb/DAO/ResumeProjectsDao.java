package com.resumeweb.DAO;

import javax.sql.DataSource;
import java.util.List;

public interface ResumeProjectsDao {
    /**
     * 增加一条简历-项目关系
     * @param resume_id 简历id
     * @param project_info_id 项目id
     */
    public void addResume_projects(int resume_id,int project_info_id);

    /**
     * 删除一条简历-项目关系
     * @param resume_id 简历id
     * @param project_info_id 项目id
     */
    public void deleteResume_projects(int resume_id,int project_info_id);

    /**
     * 获取简历对应的项目列表
     * @param resume_id 简历id
     * @return 项目id列表
     */
    public List<Integer> getProject_info_ids(int resume_id);
}
