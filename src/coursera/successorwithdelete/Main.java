package coursera.successorwithdelete;

public class Main {
    public static void main(String[] args) {

        SuccessorWithDelete successorWithDelete = new SuccessorWithDelete(10);

        successorWithDelete.remove(3);
        successorWithDelete.remove(4);
        successorWithDelete.remove(5);

        System.out.println(successorWithDelete.successor(3));
        System.out.println(successorWithDelete.successor(2));

        successorWithDelete.remove(6);
        System.out.println(successorWithDelete.successor(3));

        successorWithDelete.remove(7);
        System.out.println(successorWithDelete.successor(3));
    }
}
