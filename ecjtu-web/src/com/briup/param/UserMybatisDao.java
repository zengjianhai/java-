package com.briup.param;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class UserMybatisDao {
	public void save(User user) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		mapper.saveUser(user);
		sqlSession.commit();
	}
	public boolean select(String name) {
		boolean flag = true;
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		List<User> list = mapper.findUserALlByName(name);
		for (User user : list) {
			if(!user.getName().equals("")){
				flag = false;return flag;
			}else{
				flag = true;return flag;
			}
		}
		sqlSession.commit();
		return flag;
	}
}
