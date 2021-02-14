public class gearList {
	
	public static String[] add(String array[], String toAdd, int spot) {
		String list[] = new String[array.length + 1];
		for(int i = 0; i < spot; i++) {
			list[i] = array[i];
		}
		list[spot] = toAdd;
		for(int i = spot; i < array.length; i++) {
			list[i + 1] = array[i];
		}
		return list;
	}
	
	public static String[] remove(String array[], int toRemove) {
		String list[] = new String[array.length - 1];
		int counter = 0;
		for(int i = 0; i < array.length; i++) {
			if(i != toRemove) {
				list[counter] = array[i];
				counter++;
			}
		}
		return list;
	}
	
	public static String[] shuffle(String array[]) {
		int randomValues[] = new int[array.length];
		for(int i = 0; i < randomValues.length; i++) {
			for(;;) {
				boolean found = false;
				int random = (int)(Math.random() * randomValues.length) + 1;
				for(int h = 0; h < randomValues.length; h++) {
					if(random == randomValues[h]) {
						break;
					}
					if(h == randomValues.length-1) {
						found = true;
					}
				}
				if(found == true) {
					randomValues[i] = random;
					break;
				}
			}
		}
		String temp[] = new String[randomValues.length];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = array[randomValues[i] - 1];
		}
		for(int i = 0; i < temp.length; i++) {
			array[i] = temp[i];
		}
		return array;
	}
	
	public static String[] toStringArray(int array[]) {
		String list[] = new String[array.length];
		for(int i = 0; i < array.length; i++) {
			list[i] = array[i] + "";
		}
		return list;
	}

	public static void print(String array[]) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void printList(String array[]) {
		String printer = "";
		for(int i = 0; i < array.length; i++) {
			if(i == array.length - 1) {
				printer += array[i];
			} else {
				printer += array[i] + ", ";
			}
		}
		System.out.println(printer);
	}
	
	public static int min(int array[]) {
		int min = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
	
	public static int max(int array[]) {
		int max = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}