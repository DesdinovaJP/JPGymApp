package GymClient;

import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

public class ProgressAssessmentServiceDiscovery 
{
	
	static class SampleListener implements ServiceListener
	{

		@Override
		public void serviceAdded(ServiceEvent event) 
		{
			System.out.println("Progress assessment added: " + event.getInfo());
			
		}

		@Override
		public void serviceRemoved(ServiceEvent event) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void serviceResolved(ServiceEvent event) 
		{
			try {
				GymClient.service2(event.getInfo().getHostAddresses()[0], event.getInfo().getPort());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
