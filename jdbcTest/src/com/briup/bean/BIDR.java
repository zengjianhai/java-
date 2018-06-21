package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;
//ʵ������ӿڱ�����������ͨ��������
public class BIDR implements Serializable{

	private  String login_name;
	private String login_ip;
	private String NAS_IP;
	private Timestamp login_date;
	private Timestamp logout_date;
	private int time_duration;
	@Override
	public String toString() {
		return "BIDR [login_name=" + login_name + ", login_ip=" + login_ip + ", NAS_IP=" + NAS_IP + ", login_date="
				+ login_date + ", logout_date=" + logout_date + ", time_duration=" + time_duration + "]";
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getNAS_IP() {
		return NAS_IP;
	}
	public void setNAS_IP(String nAS_IP) {
		NAS_IP = nAS_IP;
	}
	public Timestamp getLogin_date() {
		return login_date;
	}
	public void setLogin_date(Timestamp login_date) {
		this.login_date = login_date;
	}
	public Timestamp getLogout_date() {
		return logout_date;
	}
	public void setLogout_date(Timestamp logout_date) {
		this.logout_date = logout_date;
	}
	public int getTime_duration() {
		return time_duration;
	}
	public void setTime_duration(int time_duration) {
		this.time_duration = time_duration;
	}
	public BIDR() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BIDR(String login_name, String login_ip, String nAS_IP, Timestamp login_date, Timestamp logout_date,
			int time_duration) {
		super();
		this.login_name = login_name;
		this.login_ip = login_ip;
		NAS_IP = nAS_IP;
		this.login_date = login_date;
		this.logout_date = logout_date;
		this.time_duration = time_duration;
	}
	
}
