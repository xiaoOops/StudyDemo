package com.xiaox.studydemo.aboutBinder;

/**
 * Binder 的理解
 * 客户端向服务端申请Stub类（继承自Binder）的对象binder,想从binder中获得实现了IPlusInterface的对象
 * 当客户端发现收到的不是binder真身而是它的代理binderproxy时，它在自己进程内构建了一个plus的代理对象（实现了与plus相同的的IPlus接口），
 * 该代理对象的add方法利用binderproxy去向binder申请加法计算，并把结果返回。
 * 这样，从外表上来看，客户端获得了服务端中的IPlusInterface对象，这就是Binder跨进程通信的本质
 */
interface IPlusInterface extends android.os.IInterface {

    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements com.xiaox.studydemo.aboutBinder.IPlusInterface {
        //binder 的唯一标识
        private static final java.lang.String DESCRIPTOR = "com.xiaox.studydemo.aboutBinder.IPlusInterface";

        /**
         * Construct the stub at attach it to the interface.
         * 将自己和标识符保存起来
         * 简单理解就是将 (DESCRIPTOR,stub) 以一个键值对的形式保存在binder中
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.xiaox.studydemo.aboutBinder.IPlusInterface interface,
         * generating a proxy if needed.
         * 用于将服务器的binder对象转换成客户端所需要的对象
         * 区分进程，如果在同一个进程，那返回的的就是服务端的stub对象；否则返回的是 stub.proxy 对象
         */
        public static com.xiaox.studydemo.aboutBinder.IPlusInterface asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.xiaox.studydemo.aboutBinder.IPlusInterface))) {
                return ((com.xiaox.studydemo.aboutBinder.IPlusInterface) iin);
            }
            return new com.xiaox.studydemo.aboutBinder.IPlusInterface.Stub.Proxy(obj);
        }

        /**
         * @return 返回当前的binder对象
         */
        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        /**
         * 这个方法运行在服务端的binder线程池中，当客户端发起跨进程请求时，远程请求会通过系统底层封装后交于此方法处理。
         * 该方法的原型是 public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags)
         * 服务端通过code确定客户端请求的目标方法是什么，接着从data中取出目标方法所需要的参数（如果目标方法有参数的话），
         * 然后执行目标方法，当目标方法执行完毕后，就向reply中写入返回值（如果有的话）。
         * <p>
         * 需要注意:如果此方法返回fasle，那么客户端会请求失败，可以利用这点做权限验证
         */
        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_add: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _arg1;
                    _arg1 = data.readInt();
                    int _result = this.add(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements com.xiaox.studydemo.aboutBinder.IPlusInterface {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /**
             * Demonstrates some basic types that you can use as parameters
             * and return values in AIDL.
             * 该方法运行在客户端
             * 当客户端远程调用此方法时，首先创建该方法所需要的输入型Parcel对象 _data，输出型对象 _reply
             * 接着调用 transact 方法来发起远程调用请求，同时当前线程挂起，然后服务端的 onTransact 方法会被调用
             * 直到请求结束，当前线程继续执行，从 _reply中取回结果
             */
            @Override
            public int add(int a, int b) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(a);
                    _data.writeInt(b);
                    mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }

        static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }

    public int add(int a, int b) throws android.os.RemoteException;
}
