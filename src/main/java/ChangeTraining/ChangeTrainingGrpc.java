package ChangeTraining;

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
    comments = "Source: ChangeTraining.proto")
public final class ChangeTrainingGrpc {

  private ChangeTrainingGrpc() {}

  public static final String SERVICE_NAME = "ChangeTraining.ChangeTraining";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ChangeTraining.TrainingRequest,
      ChangeTraining.ResponseMessage> getNewTrainingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "newTraining",
      requestType = ChangeTraining.TrainingRequest.class,
      responseType = ChangeTraining.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ChangeTraining.TrainingRequest,
      ChangeTraining.ResponseMessage> getNewTrainingMethod() {
    io.grpc.MethodDescriptor<ChangeTraining.TrainingRequest, ChangeTraining.ResponseMessage> getNewTrainingMethod;
    if ((getNewTrainingMethod = ChangeTrainingGrpc.getNewTrainingMethod) == null) {
      synchronized (ChangeTrainingGrpc.class) {
        if ((getNewTrainingMethod = ChangeTrainingGrpc.getNewTrainingMethod) == null) {
          ChangeTrainingGrpc.getNewTrainingMethod = getNewTrainingMethod = 
              io.grpc.MethodDescriptor.<ChangeTraining.TrainingRequest, ChangeTraining.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChangeTraining.ChangeTraining", "newTraining"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChangeTraining.TrainingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChangeTraining.ResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new ChangeTrainingMethodDescriptorSupplier("newTraining"))
                  .build();
          }
        }
     }
     return getNewTrainingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChangeTraining.MuscleGroup,
      ChangeTraining.TrainingResponse> getCreateTrainingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createTraining",
      requestType = ChangeTraining.MuscleGroup.class,
      responseType = ChangeTraining.TrainingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ChangeTraining.MuscleGroup,
      ChangeTraining.TrainingResponse> getCreateTrainingMethod() {
    io.grpc.MethodDescriptor<ChangeTraining.MuscleGroup, ChangeTraining.TrainingResponse> getCreateTrainingMethod;
    if ((getCreateTrainingMethod = ChangeTrainingGrpc.getCreateTrainingMethod) == null) {
      synchronized (ChangeTrainingGrpc.class) {
        if ((getCreateTrainingMethod = ChangeTrainingGrpc.getCreateTrainingMethod) == null) {
          ChangeTrainingGrpc.getCreateTrainingMethod = getCreateTrainingMethod = 
              io.grpc.MethodDescriptor.<ChangeTraining.MuscleGroup, ChangeTraining.TrainingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChangeTraining.ChangeTraining", "createTraining"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChangeTraining.MuscleGroup.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChangeTraining.TrainingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChangeTrainingMethodDescriptorSupplier("createTraining"))
                  .build();
          }
        }
     }
     return getCreateTrainingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ChangeTraining.WorkoutDone,
      ChangeTraining.RecordedWorkout> getRecordTrainingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "recordTraining",
      requestType = ChangeTraining.WorkoutDone.class,
      responseType = ChangeTraining.RecordedWorkout.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ChangeTraining.WorkoutDone,
      ChangeTraining.RecordedWorkout> getRecordTrainingMethod() {
    io.grpc.MethodDescriptor<ChangeTraining.WorkoutDone, ChangeTraining.RecordedWorkout> getRecordTrainingMethod;
    if ((getRecordTrainingMethod = ChangeTrainingGrpc.getRecordTrainingMethod) == null) {
      synchronized (ChangeTrainingGrpc.class) {
        if ((getRecordTrainingMethod = ChangeTrainingGrpc.getRecordTrainingMethod) == null) {
          ChangeTrainingGrpc.getRecordTrainingMethod = getRecordTrainingMethod = 
              io.grpc.MethodDescriptor.<ChangeTraining.WorkoutDone, ChangeTraining.RecordedWorkout>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ChangeTraining.ChangeTraining", "recordTraining"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChangeTraining.WorkoutDone.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ChangeTraining.RecordedWorkout.getDefaultInstance()))
                  .setSchemaDescriptor(new ChangeTrainingMethodDescriptorSupplier("recordTraining"))
                  .build();
          }
        }
     }
     return getRecordTrainingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChangeTrainingStub newStub(io.grpc.Channel channel) {
    return new ChangeTrainingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChangeTrainingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChangeTrainingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChangeTrainingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChangeTrainingFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class ChangeTrainingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *new training here is server streaming
     * </pre>
     */
    public void newTraining(ChangeTraining.TrainingRequest request,
        io.grpc.stub.StreamObserver<ChangeTraining.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getNewTrainingMethod(), responseObserver);
    }

    /**
     * <pre>
     *create training is a bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ChangeTraining.MuscleGroup> createTraining(
        io.grpc.stub.StreamObserver<ChangeTraining.TrainingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCreateTrainingMethod(), responseObserver);
    }

    /**
     * <pre>
     *recordTraining is client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ChangeTraining.WorkoutDone> recordTraining(
        io.grpc.stub.StreamObserver<ChangeTraining.RecordedWorkout> responseObserver) {
      return asyncUnimplementedStreamingCall(getRecordTrainingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getNewTrainingMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ChangeTraining.TrainingRequest,
                ChangeTraining.ResponseMessage>(
                  this, METHODID_NEW_TRAINING)))
          .addMethod(
            getCreateTrainingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ChangeTraining.MuscleGroup,
                ChangeTraining.TrainingResponse>(
                  this, METHODID_CREATE_TRAINING)))
          .addMethod(
            getRecordTrainingMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ChangeTraining.WorkoutDone,
                ChangeTraining.RecordedWorkout>(
                  this, METHODID_RECORD_TRAINING)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ChangeTrainingStub extends io.grpc.stub.AbstractStub<ChangeTrainingStub> {
    private ChangeTrainingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChangeTrainingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangeTrainingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChangeTrainingStub(channel, callOptions);
    }

    /**
     * <pre>
     *new training here is server streaming
     * </pre>
     */
    public void newTraining(ChangeTraining.TrainingRequest request,
        io.grpc.stub.StreamObserver<ChangeTraining.ResponseMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getNewTrainingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *create training is a bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ChangeTraining.MuscleGroup> createTraining(
        io.grpc.stub.StreamObserver<ChangeTraining.TrainingResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCreateTrainingMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *recordTraining is client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ChangeTraining.WorkoutDone> recordTraining(
        io.grpc.stub.StreamObserver<ChangeTraining.RecordedWorkout> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRecordTrainingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ChangeTrainingBlockingStub extends io.grpc.stub.AbstractStub<ChangeTrainingBlockingStub> {
    private ChangeTrainingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChangeTrainingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangeTrainingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChangeTrainingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *new training here is server streaming
     * </pre>
     */
    public java.util.Iterator<ChangeTraining.ResponseMessage> newTraining(
        ChangeTraining.TrainingRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getNewTrainingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ChangeTrainingFutureStub extends io.grpc.stub.AbstractStub<ChangeTrainingFutureStub> {
    private ChangeTrainingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChangeTrainingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangeTrainingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChangeTrainingFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_NEW_TRAINING = 0;
  private static final int METHODID_CREATE_TRAINING = 1;
  private static final int METHODID_RECORD_TRAINING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChangeTrainingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChangeTrainingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_TRAINING:
          serviceImpl.newTraining((ChangeTraining.TrainingRequest) request,
              (io.grpc.stub.StreamObserver<ChangeTraining.ResponseMessage>) responseObserver);
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
        case METHODID_CREATE_TRAINING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.createTraining(
              (io.grpc.stub.StreamObserver<ChangeTraining.TrainingResponse>) responseObserver);
        case METHODID_RECORD_TRAINING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordTraining(
              (io.grpc.stub.StreamObserver<ChangeTraining.RecordedWorkout>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChangeTrainingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChangeTrainingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ChangeTraining.ChangeTrainingImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChangeTraining");
    }
  }

  private static final class ChangeTrainingFileDescriptorSupplier
      extends ChangeTrainingBaseDescriptorSupplier {
    ChangeTrainingFileDescriptorSupplier() {}
  }

  private static final class ChangeTrainingMethodDescriptorSupplier
      extends ChangeTrainingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChangeTrainingMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChangeTrainingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChangeTrainingFileDescriptorSupplier())
              .addMethod(getNewTrainingMethod())
              .addMethod(getCreateTrainingMethod())
              .addMethod(getRecordTrainingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
