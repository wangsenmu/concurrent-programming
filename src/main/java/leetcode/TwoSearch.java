package leetcode;

public class TwoSearch {


    public static void main(String[] args) {

        int arr[] = {1, 3, 6, 9, 51, 54, 65, 78, 88};
        int target = 6;
        int index = new TwoSearch().search(arr, target);

    }

    public int search(int arr[], int target) {

        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (arr[leftIndex] <= arr[rightIndex]) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (arr[midIndex] == target) {
                return midIndex;
            } else if (arr[midIndex] < target) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }

        return 0;

    }


}
