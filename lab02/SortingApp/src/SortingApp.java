import java.util.ArrayList;

public class SortingApp {
    public static void main (String[] args){
        ArrayList<Integer> input, sorted_list;
        for (int count: new int[]{10, 1000, 10000, 1000000}) {
            System.out.printf("\nAmount of elements in list: %s\n", count);
            input = generate_list(count);
            for (SortingType type: new SortingType[]{SortingType.BUBBLE, SortingType.SHELL, SortingType.MERGE, SortingType.QUICK}) {
                System.out.printf("\nSorting type: %s\n", type);
                Sorter sort_class = sort_type(type);
                sorted_list = sort_list(input, sort_class);
                print_list(sorted_list, "Sorted list");
            }
        }
    }

    public static Sorter sort_type (SortingType type){
        Sorter sort_class = null;
        switch (type){
            case BUBBLE: sort_class = new BubbleSorter(); break;
            case SHELL: sort_class = new ShellSorter(); break;
            case MERGE: sort_class = new MergeSorter(); break;
            case QUICK: sort_class = new QuickSorter(); break;
        }
        return sort_class;
    }

    public static ArrayList<Integer> generate_list (int amount){
        int min = 0;
        int max = amount;
        int rand_num;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < amount; i++){
            rand_num = min + (int) (Math.random() * max);
            list.add(rand_num);
        }
        print_list(list, "Generated list");
        return list;
    }

    public static ArrayList<Integer> sort_list (ArrayList<Integer> list, Sorter sort_class){
        long time = System.currentTimeMillis();
        ArrayList<Integer> sorted_list;
        sorted_list = sort_class.sort(list);
        System.out.printf("%s in: %s\n", sort_class.getClass().getSimpleName(), System.currentTimeMillis() - time);
        return sorted_list;
    }

    public static void print_list (ArrayList<Integer> list, String list_type){
        System.out.printf(list_type + ":\n");
        if (list.size() <= 100){
            for (int i = 0; i < list.size(); i++){
                System.out.printf(list.get(i) + "\t");
            }
        }
        else {
            System.out.printf("First 50 elements:\n");
            for (int i = 0; i < 50; i++){
                System.out.printf(list.get(i) + "\t");
            }
        }
        System.out.printf("\n");
    }
}
