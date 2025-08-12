package test.src.test;

import java.util.Scanner;

public class Nodes {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		for (int t1 = 1; t1 <= T; t1++) {
			int N = scanner.nextInt();
			int E = scanner.nextInt();

			int target1 = scanner.nextInt();
			int target2 = scanner.nextInt();

			java.util.HashMap<Integer, java.util.ArrayList<Integer>> hashMap = new java.util.HashMap<Integer, java.util.ArrayList<Integer>>();
			for (int i = 0; i < E; i++) {
				int s = scanner.nextInt();
				int d = scanner.nextInt();
				if (hashMap.containsKey( s )) {
					java.util.ArrayList<Integer> list = hashMap.get( s );
					list.add( d );
					hashMap.put(s, list);
				} else {
					java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
					list.add( d );
					hashMap.put(s, list);
				}
			}

			boolean isBreak = false;
			java.util.Set<Integer> set = new java.util.HashSet<Integer>();
			int commonRoot = 0;
			while (!isBreak) {
				java.util.Set<Integer> keys = hashMap.keySet();

				if (target1 == 1 && target2 == 1) {
					isBreak = true;
					commonRoot = 1;
					continue;
				}

				for (Integer key : keys) {
					java.util.ArrayList<Integer> value = hashMap.get(key);
					if (value.contains(target1)) {
						if (!set.add(key)) {
							// add duplicate root found.
							commonRoot = key;
							isBreak = true;
						}
						target1 = key;

						break;
					}

					if (value.contains(target2)) {
						if (!set.add(key)) {
							// add duplicate root found.
							commonRoot = key;
							isBreak = true;
						}
						target2 = key;
						break;
					}
				}

			}
			// System.out.println("common root :: " + commonRoot);
			// childcount
			java.util.Stack<Integer> keyTemp = new java.util.Stack<Integer>();
			keyTemp.push(commonRoot);
			int count = 1;
			while (!keyTemp.isEmpty()) {
				// for(Integer keys : keyTemp)
				// {
				Integer key = keyTemp.pop();
				java.util.ArrayList<Integer> list = hashMap.get(key);
				if (list != null) {
					count += list.size();
					keyTemp.addAll(list);
				}
				// }
			}

			// System.out.println("count :: " + count);
			System.out.println("#" + t1 + ": " + commonRoot + " " + count);
		}

	}
}
