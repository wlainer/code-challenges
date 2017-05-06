package challenge;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;

public class TestBase {

	private ByteArrayOutputStream baos;
	private PrintStream oldOut;

	@Before
	public void setup() {
		configureSystemOut();
	}

	protected Scanner getScanner() {
		String testFile = getTestFile() + "_" + getIndexTestCase() + "_in.txt";
		createIfNotExits(testFile);

		return new Scanner(getTestFileInputStream(testFile));
	}

	protected String getTestFile() {
		String canonicalName = Thread.currentThread().getStackTrace()[3].getClassName();
		String filepath = "/" + canonicalName.replace('.', '/');
		return filepath;
	}

	private InputStream getTestFileInputStream(String file) {
		return Thread.currentThread().getStackTrace()[1].getClass().getResourceAsStream(file);
	}

	private void createIfNotExits(String testFile) {
		try {
			File projectLocation = new File("");
			String absolutePath = projectLocation.getAbsolutePath().replace('\\', '/') + "/src/main/resources" + testFile;

			File file = new File(absolutePath);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void configureSystemOut() {
		oldOut = System.out;
		baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
	}
	
	protected void restoreOldOut() {
		System.setOut(oldOut);
	}
	
	protected String intArrayToString(int[] A) {
		return Arrays.stream(A)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(" "));
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

	protected void checkLines() {
		try {
			String testFile = getTestFile() + "_" + getIndexTestCase() + "_out.txt";
			createIfNotExits(testFile);

			BufferedReader solution = new BufferedReader(new InputStreamReader(getTestFileInputStream(testFile)));

			String[] answer = getLines();

			String line = null;
			int count = 0;
			while ((line = solution.readLine()) != null)
				Assert.assertEquals(line, answer[count++]);

		} catch (Exception e) {
			throw new RuntimeException("Ops... Something went wrong.", e);
		}

	}
	
	protected String getIndexTestCase() {
		return "01";
	}
}
