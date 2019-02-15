import java.util.*;
import java.io.*;

class MANRECT{
	static void q(long a, long b){
		System.out.println("Q " + a + " " + b);
	}
	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1000000000;
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
			q(0,0);
			long d1 = Long.parseLong(br.readLine());
			q(x, 0);
			long d2 = Long.parseLong(br.readLine());
			q(x, x);
			long d3 = Long.parseLong(br.readLine());
			q(0, x);
			long d4 = Long.parseLong(br.readLine());

			long m1=0, m3=0;
			if(d1+d4 >= x)
				m1 = (long)Math.ceil((d1+d4-x)/2.0);
			//if(d1+d2 >= x)
				//m2 = (d1+d2-x)/2;
			if(d2+d3 >= x)
				m3 = (long)Math.ceil((d2+d3-x)/2.0);
			
			q(m1, d1-m1);
			long x1 = Integer.parseInt(br.readLine());
			x1 += m1;
			long y1 = d1-x1;
			
			q(x-m3, x-d3+m3);
			long p = Integer.parseInt(br.readLine());
			long x2 = x-m3-p;
			long y2 = x-d3+x2;
			System.out.println("A "+x1+" "+y1+" "+x2+" "+y2);
			if(Integer.parseInt(br.readLine()) == 1)
				continue;
			else
				break;
		}
	}
}
