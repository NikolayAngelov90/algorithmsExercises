package coursera.unionfindmax;

public class Main {
    public static void main(String[] args) {

        UnionFindMax unionFindMax = new UnionFindMax(10);

        unionFindMax.union(1, 2);
        unionFindMax.union(2, 6);
        unionFindMax.union(6, 9);

        System.out.println(unionFindMax.find(1));
        System.out.println(unionFindMax.find(2));
        System.out.println(unionFindMax.find(6));
        System.out.println(unionFindMax.find(9));

        unionFindMax.union(4, 5);
        System.out.println(unionFindMax.find(4));

        unionFindMax.union(5, 8);
        System.out.println(unionFindMax.find(4));
    }
}
