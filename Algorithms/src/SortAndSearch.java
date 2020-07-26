import java.util.Arrays;

public class SortAndSearch {

	public static void main(String[] args) {

		SortAndSearch sort = new SortAndSearch();

		/** Selection Sort */
		int[] arr1 = { 3, 2, 6, 7, 3, 8, 9, 12, 2, 1, 0, 4, 2 };
		System.out.println("Before Selection Sort");
		sort.print(arr1);
		arr1 = sort.selectionSort(arr1);
		System.out.println("After Selection Sort");
		sort.print(arr1);

		/** Insertion Sort */
		/** int[] arr2 = {3,2,6,7,3,8,9,12,2,1,0,4,2};
		 * System.out.println("\nBefore Insertion Sort"); sort.print(arr2); arr2 =
		 * sort.insertionSort(arr2); System.out.println("After Insertion Sort");
		 * sort.print(arr2); */

		/** Merge Sort */
		int[] arr3 = { 2, 1, 4, 2, 22, 12, 5, 32, 44, 22, 31, 11, 10, 0 };
		System.out.println("\nBefore Merge Sort");
		sort.print(arr3);
		arr3 = sort.mergeSort(arr3, 0, arr3.length - 1);
		System.out.println("After Merge Sort");
		sort.print(arr3);

		/** Quick Sort */
		 int[] arr4 = {5,112,71,0, 4,7,57,2, 4,2,312,1, 1};
		 System.out.println("\n**Before Quick Sort"); sort.print(arr4); 
		 arr4 = sort.quickSort(arr4, 0, arr4.length-1);
		 System.out.println("After Quick Sort"); sort.print(arr4); 

		/** Given two sorted arrays merge the two in sorted order */
		/** System.out.println("\nMerge Two Arrays"); int[] arr4 = {5, 112, 71, 0, 4, 7,
		 * 57, 2, 4, 2, 312, 1, 0}; int[] arr3 = {2, 1, 4, 2, 22, 12, 5, 32, 44, 22, 31,
		 * 11, 10}; arr4 = sort.selectionSort(arr4); sort.print(arr4); arr3 =
		 * sort.selectionSort(arr3); sort.print(arr3); int[] arr5 = sort.mergeTwo(arr4,
		 * arr3); sort.print(arr5); */

		String[] someStrings = { "this", "god", "reeb", "sith", "dog", "beer" };
		/** for(int i = 0; i < someStrings.length; i++) {
		 * System.out.print(someStrings[i]+", "); } System.out.println(); */
		someStrings = sort.stringAnagram(someStrings);
		for (int i = 0; i < someStrings.length; i++) {
			System.out.print(someStrings[i] + ", ");
		}
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

	/** Switch values at given index, if second is less than the first */
	public int[] selectionSort(int[] arr) {

		int min = 0, temp = 0;

		for (int i = 0; i < arr.length; i++) {
			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}

	public int[] insertionSort(int[] arr) {

		int key = 0, i = 0, j = 0;

		for (i = 1; i < arr.length; ++i) {
			key = arr[i];
			j = i - 1;
			/** Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

	public static void mergeSort2(int[] a, int n) {
		
		if (n < 2)
			return;
		
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort2(l, mid);
		mergeSort2(r, n - mid);

		merge2(a, l, r, mid, n - mid);
	}

	public static void merge2(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;

		while (i < left && j < right) {
			if (l[i] <= r[j])
				a[k++] = l[i++];
			else
				a[k++] = r[j++];
		}

		while (i < left)
			a[k++] = l[i++];

		while (j < right)
			a[k++] = r[j++];
	}

	/**
	 * Merges two subarrays of arr[]. First subarray is arr[l..m]. Second subarray
	 * is arr[m+1..r]
	 */
	public void merge(int arr[], int l, int m, int r) {

		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = arr[m + 1 + j];
		}

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;

			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using merge()
	public int[] mergeSort(int arr[], int l, int r) {

		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
		return arr;
	}

	/** Quick Sort */
	public int[] quickSort(int[] arr, int low, int high) {

		if (low < high) {
			/* pi is partitioning index, arr[pi] is now at right place */
			int pi = partition(arr, low, high);

			// Recursively sort elements before partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
		return arr;
	}

	/**
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	public int partition(int arr[], int low, int high) {

		int pivot = arr[high];
		int i = (low - 1); // index of smaller element

		for (int j = low; j < high; j++) {

			// If current element is smaller than or equal to pivot
			if (arr[j] <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	/** Merge two Arrays */
	public int[] mergeTwo(int[] arr1, int[] arr2) {

		int merged = arr1.length + arr2.length;
		int[] arr3 = new int[arr1.length + arr2.length];
		int len1 = arr1.length - 1;
		int len2 = arr2.length - 1;

		merged--;
		while (len1 >= 0 && len2 >= 0) {
			if (len1 >= 0 && arr1[len1] > arr2[len2]) {
				arr3[merged] = arr1[len1];
				len1--;
			} else {
				arr3[merged] = arr2[len2];
				len2--;
			}
			System.out.print("- " + arr3[merged]);
			merged--;
		}

		System.out.println();
		return arr3;
	}

	public String[] stringAnagram(String[] arr) {

		String[] arr2 = new String[arr.length];
		int[] arr3 = new int[arr.length];
		int index = 0, count = 0, j = 0;

		for (int i = 0; i < arr.length; i++) {

			char[] first = arr[i].toCharArray();
			Arrays.sort(first);

			String a = new String(first);
			System.out.println("Sorted String = " + a);
			if (arr3[count] < 1) {
				arr2[index++] = a;
				arr3[count] = 1;
			}

			char[] second;

			for (j = i + 1; j < arr.length; j++) {

				second = arr[j].toCharArray();
				Arrays.sort(second);
				count = j;

				if (Arrays.equals(first, second) && arr3[count] < 1) {
					String b = new String(second);
					arr2[index++] = b;
					arr3[count] = 1;
				}
			}
		}
		return arr2;
	}

}