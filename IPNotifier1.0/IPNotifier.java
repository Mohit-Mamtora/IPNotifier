package mohit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

public class IPNotifier implements Runnable{
	
	private OnIpchangeListioner OnIpchangeListioner;
	private InetAddress inetAddress;
	private volatile boolean SHUTDOWN;
	private int RefreshRate=5000;
	
	public IPNotifier(InetAddress inetAddress) {
		if (inetAddress==null) {
			throw new IllegalArgumentException("Inetadrees should not null");
		}
		this.inetAddress=inetAddress;
	}
	
	public IPNotifier(InetAddress inetAddress,int RefreshRate) {
		if (RefreshRate<0) {
			throw new IllegalArgumentException("Refresh Rate should be more than 0 ");
		}
		if (inetAddress==null) {
			throw new IllegalArgumentException("Inetadrees should not null");
		}
		this.inetAddress=inetAddress;
		this.RefreshRate=RefreshRate;
	}

	@Override
	public void run() {
		
		if (OnIpchangeListioner==null){return;}
		
		this.SHUTDOWN=false;
		
		while(!SHUTDOWN){
			
			try {
				InetAddress i=InetAddress.getLocalHost();
				if (!Objects.equals(inetAddress,i)) {
					OnIpchangeListioner.OnChangeTo(i);
					this.inetAddress=i;
				}
				
				Thread.sleep(RefreshRate);
				
			} catch (UnknownHostException | InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
	
	public void setOnIpchangeListioner(OnIpchangeListioner OnIpchangeListioner){
		this.OnIpchangeListioner=OnIpchangeListioner;
	}
	
	public void stop(){
		this.SHUTDOWN=true;
	}
}
