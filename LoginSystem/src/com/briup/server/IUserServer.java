package com.briup.server;

import com.briup.bean.UserBean;
/**
 * 业务逻辑层接口
 * @author xunfeng
 * 
 * */
public interface IUserServer {
	//处理登录逻辑
	String login(String name, String passwd);
	//处理注册逻辑
	String register(UserBean user);
}
