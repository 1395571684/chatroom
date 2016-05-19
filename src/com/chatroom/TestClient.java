package com.chatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
public static void main(String[] args)  {
	DataInputStream cIn=null;
	DataOutputStream cOut=null;
	Socket s=null;
	System.out.println("hi");
	try {
		//׼��
		s=new Socket("localhost", 8888);
		cIn=new DataInputStream(s.getInputStream());
	    cOut=new DataOutputStream(s.getOutputStream());
		//����
	    cOut.writeUTF("�ͻ��������������");
	    String rStr=null;
	    String wStr=null;
	    //����
	    while(true){
	    	System.out.println("�ͻ���˵��");
	    	Scanner input=new Scanner(System.in);
	    	wStr=input.next();
	    	cOut.writeUTF(wStr);
	    	rStr=cIn.readUTF();
	    	if(rStr!=null){
	    		System.out.println("������˵��"+rStr);
	    	}
	    }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch(Exception e1){
		e1.printStackTrace();
	}
	finally{
		try {
			cIn.close();
			cOut.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
}
