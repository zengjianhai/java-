package com.briup.server;

import com.briup.bean.UserBean;
/**
 * ҵ���߼���ӿ�
 * @author xunfeng
 * 
 * */
public interface IUserServer {
	//�����¼�߼�
	String login(String name, String passwd);
	//����ע���߼�
	String register(UserBean user);
}
