////this server receives a string and send the string to serverA .
///serverA encrypts the string and send back to main server
//main server send the encrypted string to client

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class mainserver {
    public static void main(String[] args) throws Exception {
        char[] byt;
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("Server Started");
        Socket sc=ss.accept();
        DataInputStream din =new DataInputStream(sc.getInputStream());
        DataOutputStream dout =new DataOutputStream(sc.getOutputStream());
        String str= (String)din.readUTF();
        System.out.println("message from client " + str);

 ////send to another serverA
        Socket saa=new Socket("127.0.0.1",7777);
        DataOutputStream dout2 =new DataOutputStream(saa.getOutputStream());
        dout2.writeUTF(str);
        dout2.flush();

//////get encrypted string from serverA
        DataInputStream din2 =new DataInputStream(saa.getInputStream());
        String eng= (String)din2.readUTF();

 /////send encrypted string to client
        dout.writeUTF(eng);//sending to client
        dout.flush();

        sc.close();
        ss.close();
    }

}

