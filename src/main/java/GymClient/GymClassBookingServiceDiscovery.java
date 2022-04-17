package GymClient;

import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

public class GymClassBookingServiceDiscovery {

		private static String host;
		private static int port;
		
		public static String getHost() {
			return host;
		}



		public static int getPort() {
			return port;
		}



		static class SampleListener implements ServiceListener{

			@Override
			public void serviceAdded(ServiceEvent event) {
				System.out.println("Service added: " + event.getInfo());
				
			}

			@Override
			public void serviceRemoved(ServiceEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void serviceResolved(ServiceEvent event) {
				host = event.getInfo().getHostAddresses()[0];
				port = event.getInfo().getPort();
				
			}
		}
	
}
