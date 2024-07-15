import java.util.Random;
public class MergeSort {

  public static void printintArray(int[] arr) {
    for (int i : arr) {
      System.out.println(i);
    }
  }

  public static void mergeSort(int[] arr) {

    if(arr == null || arr.length <= 1) {
      return;
    }

    int size = arr.length;
    int midpoint = size / 2;

    int[] leftarr = new int[midpoint];
    int[] rightarr = new int[size - midpoint];

    for(int i = 0; i < midpoint; i++) {
      leftarr[i] = arr[i];
    }
    for(int j = midpoint; j < size; j++) {
      rightarr[j - midpoint] = arr[j];
    }

    mergeSort(leftarr);
    mergeSort(rightarr);

    merge(arr, leftarr, rightarr);
  }

  public static void merge(int[] arr, int[] leftarr, int[] rightarr) {
    int i = 0;
    int j = 0;
    int k = 0;
    while(i < leftarr.length && j < rightarr.length) {
      if(leftarr[i] <= rightarr[j]) {
        arr[k] = leftarr[i];
        i++;
      }
      else {
        arr[k] = rightarr[j];
        j++;
      }
      k++;
    }
    while(i < leftarr.length) {
      arr[k] = leftarr[i];
      i++;
      k++;
    }
    while(j < rightarr.length) {
      arr[k] = rightarr[j];
      j++;
      k++;
    }
  }

  public static void main(String[] args) {
    int size = 1000000;
    int[] arr = new int[size];
    Random rand = new Random();
    for (int i = 0; i < size; i++) {
      arr[i] = rand.nextInt(0, 10000000);
    }
    mergeSort(arr);
    printintArray(arr);
  }
}
