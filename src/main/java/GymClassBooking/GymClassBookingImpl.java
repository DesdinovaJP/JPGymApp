// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: GymClassBooking.proto

package GymClassBooking;

public final class GymClassBookingImpl {
  private GymClassBookingImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GymClassBooking_UserDetails_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GymClassBooking_UserDetails_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GymClassBooking_BookingDetails_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GymClassBooking_BookingDetails_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GymClassBooking_ResponseMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GymClassBooking_ResponseMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025GymClassBooking.proto\022\017GymClassBooking" +
      "\">\n\013UserDetails\022\020\n\010userName\030\001 \001(\t\022\013\n\003gym" +
      "\030\002 \001(\t\022\020\n\010password\030\003 \001(\t\"-\n\016BookingDetai" +
      "ls\022\014\n\004time\030\001 \001(\t\022\r\n\005class\030\002 \001(\t\"$\n\017Respo" +
      "nseMessage\022\021\n\tconfirmed\030\001 \001(\t2\257\001\n\017GymCla" +
      "ssBooking\022K\n\007addUser\022\034.GymClassBooking.U" +
      "serDetails\032 .GymClassBooking.ResponseMes" +
      "sage\"\000\022O\n\010bookUser\022\037.GymClassBooking.Boo" +
      "kingDetails\032 .GymClassBooking.ResponseMe" +
      "ssage\"\000B(\n\017GymClassBookingB\023GymClassBook" +
      "ingImplP\001b\006proto3"
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
    internal_static_GymClassBooking_UserDetails_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_GymClassBooking_UserDetails_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GymClassBooking_UserDetails_descriptor,
        new java.lang.String[] { "UserName", "Gym", "Password", });
    internal_static_GymClassBooking_BookingDetails_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_GymClassBooking_BookingDetails_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GymClassBooking_BookingDetails_descriptor,
        new java.lang.String[] { "Time", "Class_", });
    internal_static_GymClassBooking_ResponseMessage_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GymClassBooking_ResponseMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GymClassBooking_ResponseMessage_descriptor,
        new java.lang.String[] { "Confirmed", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
