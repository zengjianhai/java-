package com.briup.gather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.briup.bean.BIDR;

public class Gather {

	public static void main(String[] args) {
		List<BIDR> list = (List<BIDR>)new Gather().gather("src/radwtmp_test");
		for (BIDR bidr : list) {
			System.out.println(""+bidr);
		}
	}

	public Collection<BIDR> gather(String url) {
		// 绝对路径以“/”开头 "F:/MyJava/ecjtu/src/radwtmp_test"
		// 相对路径不以“/”开头从工程src开始 "src/radwtmp_test"
		try {
			FileReader fReader = new FileReader(url);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			String[] strings = null;
			BIDR bIDR = null;
			Map<String, BIDR> map = new HashMap<String, BIDR>();
			List<BIDR> list = new ArrayList<BIDR>();
			while ((line = bReader.readLine()) != null) {
				strings = line.split("[|]");
				if ("7".equals(strings[2])) {
					bIDR = new BIDR();
					bIDR.setLogin_name(strings[0]);
					bIDR.setNAS_ip(strings[1]);
					bIDR.setLogin_data(new Timestamp(Long.parseLong(strings[3]) * 1000));
					bIDR.setLogin_ip(strings[4]);
					map.put(strings[4], bIDR);
				} else {
					bIDR = map.get(strings[4]);
					bIDR.setLogout_data(new Timestamp(Long.parseLong(strings[3]) * 1000));
					bIDR.setTime_duretion((int) (map.get(strings[4]).getLogout_data().getTime()
							- map.get(strings[4]).getLogin_data().getTime()) / 1000);
					list.add(bIDR);
				}
			}
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
