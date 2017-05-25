
public class lab1 {

	public static void main(String[] args) {
		int key=4;
		int[] list = {1, 4, 4, 2, 5, -3, 6, 2};
		int[] list2 = {1,2,3,4,5};
		int result = linearSearch(list,key);
		System.out.println(result);
		int i = linearSearch(list, 2);
		System.out.println(i);
		int result2 =binarySearch(list2,key);
		System.out.println(result2);
		
	}
		
		public static int linearSearch(int[] list, int key) {

			 for (int i = 0; i < list.length; i++)

			 if (key == list[i])

			 return i;

			 return -1;

			}
	
		public static int binarySearch(int[] list, int key)

		{

		 int low = 0;
		 int high = list.length - 1;
		 while (high >= low) {
		 int mid = (low + high) / 2;
		 if (key < list[mid])
		 high = mid - 1;
		 else if (key == list[mid])
		 return mid;
		 else
		 low = mid + 1;
		 }
		 return -1 - low;
		}
		
	
	}

