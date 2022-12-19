import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket sc=new Socket("127.0.0.1",6666);
        //to send a string
        DataOutputStream dout =new DataOutputStream(sc.getOutputStream());
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter a string:");
        String str = input.readLine();
        dout.writeUTF(str);
        dout.flush();   //sent to servermain

        //need to receive back a string from the server
        DataInputStream din =new DataInputStream(sc.getInputStream());
        String res= (String)din.readUTF();
        System.out.println(res);

        sc.close();
    }

}

