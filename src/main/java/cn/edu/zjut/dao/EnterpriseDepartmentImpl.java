package cn.edu.zjut.dao;

import cn.edu.zjut.po.EnterpriseDepartment;
import cn.edu.zjut.po.EnterpriseDepartmentDisplay;
import cn.edu.zjut.po.EnterpriseUser;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class EnterpriseDepartmentImpl implements EnterpriseDepartmentMapper{
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<EnterpriseUser> getAllEnterpriseUser() {
        System.out.println("execute--getEnterpriseUser--dao");
        return sqlSession.getMapper(EnterpriseDepartmentMapper.class).getAllEnterpriseUser();
    }

    @Override
    public void addEnterpriseDepartment(EnterpriseDepartment enterpriseDepartment) {
        System.out.println("execute--addEnterpriseDepartment--dao");
        sqlSession.getMapper(EnterpriseDepartmentMapper.class).addEnterpriseDepartment(enterpriseDepartment);
    }

    @Override
    public List<EnterpriseDepartment> getAllEnterpriseDepartment() {
        System.out.println("execute--getAllEnterpriseDepartment--dao");
        return sqlSession.getMapper(EnterpriseDepartmentMapper.class).getAllEnterpriseDepartment();
    }

    @Override
    public EnterpriseDepartment getEnterpriseDepartmentById(int id) {// 获取id公司的部门
        return sqlSession.getMapper(EnterpriseDepartmentMapper.class).getEnterpriseDepartmentById(id);
    }

    @Override
    public List<EnterpriseDepartmentDisplay> getAllEnterpriseDepartmentDisplay(int id)// 获取id公司的部门，上级部门按字符串显示
    {
        return sqlSession.getMapper(EnterpriseDepartmentMapper.class).getAllEnterpriseDepartmentDisplay(id);
    }

    @Override
    public void deleteDepartment(int id)// 根据id删除部门
    {
        sqlSession.getMapper(EnterpriseDepartmentMapper.class).deleteDepartment(id);
    }

    @Override
    public List<EnterpriseDepartment> getSubDepartment(int id)// 查询所有下属部门
    {
        return sqlSession.getMapper(EnterpriseDepartmentMapper.class).getSubDepartment(id);
    }

    @Override
    public void updateUserDepartment(int id, int departmentId)// 更新用户部门
    {
        sqlSession.getMapper(EnterpriseDepartmentMapper.class).updateUserDepartment(id, departmentId);
    }


    @Override
    public void deleteConsumer(int id)// 删除用户
    {
        sqlSession.getMapper(EnterpriseDepartmentMapper.class).deleteConsumer(id);
    }


    @Override
    public List<EnterpriseDepartment> getEnterpriseDepartmentByEnterpriseId(int id) {
        System.out.println("execute--getEnterpriseDepartmentById--dao");
        return sqlSession.getMapper(EnterpriseDepartmentMapper.class).getEnterpriseDepartmentByEnterpriseId(id);
    }
}
