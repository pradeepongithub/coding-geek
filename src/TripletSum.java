import java.util.Arrays;

public class TripletSum {

    public static void main(String[] args) {

        String tripletSum = findTripletSum(0, new int[]{12,3,1,2,-6,5,-8,6});

        System.out.println("Triplet Sum :: " + tripletSum);

    }

    public static String findTripletSum(int targetSum, int... arrays) {

        int left, right, cs;
        StringBuilder triplet = new StringBuilder();

        Arrays.sort(arrays);

        for (int i = 0; i < arrays.length - 2; i++) {

            left = i + 1;
            right = arrays.length - 1;

            while (left < right) {
                cs = arrays[i] + arrays[left] + arrays[right];
                if (cs == targetSum) {
                    triplet.append("[" + arrays[i] + "," + arrays[left] + "," + arrays[right] + "],");
                    left++;
                    right--;
                } else if (cs < targetSum) {
                    left++;
                } else if (cs > targetSum) {
                    right--;
                }
            }


        }

        return triplet.toString();

    }
}
