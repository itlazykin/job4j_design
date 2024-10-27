package ru.job4j.io.tregulove;

import java.io.*;

public class DataStreamEx {
    public static void main(String[] args) {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("test.bin"));
             DataInputStream input = new DataInputStream(new FileInputStream("test.bin"))) {
            output.writeBoolean(true);
            output.writeByte(4);
            output.writeShort(125);
            output.writeInt(444);
            output.writeLong(4_444_444);
            output.writeFloat(0.420F);
            output.writeDouble(4.20D);
            System.out.println(input.readBoolean());
            System.out.println(input.readByte());
            System.out.println(input.readShort());
            System.out.println(input.readInt());
            System.out.println(input.readLong());
            System.out.println(input.readFloat());
            System.out.println(input.readDouble());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
