package codility;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class TestBase implements TestInterface {

	@Override
	public Object run() {
		return "Hello";
	}
	
	protected static String getTestFile() {
		String canonicalName = Thread.currentThread().getStackTrace()[3].getClassName();
		String filepath = "/" + canonicalName.replace('.', '/') + "_01.txt";
		return filepath;
	}

	protected static Scanner getScanner() {
		return new Scanner(Thread.currentThread().getStackTrace()[1].getClass().getResourceAsStream(getTestFile()));
	}

	protected void configureSystemOut() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
	}

	protected String[] getLines() {
		byte[] byteArray = baos.toByteArray();
		InputStream inputStream = new ByteArrayInputStream(byteArray);

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	}

}
