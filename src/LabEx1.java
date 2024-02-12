// Mendoza, Kyran Xandre O. & Teneza, Lawrence Patrick P.// ICS2605 1CSA// Lab Exercise 1// The program is an implementation of the requirements for LabEx1//import java.util.Scanner;import java.util.Random;public class LabEx1 {    static Scanner s = new Scanner(System.in);    static Random rand = new Random();    public static void main(String[] args) {        System.out.println("Mendoza, Kyran Xandre O.");        System.out.println("Teneza, Lawrence Patrick P.");        System.out.println();        System.out.print("Input a positive integer t: ");        int t = s.nextInt();        long start, end;        long ans;        if (t < 1 || t > 7)            return;        switch (t) {            case 1:            case 2:                System.out.print("Input a positive integer n: ");                int n = s.nextInt();                if (t == 1) {                    start = System.nanoTime();                    ans = fib(n);                    end = System.nanoTime();                } else {                    start = System.nanoTime();                    ans = fibR(n);                    end = System.nanoTime();                }                System.out.println("call fib" + (t == 2 ? "R" : "") + "(int n) with arg " + n);                System.out.println("return value = " + ans);                System.out.printf("Elapsed Time : %,d ms", ((end - start) * 1000_000));                break;            case 3:            case 4:                System.out.print("Input array length n : ");                n = s.nextInt();                System.out.print("Input left (lower) bound  (zero-index): ");                int left = s.nextInt();                System.out.print("Input right (higher) bound (zero-index): ");                int right = s.nextInt();                int arr[] = new int[n];                for (int i = 0; i < arr.length; i++) {                    arr[i] = rand.nextInt(1000);                }                System.out.printf("%s called from index %d to %d\n", t == 3 ? "shuffleR()" : "insertionSort()", left,                        right);                System.out.println("Dumping array content pre : ");                for (int j = 0; j < arr.length; j++) {                    System.out.print(arr[j] + " ");                }                System.out.println();                if (t == 3) {                    start = System.nanoTime();                    shuffleR(arr, left, right);                    end = System.nanoTime();                } else {                    start = System.nanoTime();                    insertionSort(arr, left, right);                    end = System.nanoTime();                }                System.out.println("Dumping array content post : ");                for (int j = 0; j < arr.length; j++) {                    System.out.print(arr[j] + " ");                }                System.out.println();                System.out.printf("Elapsed Time : %,d ms", ((end - start) * 1000_000));                break;            case 5:            case 6:            case 7:                System.out.print("Input max time n (in seconds) : ");                n = s.nextInt();                long maxTime = n;                long currentTime = 0;                if (t == 5) {                    long startTime = System.nanoTime();                    for (int k = 1; currentTime < maxTime; k++) {                        System.out.print("k = " + k);                        fibR(k);                        System.out.println(";");                        currentTime = (System.nanoTime() - startTime) / 1_000_000_000;                    }                    break;                }                int[] veryLargeArray = new int[(int)Math.pow(2, 28)];                if (t == 6) {                    long startTime = System.nanoTime();                    for (int k = 1; currentTime < maxTime; k++) {                        for (int i = 0; i < k; i++) {                            veryLargeArray[i] = rand.nextInt(10000);                        }                        System.out.print("k = " + k);                        shuffleR(veryLargeArray, 0, k - 1);                        System.out.println(";");                        currentTime = (System.nanoTime() - startTime) / 1000_000_000;                    }                    break;                }                if (t==7) {                    long startTime = System.nanoTime();                    for (int k = 1; currentTime < maxTime; k++) {                        for (int i = 0; i < k; i++) {                            veryLargeArray[i] = rand.nextInt(10000);                        }                        System.out.print("k = " + k);                        insertionSort(veryLargeArray, 0, k - 1);                        System.out.println(";");                        currentTime = (System.nanoTime() - startTime) / 1000_000_000;                    }                    break;                }        }    }    static void insertionSort(int[] arr, int left, int right) {        for (int i = left + 1; i <= right; i++) {            int current = arr[i];            int j = i - 1;            while (j >= 0 && current < arr[j]) {                arr[j + 1] = arr[j];                j--;            }            arr[j + 1] = current;        }    }    static void shuffleR(int[] arr, int left, int right) {        if (right - left <= 1)            return;        int index = left + rand.nextInt(right - left + 1);        int temp = arr[index];        arr[index] = arr[right];        arr[right] = temp;        shuffleR(arr, left, right - 1);    }    static long fib(int n) {        if (n <= 0)            return 1;        int pprev, prev = 0, curr = 1;        for (int i = 1; i < n; i++) {            pprev = prev;            prev = curr;            curr += pprev;        }        return curr;    }    static long fibR(int n) {        if (n <= 0)            return 1;        return fibR(n - 1) + fibR(n - 2);    }}