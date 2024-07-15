#include <iostream>
#include <random>
#include <ctime>

using namespace std;

void quickSort(int arr[], int size);
void quickSort(int arr[], int low, int high);
void swap(int arr[], int idx1, int idx2);

int main() {
  int arr[] = {5, 78, 22, 23, 65, 1, 45, 35, 67, 22};
  int size = sizeof(arr) / sizeof(arr[0]);
  quickSort(arr, size);
  for(int i: arr) {
    cout << i << " ";
  }
  return 0;
}

void quickSort(int arr[], int size) {
  quickSort(arr, 0, size-1);
}

void swap(int arr[], int idx1, int idx2) {
  int temp = arr[idx1];
  arr[idx1] = arr[idx2];
  arr[idx2] = temp;
}

void quickSort(int arr[], int low, int high) {
  if(low >= high) {
    return;
  }
  srand(time(NULL));
  int pivotIndex = low + rand() % (high-low+1);
  swap(arr, pivotIndex, high);
  int pivot = arr[high];
  int lp = low;
  int rp = high;

  while(lp < rp) {
    while(arr[lp] <= pivot && lp < rp) {
      lp++;
    }
    while(arr[rp] >= pivot && lp < rp) {
      rp--;
    }
    swap(arr, lp, rp);
  }
  swap(arr, lp, high);
  quickSort(arr, low, lp-1);
  quickSort(arr, lp+1, high);
}
