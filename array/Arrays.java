public class Arrays {
    public static int[] insert(int[] arr, int item, int position) {
        int[] result = new int[arr.length + 1];
        position = Math.min(arr.length, position);
        for (int i = 0; i < position ;i++) {
            result[i] = arr[i];
        }
        result[position] = item;
        for (int i = position; i < arr.length ;i++) {
            result[i + 1] = arr[i];
        }
        return result;
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2 ;i++) {
            int j = arr.length - 1 - i;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static int[] replicate(int[] arr) {
        int total = 0;
        for (int item : arr) {
            total += item;
        }
        int[] result = new int[total];
        int i = 0;
        for (int item : arr) {
            for (int counter = 0; counter < item ;counter++) {
                result[i] = item;
                i++;
            }
        }
        return result;
    }

    public static int[] flatten(int[][] x) {
        int total = 0;
        for (int i = 0; i < x.length ;i++) {
            total += x[i].length;
        }
        int[] result = new int[total];
        int i = 0;
        for (int[] subArr : x) {
            for (int e : subArr) {
                result[i++] = e;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = insert(arr, 100, 6);
        System.out.println(newArr.length);

        reverse(arr);
        System.out.println(arr.length);

        int[] replicated = replicate(arr);
        System.out.println(replicated.length);

        int[][] _2dArr = {{1, 2, 3}, {}, {7, 8}};
        int[] flatten = flatten(_2dArr);
        System.out.println(flatten.length);

        boolean arrayEquals = arrayEquals(
                new Integer[]{1, 2, 3},
                new Integer[][]{{1, 2, 3}, {2, 3, 4}, {3, 4, 5}}
        );
        System.out.println(arrayEquals);
    }

    public static boolean arrayEquals(Object[] a1, Object[] a2) {
        if (a1.length != a2.length) {
            return false;
        }

        for (int i = 0; i < a1.length ;i++) {
            if (a1[i].getClass().isArray() && a2[i].getClass().isArray()) {
                if (!arrayEquals((Object[]) a1[i], (Object[]) a2[i])) {
                    return false;
                }
            } else {
                if (!a1[i].equals(a2[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
