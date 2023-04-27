import java.util.ArrayList;

public class QuickSorter implements Sorter{
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        ArrayList<Integer> res = quick(input, 0, input.size() - 1);
        return res;
    }
    public ArrayList<Integer> quick(ArrayList<Integer> input, int start, int end){
        if(input.size() == 0 || start >= end){
            return input;
        }

        int middle = start + (end - start) / 2;
        int border = input.get(middle);

        int i = start;
        int j = end;

        while(i <= j){
            while (input.get(i) < border){
                i++;
            }
            while (input.get(j) > border){
                j--;
            }
            if (i <= j){
                int tmp = input.get(i);
                input.set(i, input.get(j));
                input.set(j, tmp);
                i++;
                j--;
            }
        }

        if (start < j){
            quick(input, start, j);
        }
        if (end > i){
            quick(input, i, end);
        }

        return input;
    }
}
