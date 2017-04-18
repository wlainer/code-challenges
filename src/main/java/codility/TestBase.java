package codility;

public class TestBase implements TestInterface {

	@Override
	public Object run() {
		return "Hello";
	}
	
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		test1.run();
	}

}
