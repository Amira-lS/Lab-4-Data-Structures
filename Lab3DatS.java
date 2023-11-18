
package lab3dats;
import java.util.Random;
import java.util.Scanner;
public class Lab3DatS {

   
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        int[] array = null;
        int arraySize = 0;
        int choice = 0;
        
        while (choice != 4) {
            System.out.println("1) Merge sort algorithm.");
            System.out.println("2) Insertion sort algorithm.");
            System.out.println("3) Print output.");
            System.out.println("4) Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    arraySize = 0;
                    System.out.println("---------------Merge Sort Result---------------");
                    System.out.println("   Array Size\tExecution Time");
                    for (int i = 0; i < 3; i++) {
                        arraySize += 100000;
                        array = generateRandomArray(arraySize);
                        int[] tempArray = new int[arraySize];
                        long startTime1 = System.nanoTime();
                        mergeSort(array, tempArray, 0, arraySize - 1);
                        long endTime1 = System.nanoTime();
                        System.out.println(arraySize + "\t" + (endTime1 - startTime1));
                    }
                    break;
                case 2:
                    arraySize = 0;
                    System.out.println("---------------Insertion Sort Result---------------");
                    System.out.println("   Array Size\tExecution Time");
                    for (int i = 0; i < 3; i++) {
                        arraySize += 100000;
                        array = generateRandomArray(arraySize);
                        long startTime = System.nanoTime();
                        insertionSort(array);
                        long endTime = System.nanoTime();
                        System.out.println(arraySize + "\t" + (endTime - startTime));
                    }
                    break;
                case 3:
                    for (int i = 0; i < arraySize; i++) {
                        System.out.print(array[i] + " , ");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3000);
        }
        return arr;
    }

    public static void insertionSort(int array[]) {
        int i, j, k, temp;

        for (i = 1; i < array.length; i++) {
            temp = array[i];
            for (j = 0; j < i; j++) {
                if (array[j] > temp) {
                    break;
                }
            }
            for (k = i; k > j; k--) {
                array[k] = array[k - 1];
            }
            array[j] = temp;
        }
    }

    public static void mergeSort(int[] array, int temp[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);
            merge(array, temp, left, mid + 1, right);
        }
    }

    public static void merge(int[] array, int[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos] <= array[rightPos]) {
                tempArray[tempPos++] = array[leftPos++];
            } else {
                tempArray[tempPos++] = array[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tempArray[tempPos++] = array[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tempArray[tempPos++] = array[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = tempArray[rightEnd];
        }
    }
}
    

