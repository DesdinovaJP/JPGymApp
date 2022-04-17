package GymClassBooking;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: GymClassBooking.proto")
public final class GymClassBookingGrpc {

  private GymClassBookingGrpc() {}

  public static final String SERVICE_NAME = "GymClassBooking.GymClassBooking";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GymClassBooking.UserDetails,
      GymClassBooking.UserDetails> getAddUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addUser",
      requestType = GymClassBooking.UserDetails.class,
      responseType = GymClassBooking.UserDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GymClassBooking.UserDetails,
      GymClassBooking.UserDetails> getAddUserMethod() {
    io.grpc.MethodDescriptor<GymClassBooking.UserDetails, GymClassBooking.UserDetails> getAddUserMethod;
    if ((getAddUserMethod = GymClassBookingGrpc.getAddUserMethod) == null) {
      synchronized (GymClassBookingGrpc.class) {
        if ((getAddUserMethod = GymClassBookingGrpc.getAddUserMethod) == null) {
          GymClassBookingGrpc.getAddUserMethod = getAddUserMethod = 
              io.grpc.MethodDescriptor.<GymClassBooking.UserDetails, GymClassBooking.UserDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GymClassBooking.GymClassBooking", "addUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GymClassBooking.UserDetails.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GymClassBooking.UserDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new GymClassBookingMethodDescriptorSupplier("addUser"))
                  .build();
          }
        }
     }
     return getAddUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GymClassBooking.BookingDetails,
      GymClassBooking.ResponseMessage> getBookUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookUser",
      requestType = GymClassBooking.BookingDetails.class,
      responseType = GymClassBooking.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GymClassBooking.BookingDetails,
      GymClassBooking.ResponseMessage> getBookUserMethod() {
    io.grpc.MethodDescriptor<GymClassBooking.BookingDetails, GymClassBooking.ResponseMessage> getBookUserMethod;
    if ((getBookUserMethod = GymClassBookingGrpc.getBookUserMethod) == null) {
      synchronized (GymClassBookingGrpc.class) {
        if ((getBookUserMethod = GymClassBookingGrpc.getBookUserMethod) == null) {
          GymClassBookingGrpc.getBookUserMethod = getBookUserMethod = 
              io.grpc.MethodDescriptor.<GymClassBooking.BookingDetails, GymClassBooking.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GymClassBooking.GymClassBooking", "bookUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GymClassBooking.BookingDetails.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GymClassBooking.ResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new GymClassBookingMethodDescriptorSupplier("bookUser"))
                  .build();
          }
        }
     }
     return getBookUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GymClassBookingStub newStub(io.grpc.Channel channel) {
    return new GymClassBookingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GymClassBookingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GymClassBookingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GymClassBookingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GymClassBookingFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class GymClassBookingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *after a bit of thought decided to change from client streaming to unary because it makes more sense
     *just a request and a response for the user details
     * </pre>
     */
    public void addUser(GymClassBooking.UserDetails request,
        io.grpc.stub.StreamObserver<GymClassBooking.UserDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getAddUserMethod(), responseObserver);
    }

    /**
     * <pre>
     *book user is unary
     * </pre>
     */
    public void bookUser(GymClassBooking.BookingDetails request,
        io.grpc.stub.StreamObserver<GymClassBooking.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getBookUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GymClassBooking.UserDetails,
                GymClassBooking.UserDetails>(
                  this, METHODID_ADD_USER)))
          .addMethod(
            getBookUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                GymClassBooking.BookingDetails,
                GymClassBooking.ResponseMessage>(
                  this, METHODID_BOOK_USER)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class GymClassBookingStub extends io.grpc.stub.AbstractStub<GymClassBookingStub> {
    private GymClassBookingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GymClassBookingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymClassBookingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GymClassBookingStub(channel, callOptions);
    }

    /**
     * <pre>
     *after a bit of thought decided to change from client streaming to unary because it makes more sense
     *just a request and a response for the user details
     * </pre>
     */
    public void addUser(GymClassBooking.UserDetails request,
        io.grpc.stub.StreamObserver<GymClassBooking.UserDetails> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *book user is unary
     * </pre>
     */
    public void bookUser(GymClassBooking.BookingDetails request,
        io.grpc.stub.StreamObserver<GymClassBooking.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBookUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class GymClassBookingBlockingStub extends io.grpc.stub.AbstractStub<GymClassBookingBlockingStub> {
    private GymClassBookingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GymClassBookingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymClassBookingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GymClassBookingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *after a bit of thought decided to change from client streaming to unary because it makes more sense
     *just a request and a response for the user details
     * </pre>
     */
    public GymClassBooking.UserDetails addUser(GymClassBooking.UserDetails request) {
      return blockingUnaryCall(
          getChannel(), getAddUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *book user is unary
     * </pre>
     */
    public GymClassBooking.ResponseMessage bookUser(GymClassBooking.BookingDetails request) {
      return blockingUnaryCall(
          getChannel(), getBookUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class GymClassBookingFutureStub extends io.grpc.stub.AbstractStub<GymClassBookingFutureStub> {
    private GymClassBookingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GymClassBookingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GymClassBookingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GymClassBookingFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *after a bit of thought decided to change from client streaming to unary because it makes more sense
     *just a request and a response for the user details
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<GymClassBooking.UserDetails> addUser(
        GymClassBooking.UserDetails request) {
      return futureUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *book user is unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<GymClassBooking.ResponseMessage> bookUser(
        GymClassBooking.BookingDetails request) {
      return futureUnaryCall(
          getChannel().newCall(getBookUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_USER = 0;
  private static final int METHODID_BOOK_USER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GymClassBookingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GymClassBookingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_USER:
          serviceImpl.addUser((GymClassBooking.UserDetails) request,
              (io.grpc.stub.StreamObserver<GymClassBooking.UserDetails>) responseObserver);
          break;
        case METHODID_BOOK_USER:
          serviceImpl.bookUser((GymClassBooking.BookingDetails) request,
              (io.grpc.stub.StreamObserver<GymClassBooking.ResponseMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GymClassBookingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GymClassBookingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GymClassBooking.GymClassBookingImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GymClassBooking");
    }
  }

  private static final class GymClassBookingFileDescriptorSupplier
      extends GymClassBookingBaseDescriptorSupplier {
    GymClassBookingFileDescriptorSupplier() {}
  }

  private static final class GymClassBookingMethodDescriptorSupplier
      extends GymClassBookingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GymClassBookingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GymClassBookingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GymClassBookingFileDescriptorSupplier())
              .addMethod(getAddUserMethod())
              .addMethod(getBookUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
