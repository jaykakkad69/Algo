import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client_socket {
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket();
            byte[] outdata = new byte[1024];
            byte[] indata = new byte[1024];
            Scanner sc = new Scanner(System.in);
            int i = 0;
            int a[] = new int[3];
            while (i < 3) {
                a[i++] = sc.nextInt();
            }
            String str = a[0] + " " + a[1] + " " + a[2];
            DatagramPacket dpk = new DatagramPacket(str.getBytes(), str.getBytes().length,InetAddress.getByName("localhost"), 9874);
            s.send(dpk);
            DatagramPacket dpkrcv = new DatagramPacket(indata, indata.length);
            s.receive(dpkrcv);
            String str2 = new String(dpkrcv.getData());
            System.out.println(str2);
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
