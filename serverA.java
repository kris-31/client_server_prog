import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serverA {
    public static void main(String[] args) throws Exception {
        char[] byt;
        ServerSocket ss = new ServerSocket(7777);
        Socket sc = ss.accept();
        DataInputStream din = new DataInputStream(sc.getInputStream());
        DataOutputStream dout =new DataOutputStream(sc.getOutputStream());
        String str = (String) din.readUTF();

        //encrypt
        char[] ent = new char[str.length()];
        byt=str.toCharArray();
        for(int i=0 ; i<str.length() ; i++) {
            ent[i]=(char)(byt[i]+1);
        }

        dout.writeUTF(String.valueOf(ent));//send to main server
        dout.flush();
    }
}
