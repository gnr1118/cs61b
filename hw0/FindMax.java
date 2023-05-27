public class FindMax {
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }

    private static int max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length ;i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}