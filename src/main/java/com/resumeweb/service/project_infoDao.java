package com.resumeweb.service;

import com.resumeweb.entity.ProjectInfo;

public interface project_infoDao {
    void addProject_info(ProjectInfo projectInfo);
    void deleteProject_info(ProjectInfo projectInfo);
    void updateProject_info(ProjectInfo projectInfo);
    ProjectInfo getProjectInfo(int project_info_id);
}
