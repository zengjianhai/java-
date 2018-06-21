package briup.file;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {

	public static void main(String[] args) {
		File file;
		file = new File("F:\\file" + File.separator + "test.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		RandomAccessFile accessFile = null;
		try {
			accessFile = new RandomAccessFile(file, "rw");
			RandomAccessFile accessFile2 = new RandomAccessFile(file, "r");
			String name = null;
			int age = 0;
			name = "zengjian";
			age = 98;
			try {
				// 将名字写入文件
				accessFile.writeBytes(name);
				// will age written to the file
				accessFile.writeInt(age);
				name = "tianxia ";
				age = 97;
				accessFile.writeBytes(name);
				accessFile.writeInt(age);
				name = "zhangsan";
				age = 35;
				accessFile.writeBytes(name);
				accessFile.writeInt(age);


				byte[] bs = new byte[8];
				//在文件中跳过给定数量的字节,相对而言
				accessFile2.skipBytes(12);
				try {
					for (int i = 0; i < bs.length; i++) {
						bs[i] = accessFile2.readByte();
					}
					//将byte数组转换成string
					name = new String(bs);
					age = accessFile2.readInt();
					System.out.println("名字：" + name + "年龄：" + age);
				} catch (EOFException e) {
				}
				
			    bs = new byte[8];
			    accessFile2.seek(0);
			    try {
					for (int i = 0; i < bs.length; i++) {
						bs[i] = accessFile2.readByte();
					}
					//将byte数组转换成string
					name = new String(bs);
					age = accessFile2.readInt();
					System.out.println("名字：" + name + "年龄：" + age);
				} catch (EOFException e) {
				}
				
				bs = new byte[8];
				accessFile2.skipBytes(12);
				try {
					for (int i = 0; i < bs.length; i++) {
						bs[i] = accessFile2.readByte();
					}
					//将byte数组转换成string
					name = new String(bs);
					age = accessFile2.readInt();
					System.out.println("名字：" + name + "年龄：" + age);
				} catch (EOFException e) {
				}
				
				accessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
