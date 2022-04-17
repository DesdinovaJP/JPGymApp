package GymClient;

import GymClassBooking.GymClassBookingGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GymClient 
{

	public static void main(String[] args) {
		
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

}
