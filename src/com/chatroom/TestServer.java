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
		//׼��
		ServerSocket s1=new ServerSocket(8888);
		s=s1.accept();
		System.out.println("������׼������");
		//����
		sOut.writeUTF("����������");
		String str=null;
		String wStr=null;
		while(true){
			System.out.println("������˵��");
			Scanner input=new Scanner(System.in);
			wStr=input.next();
			sOut.writeUTF(wStr);
			str=sIn.readUTF();
			if(str!=null){
				System.out.println("�ͻ���˵��"+str);
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
