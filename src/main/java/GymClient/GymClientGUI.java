package GymClient;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.jmdns.JmDNS;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChangeTraining.ChangeTrainingGrpc;
import ChangeTraining.MuscleGroup;
import ChangeTraining.RecordedWorkout;
import ChangeTraining.TrainingRequest;
import ChangeTraining.TrainingResponse;
import ChangeTraining.WorkoutDone;
import GymClassBooking.GymClassBookingGrpc;
import ProgressAssessment.AssessmentDetail;
import ProgressAssessment.ProgressAssessmentGrpc;
import ProgressAssessment.ResponseMessage;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GymClientGUI implements ActionListener
{

	
	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException 
	{
		
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress. getLocalHost());
			// Add a service listener
			jmdns.addServiceListener("_gcbs._tcp.local.", new GymClassBookingServiceDiscovery.SampleListener());
			jmdns.addServiceListener("_pas._tcp.local.", new ProgressAssessmentServiceDiscovery.SampleListener());
			jmdns.addServiceListener("_cts._tcp.local.", new ChangeTrainingServiceDiscovery.SampleListener());
			
					
		GymClientGUI gui = new GymClientGUI();
		gui.build();
		
	}
	
	private JPanel getService1JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JButton button = new JButton("Gym Class Booking");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService2JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JButton button = new JButton("Progress Assessment");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getService3JPanel() {

		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JButton button = new JButton("Change Training");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private void build() { 

		JFrame frame = new JFrame("JP Gym App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add( getService1JPanel() );
		panel.add( getService2JPanel() );
		panel.add( getService3JPanel() );

		// Set size for the frame
		frame.setSize(100, 100);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  

		if (label.equals("Gym Class Booking")) {
			System.out.println("Let's see which classes are available");

			//ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
			GymClassBookingGrpc.GymClassBookingBlockingStub blockingStub = GymClassBookingGrpc.newBlockingStub(channel);

			//Add user method
			//preparing message to send
			GymClassBooking.UserDetails request = GymClassBooking.UserDetails.newBuilder().setUserName("jp").setPassword("123").setGym("CHQ").build();

			//retrieving reply from service
			GymClassBooking.ResponseMessage response = blockingStub.addUser(request);
		
			System.out.println(response.getConfirmed());
			
			
			//BookUser method
			//preparing message to send
			GymClassBooking.BookingDetails requestBook = GymClassBooking.BookingDetails.newBuilder().setTime("morning").setClass_("spinning").build();//use Class_ reserved word

			//retrieving reply from service
			GymClassBooking.ResponseMessage responseBook = blockingStub.bookUser(requestBook);
		
			System.out.println(responseBook.getConfirmed());
			
			channel.shutdownNow();

		
		}else if (label.equals("Progress Assessment")) {
			System.out.println("Let'analyse the results ...");

			//ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			ProgressAssessmentGrpc.ProgressAssessmentStub stub = ProgressAssessmentGrpc.newStub(channel);

			//Add user detail 
			StreamObserver<ResponseMessage> responseObserver = new StreamObserver<ResponseMessage>() 
			{

				@Override
				public void onNext(ResponseMessage value) 
				{
					System.out.println("Server says: " + value.getConfirmed());
					
				}

				@Override
				public void onError(Throwable t) 
				{
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() 
				{
					// TODO Auto-generated method stub
					
				}
			};
			
				// gRPC library returns a StreamObserver to us: requestObserver
				// we use this to send out outgoing messages
				StreamObserver<AssessmentDetail> requestObserver = stub.addUserDetail(responseObserver);
				
				requestObserver.onNext(AssessmentDetail.newBuilder().setKey("Height").setValue("1,7m").build());
				requestObserver.onNext(AssessmentDetail.newBuilder().setKey("weight").setValue("89kg").build());
				requestObserver.onNext(AssessmentDetail.newBuilder().setKey("Username").setValue("AndrewGenius").build());
			
				System.out.println("User details added.");
				
				
				requestObserver.onCompleted();
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
			// Clean up : Shutdown the channel
			try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//bookNextAssessment
			ManagedChannel channel2 = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
			ProgressAssessmentGrpc.ProgressAssessmentBlockingStub blockingStub = ProgressAssessmentGrpc.newBlockingStub(channel2);

			//preparing message to send
			ProgressAssessment.BookRequest request = ProgressAssessment.BookRequest.newBuilder().setUsername("Finn").build();

			//retrieving reply from service
			ProgressAssessment.ResponseMessage response = blockingStub.bookNextAssessment(request);
		
			System.out.println(response.getConfirmed());
			
			channel2.shutdownNow();
			
			
		}else if (label.equals("Change Training")) {
			System.out.println("Here comes a new challenge ...");

			//new training
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
			ChangeTrainingGrpc.ChangeTrainingBlockingStub blockingStub = ChangeTrainingGrpc.newBlockingStub(channel);
			
			TrainingRequest request = TrainingRequest.newBuilder().setUsername("Banjo").build();
			
			//specify because it is more than one message
			Iterator<ChangeTraining.ResponseMessage> responses = blockingStub.newTraining(request);
			while(responses.hasNext()) 
			{
				ChangeTraining.ResponseMessage individualResponse = responses.next();
				System.out.println(individualResponse.getKey() + individualResponse.getValue());	
			}
			
				StreamObserver<TrainingResponse> responseObserver = new StreamObserver<TrainingResponse>() {
				
		        @Override
		        public void onNext(TrainingResponse rm) {
		        	//name of variable.getNameOfVariable
		            System.out.println(rm.getWorkout() + rm.getReps());
		        }

		        @Override
		        public void onCompleted() {
		        }

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}
		    };
		    
		    //create training
		    ChangeTrainingGrpc.ChangeTrainingStub stub1 = ChangeTrainingGrpc.newStub(channel);
		    StreamObserver<MuscleGroup> requestObserver = stub1.createTraining(responseObserver);
		    
		    
		    MuscleGroup rm = MuscleGroup.newBuilder().setMuscletype("Chest").build();
		    MuscleGroup rm1 = MuscleGroup.newBuilder().setMuscletype("Back").build();
		    MuscleGroup rm2 = MuscleGroup.newBuilder().setMuscletype("Leg").build();
		    try {
				Thread.sleep(2000);
			} 
		    catch (InterruptedException en) 
		    {
		    	// TODO Auto-generated catch block
				en.printStackTrace();
			}
		    	requestObserver.onNext(rm);
		    	//requestObserver.onCompleted();
		    	
	    	 try {
	 			Thread.sleep(2000);
	 		} 
	 	    catch (InterruptedException em) 
	 	    {
	 	    	// TODO Auto-generated catch block
	 			em.printStackTrace();
	 		}
	 	    	requestObserver.onNext(rm1);
	 	   
	    	 try {
				Thread.sleep(2000);
			} 
		    catch (InterruptedException el) 
		    {
		    	// TODO Auto-generated catch block
				el.printStackTrace();
			}
		    	requestObserver.onNext(rm2);
		    	
		    requestObserver.onCompleted();
		    
		    //while (true) {
		    	//try {
				//	Thread.sleep(2000);
				//} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
		    //}
		    
		    //recorded work out
		    StreamObserver<RecordedWorkout> responseObserver2 = new StreamObserver<RecordedWorkout>() 
			{

				@Override
				public void onNext(RecordedWorkout value) 
				{
					System.out.println("Server says: " + value.getConfirmed());
					
				}

				@Override
				public void onError(Throwable t) 
				{
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() 
				{
					// TODO Auto-generated method stub
					
				}
			};
			
				// gRPC library returns a StreamObserver to us: requestObserver
				// we use this to send out outgoing messages
				StreamObserver<WorkoutDone> requestObserver2 = stub1.recordTraining(responseObserver2);
				
				requestObserver2.onNext(WorkoutDone.newBuilder().setDone("Squats").setWeight(120).build());
				requestObserver2.onNext(WorkoutDone.newBuilder().setDone("Leg Extension").setWeight(60).build());
				requestObserver2.onNext(WorkoutDone.newBuilder().setDone("Lunges").setWeight(15).build());
			
				System.out.println("Client has now sent its messages.");
				
				
				requestObserver2.onCompleted();
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					channel.shutdown().awaitTermination(60, TimeUnit.SECONDS);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    
		}else{
			
		}

	}
	
}
