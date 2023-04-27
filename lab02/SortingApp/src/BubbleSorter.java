import java.util.ArrayList;

public class BubbleSorter implements Sorter{
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = input.size() - 1; j > i; j--) {
                if (input.get(j - 1) > input.get(j)) {
                    int tmp = input.get(j - 1);
                    int tmp2 = input.get(j);
                    input.set((j-1), tmp2);
                    input.set(j, tmp);
                }
            }
        }
        return input;
    }
}
