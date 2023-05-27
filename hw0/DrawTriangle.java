public class DrawTriangle {
    public static void main(String[] args) {
        drawTriangle(10);
    }

    private static void drawTriangle(int size) {
        for (int row = 1; row <= size ;row++) {
            for (int col = 1; col < row ;col++) {
                System.out.print('*');
            }
            System.out.println('*');
        }
    }
}