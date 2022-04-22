package GymClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.jmdns.JmDNS;
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

public class GymClient 
{
	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException 
	{
		
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress. getLocalHost());
			// Add a service listener
			jmdns.addServiceListener("_gcbs._tcp.local.", new GymClassBookingServiceDiscovery.SampleListener());
			jmdns.addServiceListener("_pas._tcp.local.", new ProgressAssessmentServiceDiscovery.SampleListener());
			jmdns.addServiceListener("_cts._tcp.local.", new ChangeTrainingServiceDiscovery.SampleListener());
	}
	
	public static void service1(String host, int port) 
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		//ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
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
		try
		{
			channel.awaitTermination(5000,TimeUnit.MICROSECONDS);
		}
		catch (InterruptedException ex)
		{
			System.err.println("gRPC channel shutdown interrupted");
		}

	}
	
	public static void service2(String host, int port) throws InterruptedException 
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		//ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
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
			requestObserver.onNext(AssessmentDetail.newBuilder().setKey("Username").setValue("RohitGenius").build());
		
			System.out.println("User details added.");
			
			
			requestObserver.onCompleted();
			
			Thread.sleep(5000);
		
		// Clean up : Shutdown the channel
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
		//bookNextAssessment
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		//ManagedChannel channel2 = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
		ProgressAssessmentGrpc.ProgressAssessmentBlockingStub blockingStub = ProgressAssessmentGrpc.newBlockingStub(channel2);

		//preparing message to send
		ProgressAssessment.BookRequest request = ProgressAssessment.BookRequest.newBuilder().setUsername("Finn").build();

		//retrieving reply from service
		ProgressAssessment.ResponseMessage response = blockingStub.bookNextAssessment(request);
	
		System.out.println(response.getConfirmed());
		
		channel2.shutdownNow();
		
	}
	
	public static void service3(String host, int port) throws InterruptedException
	{
		//new training
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		//ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
		ChangeTrainingGrpc.ChangeTrainingBlockingStub blockingStub = ChangeTrainingGrpc.newBlockingStub(channel);
		
		TrainingRequest request = TrainingRequest.newBuilder().setUsername("Banjo").build();
		
		//specify because it is more than one message
		Iterator<ChangeTraining.ResponseMessage> responses = blockingStub.newTraining(request);
		while(responses.hasNext()) 
		{
			ChangeTraining.ResponseMessage individualResponse = responses.next();
			System.out.println(individualResponse.getKey() + individualResponse.getValue());	
		}
		
			StreamObserver<TrainingResponse> responseObserver = new StreamObserver<TrainingResponse>() 
			{
			
		        @Override
		        public void onNext(TrainingResponse rm) 
		        {
		        	//name of variable.getNameOfVariable
		            System.out.println(rm.getWorkout() + rm.getReps());
		        }

		        @Override
		        public void onCompleted() 
		        {
		        }
	
				@Override
				public void onError(Throwable t) 
				{
					// TODO Auto-generated method stub
				
				}
			};
	    
	    //create training
	    ChangeTrainingGrpc.ChangeTrainingStub stub1 = ChangeTrainingGrpc.newStub(channel);
	    StreamObserver<MuscleGroup> requestObserver = stub1.createTraining(responseObserver);
	    
	    
	    MuscleGroup rm = MuscleGroup.newBuilder().setMuscletype("Chest").build();
	    MuscleGroup rm1 = MuscleGroup.newBuilder().setMuscletype("Back").build();
	    MuscleGroup rm2 = MuscleGroup.newBuilder().setMuscletype("Leg").build();
	    MuscleGroup rm3 = MuscleGroup.newBuilder().setMuscletype("Coffee").build();
	    try {
			Thread.sleep(2000);
		} 
	    catch (InterruptedException e) 
	    {
	    	// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	requestObserver.onNext(rm);
	    	//requestObserver.onCompleted();
	    	
    	 try {
 			Thread.sleep(2000);
 		} 
 	    catch (InterruptedException e) 
 	    {
 	    	// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	    	requestObserver.onNext(rm1);
 	   
    	 try {
			Thread.sleep(2000);
		} 
	    catch (InterruptedException e) 
	    {
	    	// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	requestObserver.onNext(rm2);
	    	
    	 try {
 			Thread.sleep(2000);
 		} 
 	    catch (InterruptedException e) 
 	    {
 	    	// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	    	requestObserver.onNext(rm3);
	    	
	    requestObserver.onCompleted();
	    
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
		
			requestObserver2.onCompleted();
			
			Thread.sleep(5000);
			channel.shutdown().awaitTermination(60, TimeUnit.SECONDS);
	    
	}
	
}
