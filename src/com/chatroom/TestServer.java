package com.chatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	static DataInputStream sIn = null;
	static DataOutputStream sOut = null;

	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket s1=null;
		try {
			TestServer server = new TestServer();
			while (true) {
				s1 = new ServerSocket(8888);
				socket = s1.accept();
				server.new client(socket).start();

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				sIn.close();
				sOut.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 使用多线程实现多个客户端与服务器交流
	class client extends Thread {
		Socket s = null;
		String str = null;
		String wStr = null;

		client(Socket s) {
			super();
			this.s = s;
		}

		@Override
		public void run() {

			try {

				// 连接
				sIn = new DataInputStream(s.getInputStream());
				sOut = new DataOutputStream(s.getOutputStream());
				str = sIn.readUTF();
				if (str != null) {
					wStr = s.getPort() + "说" + str;
					System.out.println(wStr);
					sOut.writeUTF(wStr);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}