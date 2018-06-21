package com.briup.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BatchTest {

	private static Connection conn;
	private static Statement statement;
	private static PreparedStatement pst;
	static ResultSet rs;
	public static void main(String[] args) {
		conn = ConnectionFactory.getConnection();
		try {
			FileReader reader=new FileReader("F:/MyJava/ecjtu/src/radwtmp_test");
            BufferedReader bf=new BufferedReader(reader);
            String line = null;
			String[] strings = null;
			BIDR bIDR = null;
			Map<String, BIDR> map = new HashMap<String, BIDR>();
			List<BIDR> list = new ArrayList<BIDR>();
			while ((line = bf.readLine()) != null) {
				strings = line.split("[|]");
				if ("7".equals(strings[2])) {
					bIDR = new BIDR();
					bIDR.setLogin_name(strings[0]);
					bIDR.setNAS_ip(strings[1]);
					bIDR.setLogin_data(new Date(Long.parseLong(strings[3]) * 1000));
					bIDR.setLogin_ip(strings[4]);
					map.put(strings[4], bIDR);
				} else {
					bIDR = map.get(strings[4]);
					bIDR.setLogout_data(new Date(Long.parseLong(strings[3]) * 1000));
					bIDR.setTime_duretion((int) (map.get(strings[4]).getLogout_data().getTime()
							- map.get(strings[4]).getLogin_data().getTime()) / 1000);
					list.add(bIDR);
				}
			}
			SimpleDateFormat df=new SimpleDateFormat("dd"); 
			int j=0,count=0;
			boolean is = true;
			for (BIDR bidr : list) {	
				System.out.println(bidr.getLogin_data()+"          "+df.format(bidr.getLogin_data()));
				if(count!=Integer.valueOf(df.format(bidr.getLogin_data()))){
					if(pst!=null){
						pst.executeBatch();
						conn.commit();
						pst.close();
					}
					String sql="insert into t_detail_"+df.format(bidr.getLogin_data())+" values(?,?,?,?,?,?)";
					pst = conn.prepareStatement(sql);
					System.out.println("-------------------------");
				}
				count = Integer.valueOf(df.format(bidr.getLogin_data()));
				//createStatement和prepareStatement是在一个循环里面的话,游标一直在不停的打开，而且没有关闭
				pst.setString(1, bidr.getLogin_name());
				pst.setString(2, bidr.getLogin_ip());
				pst.setString(3, bidr.getNAS_ip());
				pst.setDate(4, bidr.getLogin_data());
				pst.setDate(5, bidr.getLogout_data());
				pst.setInt(6, bidr.getTime_duretion());
				pst.addBatch();
				//游标超出了设置的范围
				if(j%5000==0){
					pst.executeBatch();
					System.out.println("==================");
					pst.clearBatch();
				}
//				pst.close();
				j++;
			}
			if(pst!=null){
				pst.executeBatch();
				conn.commit();
			}
//			System.out.println(list.size());
//			String sql="insert into t_dedail_ values(?,?,?,?)";
//			pst = conn.prepareStatement(sql);
//			statement =  conn.createStatement();
//			for(int i=1;i<=31;i++){
//				pst.setInt(1, i);
//				pst.setString(2, "briup"+i);
//				pst.setString(3, "briup"+i);
//				pst.setInt(4, i);
//				pst.addBatch();
//				if(i%5000==0){
//					pst.executeBatch();
//					pst.clearBatch();
//				}
				
				/**
				 * 建一批表
				 * 
				 */
//				String sql = "delete t_detail_"+i;
//				String sql1 = "create table t_detail_"+i+"(login_name varchar2(30),"
//						+ "login_id varchar2(32),nas_id varchar2(32),login_date date,logout_date date,"
//						+ "time_duration number(10))";
//				rs = statement.executeQuery(sql);
//			}
//			pst.executeBatch();
			
			
//			statement =  conn.createStatement();
//			String sql = "insert into stu values(1,'tom','123',20)";
//			String sql2 = "update stu set age = 30 where id=1";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
