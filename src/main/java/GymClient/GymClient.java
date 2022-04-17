package GymClient;

import java.util.concurrent.TimeUnit;

import GymClassBooking.GymClassBookingGrpc;
import ProgressAssessment.AssessmentDetail;
import ProgressAssessment.ProgressAssessmentGrpc;
import ProgressAssessment.ResponseMessage;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class GymClient 
{

	public static void main(String[] args) throws InterruptedException 
	{
		service2();
	}
	
	public static void service1() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		GymClassBookingGrpc.GymClassBookingBlockingStub blockingStub = GymClassBookingGrpc.newBlockingStub(channel);

		//Add user method
		//preparing message to send
		GymClassBooking.UserDetails request = GymClassBooking.UserDetails.newBuilder().setUserName("jp").setPassword("123").setGym("CHQ").build();

		//retreving reply from service
		GymClassBooking.ResponseMessage response = blockingStub.addUser(request);
	
		System.out.println(response.getConfirmed());
		
		
		//BookUser method
		//preparing message to send
		GymClassBooking.BookingDetails requestBook = GymClassBooking.BookingDetails.newBuilder().setTime("morning").setClass_("spinning").build();//use Class_ reserved word

		//retreving reply from service
		GymClassBooking.ResponseMessage responseBook = blockingStub.bookUser(requestBook);
	
		System.out.println(responseBook.getConfirmed());
		
		channel.shutdownNow();

	}
	
	public static void service2() throws InterruptedException 
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
		ProgressAssessmentGrpc.ProgressAssessmentStub stub = ProgressAssessmentGrpc.newStub(channel);

		//Add user detail 
		StreamObserver<ResponseMessage> responseObserver = new StreamObserver<ResponseMessage>() 
		{

			@Override
			public void onNext(ResponseMessage value) 
			{
				System.out.println("Final Response from the Server: " + value.getConfirmed());
				
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
		
			System.out.println("Client has now sent its messages.");
			
			
			requestObserver.onCompleted();
			
			Thread.sleep(5000);
		
		// Clean up : Shutdown the channel
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

}
