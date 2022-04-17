package ProgressAssessment;

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
    comments = "Source: ProgressAssessment.proto")
public final class ProgressAssessmentGrpc {

  private ProgressAssessmentGrpc() {}

  public static final String SERVICE_NAME = "ProgressAssessment.ProgressAssessment";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ProgressAssessment.AssessmentDetail,
      ProgressAssessment.ResponseMessage> getAddUserDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addUserDetail",
      requestType = ProgressAssessment.AssessmentDetail.class,
      responseType = ProgressAssessment.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ProgressAssessment.AssessmentDetail,
      ProgressAssessment.ResponseMessage> getAddUserDetailMethod() {
    io.grpc.MethodDescriptor<ProgressAssessment.AssessmentDetail, ProgressAssessment.ResponseMessage> getAddUserDetailMethod;
    if ((getAddUserDetailMethod = ProgressAssessmentGrpc.getAddUserDetailMethod) == null) {
      synchronized (ProgressAssessmentGrpc.class) {
        if ((getAddUserDetailMethod = ProgressAssessmentGrpc.getAddUserDetailMethod) == null) {
          ProgressAssessmentGrpc.getAddUserDetailMethod = getAddUserDetailMethod = 
              io.grpc.MethodDescriptor.<ProgressAssessment.AssessmentDetail, ProgressAssessment.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ProgressAssessment.ProgressAssessment", "addUserDetail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProgressAssessment.AssessmentDetail.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProgressAssessment.ResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new ProgressAssessmentMethodDescriptorSupplier("addUserDetail"))
                  .build();
          }
        }
     }
     return getAddUserDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ProgressAssessment.BookRequest,
      ProgressAssessment.ResponseMessage> getBookNextAssessmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookNextAssessment",
      requestType = ProgressAssessment.BookRequest.class,
      responseType = ProgressAssessment.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ProgressAssessment.BookRequest,
      ProgressAssessment.ResponseMessage> getBookNextAssessmentMethod() {
    io.grpc.MethodDescriptor<ProgressAssessment.BookRequest, ProgressAssessment.ResponseMessage> getBookNextAssessmentMethod;
    if ((getBookNextAssessmentMethod = ProgressAssessmentGrpc.getBookNextAssessmentMethod) == null) {
      synchronized (ProgressAssessmentGrpc.class) {
        if ((getBookNextAssessmentMethod = ProgressAssessmentGrpc.getBookNextAssessmentMethod) == null) {
          ProgressAssessmentGrpc.getBookNextAssessmentMethod = getBookNextAssessmentMethod = 
              io.grpc.MethodDescriptor.<ProgressAssessment.BookRequest, ProgressAssessment.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ProgressAssessment.ProgressAssessment", "bookNextAssessment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProgressAssessment.BookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProgressAssessment.ResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new ProgressAssessmentMethodDescriptorSupplier("bookNextAssessment"))
                  .build();
          }
        }
     }
     return getBookNextAssessmentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProgressAssessmentStub newStub(io.grpc.Channel channel) {
    return new ProgressAssessmentStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProgressAssessmentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProgressAssessmentBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProgressAssessmentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProgressAssessmentFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class ProgressAssessmentImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *add user here is client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ProgressAssessment.AssessmentDetail> addUserDetail(
        io.grpc.stub.StreamObserver<ProgressAssessment.ResponseMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(getAddUserDetailMethod(), responseObserver);
    }

    /**
     * <pre>
     *bookNext is server is unary
     * </pre>
     */
    public void bookNextAssessment(ProgressAssessment.BookRequest request,
        io.grpc.stub.StreamObserver<ProgressAssessment.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getBookNextAssessmentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddUserDetailMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ProgressAssessment.AssessmentDetail,
                ProgressAssessment.ResponseMessage>(
                  this, METHODID_ADD_USER_DETAIL)))
          .addMethod(
            getBookNextAssessmentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ProgressAssessment.BookRequest,
                ProgressAssessment.ResponseMessage>(
                  this, METHODID_BOOK_NEXT_ASSESSMENT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ProgressAssessmentStub extends io.grpc.stub.AbstractStub<ProgressAssessmentStub> {
    private ProgressAssessmentStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProgressAssessmentStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgressAssessmentStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProgressAssessmentStub(channel, callOptions);
    }

    /**
     * <pre>
     *add user here is client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ProgressAssessment.AssessmentDetail> addUserDetail(
        io.grpc.stub.StreamObserver<ProgressAssessment.ResponseMessage> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAddUserDetailMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *bookNext is server is unary
     * </pre>
     */
    public void bookNextAssessment(ProgressAssessment.BookRequest request,
        io.grpc.stub.StreamObserver<ProgressAssessment.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBookNextAssessmentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ProgressAssessmentBlockingStub extends io.grpc.stub.AbstractStub<ProgressAssessmentBlockingStub> {
    private ProgressAssessmentBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProgressAssessmentBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgressAssessmentBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProgressAssessmentBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *bookNext is server is unary
     * </pre>
     */
    public ProgressAssessment.ResponseMessage bookNextAssessment(ProgressAssessment.BookRequest request) {
      return blockingUnaryCall(
          getChannel(), getBookNextAssessmentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ProgressAssessmentFutureStub extends io.grpc.stub.AbstractStub<ProgressAssessmentFutureStub> {
    private ProgressAssessmentFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProgressAssessmentFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgressAssessmentFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProgressAssessmentFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *bookNext is server is unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ProgressAssessment.ResponseMessage> bookNextAssessment(
        ProgressAssessment.BookRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBookNextAssessmentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOK_NEXT_ASSESSMENT = 0;
  private static final int METHODID_ADD_USER_DETAIL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProgressAssessmentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProgressAssessmentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BOOK_NEXT_ASSESSMENT:
          serviceImpl.bookNextAssessment((ProgressAssessment.BookRequest) request,
              (io.grpc.stub.StreamObserver<ProgressAssessment.ResponseMessage>) responseObserver);
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
        case METHODID_ADD_USER_DETAIL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addUserDetail(
              (io.grpc.stub.StreamObserver<ProgressAssessment.ResponseMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProgressAssessmentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProgressAssessmentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ProgressAssessment.ProgressAssessmentImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProgressAssessment");
    }
  }

  private static final class ProgressAssessmentFileDescriptorSupplier
      extends ProgressAssessmentBaseDescriptorSupplier {
    ProgressAssessmentFileDescriptorSupplier() {}
  }

  private static final class ProgressAssessmentMethodDescriptorSupplier
      extends ProgressAssessmentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProgressAssessmentMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProgressAssessmentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProgressAssessmentFileDescriptorSupplier())
              .addMethod(getAddUserDetailMethod())
              .addMethod(getBookNextAssessmentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
