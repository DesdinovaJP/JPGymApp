package GymClassBooking;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import GymClassBooking.GymClassBookingGrpc.GymClassBookingImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class GymClassBookingServer extends GymClassBookingImplBase 
{
	public static void main(String[] args) throws InterruptedException, IOException {
		GymClassBookingServer service1 = new GymClassBookingServer();

		int port = 50051;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Gym class, ready to roll on " + port);
		
		JmDNS jmdns = JmDNS.create(InetAddress. getLocalHost());
		ServiceInfo serviceInfo = ServiceInfo.create("_gcbs._tcp.local", "GymClassBooking", port, "GymClassBooking");
		
		jmdns.registerService(serviceInfo);
		
		server.awaitTermination();
		
	}

	@Override
	public void bookUser(BookingDetails request, StreamObserver<ResponseMessage> responseObserver) {

		
		//preparing the response message
		ResponseMessage reply = ResponseMessage.newBuilder().setConfirmed("Confirmed").build();
		
		System.out.println(request.getClass_());

		responseObserver.onNext( reply ); 

		responseObserver.onCompleted();

	}

	@Override
	public void addUser(UserDetails request, StreamObserver<ResponseMessage> responseObserver) {

		System.out.println(request.getUserName());
		//preparing the response message
		ResponseMessage reply = ResponseMessage.newBuilder().setConfirmed("User added").build();

		responseObserver.onNext( reply ); 

		responseObserver.onCompleted();

	}
	

}
