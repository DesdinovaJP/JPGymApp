package ChangeTraining;

import java.io.IOException;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import ChangeTraining.ChangeTrainingGrpc.ChangeTrainingImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ChangeTrainingServer extends ChangeTrainingImplBase 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		ChangeTrainingServer service1 = new ChangeTrainingServer();

		int port = 50053;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Let's see those gains " + port);
		JmDNS jmdns = JmDNS.create(InetAddress. getLocalHost());
		ServiceInfo serviceInfo = ServiceInfo.create("_gcbs._tcp.local", "ChangeTraining", port, "ChangeTraining");
		
		jmdns.registerService(serviceInfo);
		

		server.awaitTermination();
	}
		
		// for server streaming
		@Override
		public void newTraining(TrainingRequest request, StreamObserver<ResponseMessage> responseObserver) 
		{
			
			// Find out what was the content of the message sent by the client
			String firstString = request.getUsername();
			System.out.println("User name is: " + firstString);
			
			// Now build up our response
			ResponseMessage.Builder responseBuilder = ResponseMessage.newBuilder();
			
			// first message
			responseBuilder.setKey("The muscle group: chest ").setValue("12 reps");			
			responseObserver.onNext(responseBuilder.build());
			
			// second message
			responseBuilder.setKey("The muscle group: Back ").setValue("15 reps");	
			responseObserver.onNext(responseBuilder.build());
			
			// third message
			responseBuilder.setKey("The muscle group: Leg ").setValue("10 reps");	
			responseObserver.onNext(responseBuilder.build());
			
			// to indicate the message is finished
			responseObserver.onCompleted();
	
		}

		
		@Override
		public StreamObserver<MuscleGroup> createTraining(StreamObserver<TrainingResponse> responseObserver) 
		{
			return new StreamObserver<MuscleGroup>() 
			{
		        int count;
		        
		        @Override
		        public void onNext(MuscleGroup rq) 
		        {
			            count++;
			            System.out.println(rq.getMuscletype());
			        if(rq.getMuscletype().equalsIgnoreCase("Chest"))//add leg back exercises 
			        {
			            TrainingResponse rm = TrainingResponse.newBuilder().setWorkout("BenchPress ").setReps(10).build();
			            TrainingResponse rm1 = TrainingResponse.newBuilder().setWorkout("Fly ").setReps(12).build();
			            TrainingResponse rm2 = TrainingResponse.newBuilder().setWorkout("Push ups ").setReps(15).build();
			            TrainingResponse rm3 = TrainingResponse.newBuilder().setWorkout("Inclined Bench ").setReps(10).build();
			    	    try 
			    	    {
		    				Thread.sleep(1500);
		    			} catch (InterruptedException e) 
			    	    {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    	    	responseObserver.onNext(rm);
		    	    	
		    	    	try 
			    	    {
		    				Thread.sleep(1500);
		    			} catch (InterruptedException e) 
			    	    {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    	    	responseObserver.onNext(rm1);
		    	    	try 
			    	    {
		    				Thread.sleep(1500);
		    			} catch (InterruptedException e) 
			    	    {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    	    	responseObserver.onNext(rm2);
		    	    	try 
			    	    {
		    				Thread.sleep(1500);
		    			} catch (InterruptedException e) 
			    	    {
		    				// TODO Auto-generated catch block
		    				e.printStackTrace();
		    			}
		    	    	responseObserver.onNext(rm3);
		            
			        }
		        
		        }

		        @Override
		        public void onCompleted() 
		        {
		            responseObserver.onCompleted();
		        }

				@Override
				public void onError(Throwable t) 
				{
					// TODO Auto-generated method stub
					
				}

		    };
			
		}
		
		// for client-side streaming rpc, we need to create our own StreamObserver and use it.
		// as we are server we are going to get a stream of messages coming in from client
		// WE need to implement a StreamObserver and pass it back to gRPC library
		public StreamObserver<WorkoutDone> recordTraining(StreamObserver<RecordedWorkout> responseObserver)
		{
			return new StreamObserver<WorkoutDone>() 
			{

				@Override
				public void onNext(WorkoutDone value) 
				{
					System.out.println("On Server; message received from client: " + value.getDone());
					System.out.println("On Server; message received from client: " + value.getWeight());
					
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
					RecordedWorkout.Builder responseBuilder = RecordedWorkout.newBuilder();
					
					responseBuilder.setConfirmed("Well done...");
					
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();
					
				}};
		}

}

