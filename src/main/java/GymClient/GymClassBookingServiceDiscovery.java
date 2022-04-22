package GymClient;

import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

public class GymClassBookingServiceDiscovery 
{

		static class SampleListener implements ServiceListener
		{

			@Override
			public void serviceAdded(ServiceEvent event) 
			{
				System.out.println("Gym class booking added: " + event.getInfo());
				
			}

			@Override
			public void serviceRemoved(ServiceEvent event) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void serviceResolved(ServiceEvent event) 
			{
				GymClient.service1(event.getInfo().getHostAddresses()[0], event.getInfo().getPort());
				
			}
		}
	
}
