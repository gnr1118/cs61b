public class IntListTest {
    public static void main(String[] args) {
        IntList intList = new IntList(15, null);
        intList = new IntList(10, intList);
        intList = new IntList(5, intList);

        System.out.println(intList.size());
        System.out.println(intList.iterativeSize());

        System.out.println(intList.get(0));
        System.out.println(intList.get(1));
        System.out.println(intList.get(2));

        System.out.println(intList.iterativeGet(0));
        System.out.println(intList.iterativeGet(1));
        System.out.println(intList.iterativeGet(2));

        IntList intListIncr3 = IntList.incrWithIteration(intList, 3);
        System.out.println(intListIncr3.get(0));
        System.out.println(intListIncr3.get(1));
        System.out.println(intListIncr3.get(2));

        IntList.incrMutativeWithIteration(intList, 3);
        System.out.println(intList.get(0));
        System.out.println(intList.get(1));
        System.out.println(intList.get(2));
    }
}