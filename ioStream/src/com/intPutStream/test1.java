package com.intPutStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class test1 {

	public static void main(String[] args) {
		File file = new File("F:"+File.separator+"file"+File.separator
				+"inPutStreamTest"+File.separator+"test1.txt");
		InputStream ips = null;
		try {
			if(file.exists()){
				ips = new FileInputStream(file);
				//�õ����ļ��ĳ���
				byte[] bs = new byte[(int)file.length()];
				//���������������е������ֽڳ���,һ�����������ֽ�
				int i = ips.read(bs);
				//�����ݶ���byte������
				ips.read(bs);
				//��byte��ת��String����
				String string = new String(bs,0,i);
				System.out.println(string);
				System.out.println("���������ݵĳ��ȣ�"+i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
