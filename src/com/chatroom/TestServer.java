package com.chatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServer {
public static void main(String[] args) {
	Socket s=null;
	DataInputStream sIn=null;
	DataOutputStream sOut=null;
	try {
		//准备
		ServerSocket s1=new ServerSocket(8888);
		s=s1.accept();
		System.out.println("服务器准备就绪");
		//连接
		sOut.writeUTF("服务器反馈");
		String str=null;
		String wStr=null;
		while(true){
			System.out.println("服务器说：");
			Scanner input=new Scanner(System.in);
			wStr=input.next();
			sOut.writeUTF(wStr);
			str=sIn.readUTF();
			if(str!=null){
				System.out.println("客户端说："+str);
			}
			
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(Exception e1){
		e1.printStackTrace();
	}
	finally{
		try {
			sIn.close();
			sOut.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
