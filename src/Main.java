import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		while (n!=0) {
			if (n == 1) {
				System.out.println(1);
			} else {
				int[] temperatures=new int[n];
				for (int i=0;i<n;i++) {
					temperatures[i] = sc.nextInt();
				}
				System.out.println(getShortestCycle(temperatures));
			}
			n = sc.nextInt();
		}
	}

	private static int getShortestCycle(int[] temperatures) {
		// TODO Auto-generated method stub
		int[] changes = new int[temperatures.length-1];
		for (int i=0;i<temperatures.length-1;i++) {
			changes[i] = temperatures[i+1] - temperatures[i];
		}
		return getShortestCycleByChanges(changes);
	}

	private static int getShortestCycleByChanges(int[] changes) {
		// TODO Auto-generated method stub
		int start = changes[0];
		int nextStartIndex = findIndex(changes, start, 1);
		if (nextStartIndex<0)
			return changes.length;
		while (!isCycle(changes, nextStartIndex)) {
			nextStartIndex = findIndex(changes, start, nextStartIndex+1);
			if (nextStartIndex < 0) {
				nextStartIndex = changes.length;
				break;
			}
		}
		return nextStartIndex;
	}

	private static boolean isCycle(int[] changes, int cycleLength) {
		// TODO Auto-generated method stub
		for (int i=cycleLength;i<changes.length;i++) {
			int indexInCycle = i % cycleLength;
			if (changes[indexInCycle] != changes[i]) {
				return false;
			}
		}
		return true;
	}

	private static int findIndex(int[] changes, int val, int startIndex) {
		// TODO Auto-generated method stub
		for (int i=startIndex;i<changes.length;i++) {
			if (changes[i] == val) {
				return i;
			}
		}
		return -1;
	}

}
