package GymClassBooking;

import io.grpc.ServerBuilder;

public class Server 
{
	private Server server;
	public static void main(String[] args) throws IOException
	{
		Server JpServer = new Server();
		JpServer.start();
	}
	
	private void start() throws IOException
	{
		System.out.println("Ready to roll");
		int port = 50051;
		
		server = ServerBuilder.forPort(port).addService(new ServerImpl()).build().start();
		
	}
	
	static class ServerImpl extends ServerImplBase
	{
		
	}

}
