import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListWorkCheck {

    public static void main (String[] args){
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        int count = 200000;
        int amount = 1000;

        arrayList = fill(arrayList, count, "ArrayList");
        linkedList = fill(linkedList, count, "LinkedList");

        random_access(arrayList, count, "ArrayList");
        random_access(linkedList, count, "LinkedList");

        sequential_access(arrayList, count, "ArrayList");
        sequential_access(linkedList, count, "LinkedList");

        arrayList = begin_insert(arrayList, count, amount, "ArrayList");
        linkedList = begin_insert(linkedList, count, amount, "LinkedList");

        arrayList = end_insert(arrayList, count, amount, "ArrayList");
        linkedList = end_insert(linkedList, count, amount, "LinkedList");

        arrayList = middle_insert(arrayList, count, amount, "ArrayList");
        linkedList = middle_insert(linkedList, count, amount, "LinkedList");
    }

    private static List<Integer> fill(List<Integer> list, int count, String listType){
        long time = System.currentTimeMillis();
        int min = 0;
        int max = count;
        int rand_num;
        for (int i = 0; i < count; i++){
            rand_num = min + (int) (Math.random() * max);
            list.add(rand_num);
        }
        System.out.printf("Fill %s: %s\n", listType, System.currentTimeMillis() - time);
        return list;
    }

    private static void random_access(List<Integer> list, int count, String listType){
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++){
            list.get(i);
        }
        System.out.printf("Random access in %s: %s\n", listType, System.currentTimeMillis() - time);
    }

    private static void sequential_access(List<Integer> list, int count, String listType){
        long time = System.currentTimeMillis();
        for (Iterator i = list.iterator(); i.hasNext();){
            i.next();
        }
        System.out.printf("Sequental access in %s: %s\n", listType, System.currentTimeMillis() - time);
    }

    private static List<Integer> begin_insert(List<Integer> list, int count, int amount, String listType){
        long time = System.currentTimeMillis();
        int min = 0;
        int max = count;
        int rand_num;
        for (int i = 0; i < amount; i++){
            rand_num = min + (int) (Math.random() * max);
            list.add(i, rand_num);
        }
        System.out.printf("Insert at the beginning of %s: %s\n", listType, System.currentTimeMillis() - time);
        return list;
    }

    private static List<Integer> end_insert(List<Integer> list, int count, int amount, String listType){
        long time = System.currentTimeMillis();
        int min = 0;
        int max = count;
        int rand_num;
        for (int i = count - amount; i < count; i++){
            rand_num = min + (int) (Math.random() * max);
            list.add(i, rand_num);
        }
        System.out.printf("Insert at the end of %s: %s\n", listType, System.currentTimeMillis() - time);
        return list;
    }

    private static List<Integer> middle_insert(List<Integer> list, int count, int amount, String listType){
        long time = System.currentTimeMillis();
        int min = 0;
        int max = count;
        int rand_num;
        int start = ((count / 2) - ((amount / 2) - 1)) - 1;
        int end = ((count / 2) + (amount / 2));
        for (int i = start; i < end; i++){
            rand_num = min + (int) (Math.random() * max);
            list.add(i, rand_num);
        }
        System.out.printf("Insert in the middle of %s: %s\n", listType, System.currentTimeMillis() - time);
        return list;
    }
}
