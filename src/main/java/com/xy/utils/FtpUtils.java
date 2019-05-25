package com.xy.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
public class FtpUtils {

	public static void main(String[] args) throws FileNotFoundException {
	
		String host="192.168.26.22";
		Integer port=21;
		String username="ftpuser";
		String password="ftpuser";
		String path="/home/ftpuser/images";
		String remote="2.png";
		InputStream local=new FileInputStream("D:/1.png");
		
		uploadFile(host, port, username, password, path, remote, local);
		
	}
	public static void uploadFile(String host, Integer port, String username, 
			String password, String path,
			String remote, InputStream local) {
		try{
			//创建client对象
			FTPClient client=new FTPClient();
			//连接vsftpd服务器
			client.connect(host, port);
			//登录vsftpd服务器
			client.login(username, password);
			//设置上传的文件的保存目录
			client.changeWorkingDirectory(path);
			//设置上传的文件的类型
			client.setFileType(FTP.BINARY_FILE_TYPE);
			//上传文件
			client.storeFile(remote, local);
			//退出ftp客户端
			client.logout();
			//断开连接
			client.disconnect();
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
