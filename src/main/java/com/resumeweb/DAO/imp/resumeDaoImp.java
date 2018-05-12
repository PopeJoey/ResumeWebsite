package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.*;
import com.resumeweb.entity.EduInfo;
import com.resumeweb.entity.ProjectInfo;
import com.resumeweb.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class resumeDaoImp implements ResumeDao {
    private JdbcTemplate jdbcTemplateObject;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public int addResume(final Resume resume) {
        final String sql="INSERT INTO resume(resume_name, user_id, pattern_id, base_info_id) VALUES (?,?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
//        jdbcTemplateObject.update(sql,resume.getResumeName(),resume.getUserId()
//        ,resume.getPatternId(),resume.getBaseInfo().getBaseInfoId(),keyHolder);
        jdbcTemplateObject.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,resume.getResumeName());
                ps.setInt(2,resume.getUserId());
                ps.setInt(3,resume.getPatternId());
                ps.setInt(4,resume.getBaseInfo().getBaseInfoId());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void deleteResume(Resume resume) {

    }

    @Override
    public void updateResume(Resume resume) {
        String sql="UPDATE resume SET resume_id=?,user_id=?,pattern_id=?,base_info_id=?";
        jdbcTemplateObject.update(sql,resume.getResumeName(),resume.getUserId()
        ,resume.getPatternId(),resume.getBaseInfo().getBaseInfoId());
    }

    @Override
    public Resume getResume(final int resume_id) {

        String sql="SELECT * FROM resume WHERE resume_id=?";
        Resume resume=  jdbcTemplateObject.queryForObject(sql, new RowMapper<Resume>() {

            @Override
            public Resume mapRow(ResultSet resultSet, int i) throws SQLException {
                Resume resume=new Resume();
                resume.setResumeId(resume_id);
                resume.setResumeName(resultSet.getString(2));
                resume.setUserId(resultSet.getInt(3));
                resume.setPatternId(resultSet.getInt(4));
                //resume.getBaseInfo().setBaseInfoId(resultSet.getInt(5));
                return resume;
            }
        },resume_id);
//        WebApplicationContext context =
//                ContextLoader.getCurrentWebApplicationContext();
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        EduInfoDao eduInfoDao = (EduInfoDao)context.getBean("eduInfoDao");
        BaseInfoDao baseInfoDao=(BaseInfoDao)context.getBean("baseInfoDao");
        resume.setBaseInfo(baseInfoDao.getBaseInfo(resume.getUserId()));
        ProjectInfoDao projectInfoDao=(ProjectInfoDao) context.getBean("projectInfoDao");
        ResumeEdusDao resumeEdusDao=(ResumeEdusDao) context.getBean("resumeEdusDao");
        ResumeProjectsDao resumeProjectsDao=(ResumeProjectsDao) context.getBean("resumeProjectsDao");
        ArrayList<EduInfo> educations=new ArrayList<EduInfo>();
        ArrayList<ProjectInfo> projects=new ArrayList<ProjectInfo>();
        //resume.setEducations(new ResumeEdusDaoImp().getEduInfoIds(resume_id));
        List<Integer> edu_ids=resumeEdusDao.getEduInfoIds(resume_id);
        for (Integer i :edu_ids){
            educations.add(eduInfoDao.getEduInfo(i));
        }
        List<Integer> pro_ids=resumeProjectsDao.getProject_info_ids(resume_id);
        for (Integer i:pro_ids){
            projects.add(projectInfoDao.getProjectInfo(i));
        }
        resume.setEducations(educations);
        resume.setProjects(projects);
        return resume;

    }

    @Override
    public ArrayList<Resume> getAllResumes(int user_id) {
        ArrayList<Resume> resumes=new ArrayList<Resume>();
        String sql="SELECT resume_id FROM resume WHERE user_id=?";
        List<Integer> resume_ids=jdbcTemplateObject.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt(1);
            }
        },user_id);
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        ResumeDao resumeDao=(ResumeDao) context.getBean("resumeDao");
        for (Integer i: resume_ids){
            resumes.add(resumeDao.getResume(i));
        }
        return resumes;
    }

//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
////        WebApplicationContext ctx =
////                ContextLoader.getCurrentWebApplicationContext();
//        ResumeDao dao=(ResumeDao) context.getBean("resumeDao");
//        Resume resume= dao.getResume(19);
//        System.out.println(resume.getUserId());
//
//
//
//    }
}
