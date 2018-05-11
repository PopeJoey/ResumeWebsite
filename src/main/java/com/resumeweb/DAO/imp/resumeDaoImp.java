package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.ResumeDao;
import com.resumeweb.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository
public class resumeDaoImp implements ResumeDao {
    private JdbcTemplate jdbcTemplateObject;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public int addResume(Resume resume) {
        String sql="INSERT INTO resume(resume_name, user_id, pattern_id, base_info_id) VALUES (?,?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplateObject.update(sql,resume.getResumeName(),resume.getUserId()
        ,resume.getPatternId(),resume.getBaseInfo().getBaseInfoId(),keyHolder);
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
    public void getResume(Resume resume) {

    }
}
