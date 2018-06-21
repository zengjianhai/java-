package com.briup.server;

import com.briup.bean.UserBean;
import com.briup.dao.IUserDao;
import com.briup.dao.UserDaoImpl;

/**
 * �û�ҵ���߼�ʵ����
 * 
 * @author xunfeng
 */
public class UserServerImpl implements IUserServer {
	private IUserDao dao;
private UserBean user;
	//��¼��ҵ���߼�����
	@Override
	public String login(String name,String passwd) {
		String result = null;
		dao = new UserDaoImpl();
	    user = dao.findUserByName(name);
		if (user == null) {
			result = "�û�������";
		} else {
			if(user.getPasswd().equals(passwd)){
				result = "��¼�ɹ�";
			}
		}
		return result;
	}

	@Override
	public String register(UserBean newUser) {
		String result = null;
		dao = new UserDaoImpl();
		user = dao.findUserByName(newUser.getName());
		if(user == null){
			dao.saveUser(newUser);
			result = "ע��ɹ�";
		}else{
			result = "�û�����";
		}
		return result;
	}

}
