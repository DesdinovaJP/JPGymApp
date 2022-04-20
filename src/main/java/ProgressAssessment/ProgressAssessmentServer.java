package ProgressAssessment;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ProgressAssessment.ProgressAssessmentGrpc.ProgressAssessmentImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ProgressAssessmentServer extends ProgressAssessmentImplBase
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		ProgressAssessmentServer service1 = new ProgressAssessmentServer();

		int port = 50052;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Progress assessment is on " + port);
		
		JmDNS jmdns = JmDNS.create(InetAddress. getLocalHost());
		ServiceInfo serviceInfo = ServiceInfo.create("_gcbs._tcp.local", "ProgressAssessment", port, "ProgressAssessment");
		
		jmdns.registerService(serviceInfo);

		server.awaitTermination();
	}

	// for client-side streaming rpc, we need to create our own StreamObserver and use it.
	// as we are server we are going to get a stream of messages coming in from client
	// WE need to implement a StreamObserver and pass it back to gRPC library
	public StreamObserver<AssessmentDetail> addUserDetail(StreamObserver<ResponseMessage> responseObserver)
	{
		
		System.out.println("On Server; inside the client-side streaming method.");
		return new StreamObserver<AssessmentDetail>() 
		{

			@Override
			public void onNext(AssessmentDetail value) 
			{
				System.out.println("On Server; message received from client: " + value.getKey());
				
			}

			@Override
			public void onError(Throwable t) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() 
			{
				// Now build up our response
				ResponseMessage.Builder responseBuilder = ResponseMessage.newBuilder();
				
				responseBuilder.setConfirmed("Just a moment, we are scheduling your assessment...");
				
				responseObserver.onNext(responseBuilder.build());
				responseObserver.onCompleted();
				
			}};
	}

	@Override
	public void bookNextAssessment(BookRequest request, StreamObserver<ResponseMessage> responseObserver) {

		System.out.println(request.getUsername());
		//preparing the response message
		ResponseMessage reply = ResponseMessage.newBuilder().setConfirmed(request.getUsername() + ", your next assesment is in 40 days").build();

		responseObserver.onNext( reply ); 

		responseObserver.onCompleted();

	}
	

}
