// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ChangeTraining.proto

package ChangeTraining;

public final class ChangeTrainingImpl {
  private ChangeTrainingImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChangeTraining_TrainingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChangeTraining_TrainingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChangeTraining_ResponseMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChangeTraining_ResponseMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChangeTraining_MuscleGroup_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChangeTraining_MuscleGroup_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChangeTraining_TrainingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChangeTraining_TrainingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChangeTraining_WorkoutDone_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChangeTraining_WorkoutDone_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChangeTraining_RecordedWorkout_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChangeTraining_RecordedWorkout_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024ChangeTraining.proto\022\016ChangeTraining\"#" +
      "\n\017TrainingRequest\022\020\n\010username\030\001 \001(\t\"-\n\017R" +
      "esponseMessage\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001" +
      "(\t\"!\n\013MuscleGroup\022\022\n\nmuscletype\030\001 \001(\t\"1\n" +
      "\020TrainingResponse\022\017\n\007workout\030\001 \001(\t\022\014\n\004re" +
      "ps\030\002 \001(\005\"+\n\013WorkoutDone\022\014\n\004done\030\001 \001(\t\022\016\n" +
      "\006weight\030\002 \001(\005\"$\n\017RecordedWorkout\022\021\n\tconf" +
      "irmed\030\001 \001(\t2\220\002\n\016ChangeTraining\022S\n\013newTra" +
      "ining\022\037.ChangeTraining.TrainingRequest\032\037" +
      ".ChangeTraining.ResponseMessage\"\0000\001\022U\n\016c" +
      "reateTraining\022\033.ChangeTraining.MuscleGro" +
      "up\032 .ChangeTraining.TrainingResponse\"\000(\001" +
      "0\001\022R\n\016recordTraining\022\033.ChangeTraining.Wo" +
      "rkoutDone\032\037.ChangeTraining.RecordedWorko" +
      "ut\"\000(\001B&\n\016ChangeTrainingB\022ChangeTraining" +
      "ImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ChangeTraining_TrainingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ChangeTraining_TrainingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangeTraining_TrainingRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_ChangeTraining_ResponseMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ChangeTraining_ResponseMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangeTraining_ResponseMessage_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_ChangeTraining_MuscleGroup_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ChangeTraining_MuscleGroup_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangeTraining_MuscleGroup_descriptor,
        new java.lang.String[] { "Muscletype", });
    internal_static_ChangeTraining_TrainingResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_ChangeTraining_TrainingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangeTraining_TrainingResponse_descriptor,
        new java.lang.String[] { "Workout", "Reps", });
    internal_static_ChangeTraining_WorkoutDone_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ChangeTraining_WorkoutDone_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangeTraining_WorkoutDone_descriptor,
        new java.lang.String[] { "Done", "Weight", });
    internal_static_ChangeTraining_RecordedWorkout_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_ChangeTraining_RecordedWorkout_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChangeTraining_RecordedWorkout_descriptor,
        new java.lang.String[] { "Confirmed", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
