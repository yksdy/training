import java.net.InetAddress;

public class InetAddressDemo {
	public static void main(String[] arg) throws Exception {
		InetAddress net1 = InetAddress.getByName("172.20.114.242");//http:;//www.baidu.com");
		InetAddress net2 = InetAddress.getLocalHost();
		System.out.println(" getByName = "+net1);
		System.out.println(" getByLocalHost = "+net2.getHostAddress()+ "getHostName = "+net2.getHostName());
		System.out.println(" isReachable1 = "+net1.isReachable(2000));
		System.out.println(" isReachable2 = "+net2.isReachable(2000));
	}
}
