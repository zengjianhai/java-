package briup.internet;

import java.io.Serializable;
import java.sql.Timestamp;

public class BIDR implements Serializable {
	private String login_ip;
	private String NAS_ip;
	private String login_name;
	private Timestamp login_data;
	private Timestamp logout_data;
	private int time_duretion;

	public BIDR() {
	}

	public BIDR(String login_ip, String NAS_ip, String login_name, Timestamp login_data, Timestamp logout_data,
			int time_duretion) {
		this.login_ip = login_ip;
		this.NAS_ip = NAS_ip;
		this.login_name = login_name;
		this.login_data = login_data;
		this.logout_data = logout_data;
		this.time_duretion = time_duretion;

	}
	

	public String getLogin_ip() {
		return login_ip;
	}

	@Override
	public String toString() {
		return "BIDR [login_ip=" + login_ip + ", NAS_ip=" + NAS_ip + ", login_name=" + login_name + ", login_data="
				+ login_data + ", logout_data=" + logout_data + ", time_duretion=" + time_duretion + "]";
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public String getNAS_ip() {
		return NAS_ip;
	}

	public void setNAS_ip(String nAS_ip) {
		NAS_ip = nAS_ip;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public Timestamp getLogin_data() {
		return login_data;
	}

	public void setLogin_data(Timestamp login_data) {
		this.login_data = login_data;
	}

	public Timestamp getLogout_data() {
		return logout_data;
	}

	public void setLogout_data(Timestamp logout_data) {
		this.logout_data = logout_data;
	}

	public int getTime_duretion() {
		return time_duretion;
	}

	public void setTime_duretion(int time_duretion) {
		this.time_duretion = time_duretion;
	}
}
