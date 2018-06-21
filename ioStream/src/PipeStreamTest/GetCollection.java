package PipeStreamTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetCollection {
	public Collection<Student> gather(String url) {
		// 绝对路径以“/”开头 "F:/MyJava/ecjtu/src/radwtmp_test"
		// 相对路径不以“/”开头从工程src开始 "src/radwtmp_test"
		try {
			FileReader fReader = new FileReader(url);
			BufferedReader bReader = new BufferedReader(fReader);
			String line = null;
			String[] strings = null;
			Student bIDR = null;
			List<Student> list = new ArrayList<Student>();
			while ((line = bReader.readLine()) != null) {
				strings = line.split("[:]");
				bIDR = new Student();
				bIDR.setName(strings[0]);
				bIDR.setAge(Integer.parseInt(strings[1]));
				bIDR.setSex(strings[2]);
				list.add(bIDR);
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
