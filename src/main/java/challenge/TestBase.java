package challenge;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;

public class TestBase implements TestInterface {

	private ByteArrayOutputStream baos;

	@Before
	public void setup() {
		configureSystemOut();
	}

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
		baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
	}

	protected String[] getLines() {
		try {
			byte[] byteArray = baos.toByteArray();
			InputStream inputStream = new ByteArrayInputStream(byteArray);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			List<String> lines = new ArrayList();
			String line = null;
			while ((line = reader.readLine()) != null)
				lines.add(line);

			String[] toReturn = new String[lines.size()];
			lines.toArray(toReturn);

			return toReturn;
		} catch (Exception e) {
			throw new RuntimeException("An error ocurred reading lines.", e);
		}
	}

}
