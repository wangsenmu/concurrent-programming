package com.wsm.concurrent.io.bio.threadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangsm on 2018/6/28.
 */
public class TimeServer {

    public static void main(String[] args) {

        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The time server is start in port :" + port);
            Socket socket = null;

            TimeServerHandlerExecutePool singleExcuter = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = serverSocket.accept();
                singleExcuter.execute(new TimeSeverHandler(socket));
            }

        } catch (Exception e) {

        } finally {
            if (serverSocket != null) {
                System.out.println("The time server close");
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                serverSocket = null;
            }
        }

    }
}
