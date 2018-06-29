package com.wsm.concurrent.io.bio.threadpool;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by wangsm on 2018/6/28.
 */
public class TimeSeverHandler implements Runnable {

    private Socket socket;

    public TimeSeverHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true);

            String currentTime = null;
            String body = null;
            while (true) {
                body = in.readLine();
                if (body == null)
                    break;
                System.out.println("The time Server receive order :" + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "Bad order";
                out.println(currentTime);
            }
        } catch (Exception e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
                out = null;
            }
            if (this.socket != null) {

                try {
                    this.socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.socket = null;
            }

        }


    }
}
