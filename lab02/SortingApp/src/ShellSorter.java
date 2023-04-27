import java.util.ArrayList;

public class ShellSorter implements Sorter{
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        int amount = input.size();
        for (int i = amount / 2; i > 0; i /= 2){
            for (int j = i; j < amount; j++){
                int temp = input.get(j);
                int k = j;
                while (k >= i && input.get(k - i) > temp){
                    input.set(k, input.get(k - i));
                    k -= i;
                }
                input.set(k, temp);
            }
        }
        return input;
    }
}
