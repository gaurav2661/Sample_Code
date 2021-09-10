package com.racloop.ARM;

import java.io.*;

public class TryWithResourcesDemo {

    static String inFilestr = "D:\\hello.txt";
    static String outFilestr = "D:\\hello1.txt";

    public static void main(String[] args) {
        try {
            fieCopyWithArm();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fieCopyWithArm() throws IOException {
        try (
                Test t = new Test();
                Test2 t2 = new Test2();
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFilestr));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFilestr))
        ) {
            System.out.println("\ninside filecopywitharm method...");
            byte[] b = new byte[400];
            int num = 0;
            while ((num = in.read(b)) != -1) {
                out.write(b, 0, num);
            }
            throw new IOException("Important Exception");
        }
    }
}

class Test implements AutoCloseable {
    public void close() throws IOException {
        throw new IOException(("Trivial exception "));
    }
}

class Test2 implements AutoCloseable {
    public void close() throws IOException {
        throw new IOException(("Trivial exception "));
    }
}
