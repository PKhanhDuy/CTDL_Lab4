package lab_4;

import java.awt.desktop.SystemSleepEvent;
import java.util.Random;

public class Sort {
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

//seletionSort
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

//bubble sort
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

//insertionSort
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j > 0 && temp < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}

//quickSort
	public static void quickSort(int[] arr) {
		quickSortSupport(arr, 0, arr.length - 1);
	}

	public static void quickSortSupport(int[] arr, int start, int end) {
		if (start > end)
			return;
//		int pivot = getPivot_last(arr, start, end);
		int pivot = getPivot_first(arr, start, end);
//		int pivot = getPivot_MedianOfThree(arr, start, end);
//		int pivot = getPivot_Random(arr, start, end);

		quickSortSupport(arr, start, pivot - 1);
		quickSortSupport(arr, pivot + 1, end);
	}

//get pivot last
	public static int getPivot_last(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		i++;
		swap(arr, end, i);
		return i;
	}

//get pivot first
	public static int getPivot_first(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = end + 1;
		for (int j = end; j >= start; j--) {
			if (arr[j] > pivot) {
				i--;
				swap(arr, i, j);
			}
		}
		i--;
		swap(arr, start, i);
		return i;
	}

// get pivot media of three
	public static int getPivot_MedianOfThree(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		int pivot = arr[mid];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		i++;
		for (int t = end; t > i; t--) {
			arr[t] = arr[t - 1];
		}
		arr[i] = pivot;
		return i;
	}

	
	// chưa làm xong
	// get pivot radom
	public static int getPivot_Random(int[] arr, int start, int end) {
		int index = 0;
		Random rand = new Random();
		index = rand.nextInt(start, end);

		int pivot = arr[index];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (j != index) {
				if (arr[j] < pivot) {
					i++;
					swap(arr, i, j);
				}
			}
		}

		if (index <= i) {
			swap(arr, index, i);
		} else {
			swap(arr, index, i + 1);

		}
		return i;
	}

//	public static int rand(int start, int end) {
//		Random rand = new Random();
//		return rand.nextInt(start, end);
//	}

	public static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = arr[m + 1 + i];
		}
		// merge the temp arrays

		int i = 0;
		int j = 0;
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
		// copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		// copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}

	}

	public static void sort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			sort(arr, l, mid);
			sort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 2, 5, 2, 1, 1, 4 };
//		selectionSort(arr);
//		bubbleSort(arr);
//		insertionSort(arr);
		quickSort(arr);
//		mergeSort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}
}
