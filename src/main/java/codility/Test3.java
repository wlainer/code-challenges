package codility;

import static org.junit.Assert.assertThat;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

import org.hamcrest.Matchers;
import org.junit.Test;

public class Test3 implements TestInterface {

	public static void main(String[] args) {
		Test3 test3 = new Test3();
		test3.run();
	}

	@Override
	public Object run() {
		Test3 test3 = new Test3();

		int[] A = { 60, 80, 40};
		int[] B = { 2, 3, 5};
		int M = 5;
		int X = 2;
		int Y = 200;

		int solution = test3.solution(A, B, M, X, Y);

		System.out.println(solution);

		return null;
	}
	
	public int solution(int[] A, int[] B, int M, int X, int Y) { 
		if (A == null || B == null || A.length == 0 || B.length == 0 || X < 1 || Y < 1) 
            return 0;
        
		int stops = 0;
		Queue<Person> personQueue = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
            if (A[i] > Y) {
                throw new RuntimeException("Weight greater than limit!");
            }
            personQueue.add(new Person(A[i], B[i]));
        }
		
		while (!personQueue.isEmpty()) {
			stops += Elevator.work(personQueue, M, X, Y);
        }
        return stops;
	}
//	
//	int helper(Queue<Person> taskQueue, int M, int X, int Y) {
//        Set<Integer> floors = new HashSet<>();
//        while (!taskQueue.isEmpty() && X > 0 && (Y - taskQueue.peek().weight) >= 0) {
//        	Person person = taskQueue.poll();
//            X -= 1;
//            Y -= person.weight;
//            floors.add(person.floor);
//        }
//        return floors.size() + 1;
//    }

//	public int solution(int[] A, int[] B, int M, int X, int Y) {
//		int queueSize = A.length;
//
//		int numStops = 0;
//
//		Elevator elevator = new Elevator(M, Y, X);
//
//		for (int x = 0; x < queueSize; x++) {
//			try {
//				Person person = new Person(A[x], B[x]);
//				elevator.addPerson(person);
//			} catch (IllegalArgumentException e) {
//				numStops = elevator.work();
//				x = x -1; // try last person
//			}
//		}
//		
//		numStops += elevator.work();
//
//		return numStops;
//
//	}

	public class Person {
		public int weight;
		public int floor;

		public Person(int weight, int floor) {
			this.weight = weight;
			this.floor = floor;
		}
	}

	public static class Elevator {
		public static int work(Queue<Person> queue, int numFloors, int maxCapacity, int maxWeight) {
			BitSet floors = new BitSet(numFloors);
	        while (!queue.isEmpty() && maxCapacity > 0 && (maxWeight - queue.peek().weight) >= 0) {
	            Person person = queue.poll();
	            maxCapacity -= 1;
	            maxWeight -= person.weight;
	            floors.set(person.floor);
	        }
	        return floors.cardinality() + 1;
		}

//		public int work() {
//			int numStops = 0;
//			for (int x = 1; x <= numFloors; x++) {
//				boolean containSome = false;
//				for (Person person : persons) {
//					if (person.floor == x) {
//						containSome = true;
//						break;
//					}
//				}
//
//				if (containSome) {
//					numStops++;
//					Iterator<Person> iterator = persons.iterator();
//					while (iterator.hasNext()) {
//						Person person = iterator.next();
//						if (person.floor == x) 
//							iterator.remove();
//					}
//				}
//			}
//			
//			numStops++; //returning to floor
//			return numStops;
//		}

//		public int totalWeight() {
//			int sum = 0;
//			for (Person person : persons) {
//				sum += person.weight;
//			}
//			return sum;
//		}
//
//		public int totalPeople() {
//			int sum = 0;
//			for (Person person : persons) {
//				sum += 1;
//			}
//			return sum;
//		}
	}
	
	@Test
    public void test() {
        int[] A = new int[] {60, 80, 40};
        int[] B = new int[] {2, 3, 5};
        int M = 5;
        int X = 2;
        int Y = 200;
        assertThat(solution(A, B, M, X, Y), Matchers.is(5));

        A = new int[] {40, 40, 100, 80, 20};
        B = new int[] {3, 3, 2, 2, 3};
        M = 3;
        X = 5;
        Y = 200;
        assertThat(solution(A, B, M, X, Y), Matchers.is(6));

        A = new int[] {40, 40, 100, 200, 20};
        B = new int[] {3, 3, 2, 2, 3};
        M = 3;
        X = 5;
        Y = 200;
        assertThat(solution(A, B, M, X, Y), Matchers.is(7));

        A = new int[] {40, 40, 100, 200, 20};
        B = new int[] {3, 3, 2, 2, 3};
        M = 3;
        X = 1;
        Y = 200;
        assertThat(solution(A, B, M, X, Y), Matchers.is(10));
    }

}
