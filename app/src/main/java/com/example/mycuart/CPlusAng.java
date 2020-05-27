package com.example.mycuart;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CPlusAng {

    private final String TAG = CPlusAng.class.getSimpleName();
    private FileDescriptor mFd;
    private FileInputStream mFileInputStream;
    private FileOutputStream mFileOutputStream;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("my_sugar");
    }

    // JNI
    public native static FileDescriptor open(String path, int baudrate, int flags);

    public native void stringFromJNI(int Angle,int flag);

    public native void close();


//    public MainActivity(String devicePath, int baudrate, int flag) throws IOException {
////        mFd = open("/dev/ttyMT2", 9600, 0);
//        mFd = open(devicePath, baudrate, flag);
//        if (mFd == null) {
//            Log.e(TAG, "native open returns null");
//            throw new IOException();
//        }
//
//        mFileInputStream = new FileInputStream(mFd);
//        mFileOutputStream = new FileOutputStream(mFd);
//    }

//    class InputThread implements Runnable {
//
//        @Override
//        public void run() {
//            try {
//                mFileOutputStream.write("AT+DMOCONNECT\r\n".getBytes());
//                Log.e(TAG, "run: 发送成功");
//                while (true) {
//                    byte[] bys = new byte[1024];
//                    int len = mFileInputStream.read(bys);
//                    String s = new String(bys, 0, len);
//                    Log.e(TAG, "接收: " + s);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    // Getters and setters
    public InputStream getInputStream() {
        return mFileInputStream;
    }

    public OutputStream getOutputStream() {
        return mFileOutputStream;
    }

}
