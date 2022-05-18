import FileFilter.FileExtensionFilter;

import java.io.*;

public class IO {

    public static void writeIntWithDataOutputStream(OutputStream os, int[] numbers) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);

        try {
            for (int num : numbers) {
                dos.writeInt(num);

            }

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static int[] readIntWithDataInputStream(InputStream is, int n) throws IOException {
        DataInputStream dis = new DataInputStream(is);
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            try {
                result[i] = dis.readInt();

            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

        return result;
    }

    public static void writeCharStream(Writer cos, int[] numbers) throws IOException {

        try {
            for (int num : numbers) {
                cos.write(String.valueOf(num) + ' ');

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static int[] readCharStream(Reader cis, int n) throws IOException {
        if (cis == null || !cis.ready()) {
            return null;
        }

        int[] result = new int[n];
        int i = 0;
        String number = "";

        while (cis.ready()) {

            int cInteger = cis.read();

            if (cInteger == -1) {
                break;
            }

            char c = (char) cInteger;

            if (c == ' ') {
                result[i] = Integer.parseInt(number);
                i++;
                number = "";

            } else {
                number += c;

            }
        }

        return result;
    }

    public static int[] readIntegersBeginWithPosition(RandomAccessFile is, long position) throws IOException {
        if (position < 0 || is == null ) {
            return new int[] {};
        }

        int[] numbers = new int[(int) ((is.length() - position ) / Integer.BYTES)];

        is.seek(position);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = is.readInt();

        }

        return numbers;
    }

    public static String[] getFilesListWithExtension(File directory, String ext) {
        if (directory.isDirectory()) {
            return directory.list(new FileExtensionFilter(ext));
        } else {
            throw new IllegalArgumentException("This directory doesnt exists");
        }

    }

}
