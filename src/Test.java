import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.io.*;

public class Test {
	public static void main (String [] args) throws IOException {
		boolean [] arr = new boolean[64];

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 != 0)		
				arr[i] = false;
			else
				arr[i] = true;
		}

		String str = Arrays.toString(arr);
		FileOutputStream fos = new FileOutputStream("test.txt");
		DataOutputStream dos = new DataOutputStream(fos);

		for (int i = 0; i < arr.length; i++) {
			dos.writeBoolean(arr[i]);
			BinaryStdOut.write(arr[i]);
		}
		dos.close();
		BinaryStdOut.close();
	}
}
