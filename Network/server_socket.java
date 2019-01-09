import java.io.*;
import java.net.*;
import java.util.Arrays;

public class server_socket {
    public static void main(String[] args) {
        try{
            DatagramSocket s = new DatagramSocket(9874);
            byte[] outdata = new byte[1024];
            byte[] indata = new byte[1024];
            DatagramPacket dpkrcv = new DatagramPacket(indata, indata.length);
            s.receive(dpkrcv);
            String rcv = new String(dpkrcv.getData());
            String[] prcs = rcv.split(" ");
	    //System.out.println(prcs.length);
            int[] a = new int[3];
            for(int i=0; i< prcs.length; i++)
		System.out.println(prcs[i]);
	    for (int i = 0; i < prcs.length; i++)
            {
                a[i] = Integer.parseInt(prcs[i].trim());
                //System.out.println(a[i]+20);
            }
            Arrays.sort(a);
            String ans = a[0] + " " + a[1] + " " + a[2];
            InetAddress ipa = dpkrcv.getAddress();
            int port = dpkrcv.getPort();
            outdata = ans.getBytes();
            DatagramPacket dpk = new DatagramPacket(outdata, outdata.length, ipa, port);
            s.send(dpk);
            s.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //}
    }
}
