package com.gem;

import java.io.*;
import java.util.ArrayList;

/*
* 提供序列化方法 listToFile(ArrayList<T> list, String filename)
* 提供反序列化方法 FileToList(String filename)
*/

public class SerializableUtil {

	//将对象集合写到文件中,序列化 (T泛型),用泛型统一模板
	public static <T> void listToFile(ArrayList<T> list, String filename) {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
			objectOutputStream.writeObject(list);//将集合写到文件,序列化
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//将文件内存读成对象集合,反序列化
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> FileToList(String filename) {
		ArrayList<T> list = null;
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(filename));
			list = (ArrayList<T>) inputStream.readObject();
			return list;//正常情况

		} catch (FileNotFoundException e) {
			//文件不存在
			list = new ArrayList<T>();
			File file = new File(filename);
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			} //创建文件

		} catch (IOException e) {
			list = new ArrayList<T>();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			list = new ArrayList<T>();
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

}
