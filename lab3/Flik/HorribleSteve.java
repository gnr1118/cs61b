public class HorribleSteve {
    public static void main(String [] args) {
        for (int i = 0, j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                System.out.println("i is " + i);
                break;
            }
        }
    }
}
