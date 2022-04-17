package ChangeTraining;

import java.io.IOException;

import ChangeTraining.ChangeTrainingGrpc.ChangeTrainingImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ChangeTrainingServer extends ChangeTrainingImplBase {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		ChangeTrainingServer service1 = new ChangeTrainingServer();

		int port = 50053;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Let's see those gains " + port);

		server.awaitTermination();
	}
		
		// for server streaming
		@Override
		public void newTraining(TrainingRequest request, StreamObserver<ResponseMessage> responseObserver) {
			
			// Find out what was the content of the message sent by the client
			String firstString = request.getUsername();
			System.out.println("Our first request string is: " + firstString);
			
			// Now build up our response
			ResponseMessage.Builder responseBuilder = ResponseMessage.newBuilder();
			
			// first message
			responseBuilder.setKey("The muscle group: chest").setValue("12 reps");			
			responseObserver.onNext(responseBuilder.build());
			
			
			// second message
			responseBuilder.setKey("The muscle group: Back").setValue("15 reps");	
			responseObserver.onNext(responseBuilder.build());
			
			// third message
			responseBuilder.setKey("The muscle group: Leg").setValue("10 reps");	
			responseObserver.onNext(responseBuilder.build());
			
			// to indicate the message is finished
			responseObserver.onCompleted();
	
		}

	}

