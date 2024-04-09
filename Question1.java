// Given an unbounded array (an array whose length cannot be figured out), 
//that only contains positive integers and -1. After a certain index x, all the elements are -1. Find this index x.

// Input eg: 3, 4, 1, 2, 7, 8, 20, 33, -1, -1, -1, -1, …….
// Output: 8

// Input eg: -1, -1, -1, -1,.....
// Output:0


public class Question1 {

    public static int getIndex(int[] arr) {
        int start = 0, end = 1;
        while (arr[end] != -1) {
            start = end;
            end *= 2;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 7, 8, 20, 33, -1, -1, -1, -1};

        int index = getIndex(arr);

        if (index != -1) {
            System.out.println("Index x where all elements from that index are -1: " + index);
        } else {
            System.out.println("Index x not found!");
        }
    }
}