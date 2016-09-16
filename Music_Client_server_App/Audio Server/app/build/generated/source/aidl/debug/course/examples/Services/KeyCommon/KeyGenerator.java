/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/aravindachanta/Documents/Android projects/Project#4/Audio Server/app/src/main/aidl/course/examples/Services/KeyCommon/KeyGenerator.aidl
 */
package course.examples.Services.KeyCommon;
public interface KeyGenerator extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements course.examples.Services.KeyCommon.KeyGenerator
{
private static final java.lang.String DESCRIPTOR = "course.examples.Services.KeyCommon.KeyGenerator";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an course.examples.Services.KeyCommon.KeyGenerator interface,
 * generating a proxy if needed.
 */
public static course.examples.Services.KeyCommon.KeyGenerator asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof course.examples.Services.KeyCommon.KeyGenerator))) {
return ((course.examples.Services.KeyCommon.KeyGenerator)iin);
}
return new course.examples.Services.KeyCommon.KeyGenerator.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_startsong:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.startsong(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_stopsong:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.stopsong(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_resumesong:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.resumesong(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_pausesong:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.pausesong(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_transac:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String[] _result = this.transac();
reply.writeNoException();
reply.writeStringArray(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements course.examples.Services.KeyCommon.KeyGenerator
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void startsong(int song) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(song);
mRemote.transact(Stub.TRANSACTION_startsong, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void stopsong(int song) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(song);
mRemote.transact(Stub.TRANSACTION_stopsong, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void resumesong(int song) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(song);
mRemote.transact(Stub.TRANSACTION_resumesong, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void pausesong(int song) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(song);
mRemote.transact(Stub.TRANSACTION_pausesong, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String[] transac() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_transac, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_startsong = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_stopsong = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_resumesong = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_pausesong = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_transac = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
public void startsong(int song) throws android.os.RemoteException;
public void stopsong(int song) throws android.os.RemoteException;
public void resumesong(int song) throws android.os.RemoteException;
public void pausesong(int song) throws android.os.RemoteException;
public java.lang.String[] transac() throws android.os.RemoteException;
}
