package com.resumeweb.DAO;

import com.resumeweb.entity.ProjectInfo;

public interface ProjectInfoDao {
    int addProjectInfo(ProjectInfo projectInfo);
    void deleteProjectInfo(ProjectInfo projectInfo);
    void updateProjectInfo(ProjectInfo projectInfo);
    ProjectInfo getProjectInfo(int project_info_id);
}
