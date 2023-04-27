import java.util.ArrayList;

public class MergeSorter implements Sorter{
    ArrayList<Integer> res;
    public ArrayList<Integer> sort(ArrayList<Integer> input){
        res = input;
        divide (0, res.size() - 1);
        return res;
    }

    public void divide(int start, int end){
        if (start < end && (end - start) >= 1){
            int middle = (start + end) / 2;
            divide(start, middle);
            divide(middle + 1, end);
            merge(start, middle, end);
        }
    }

    public void merge(int start, int middle, int end){
        ArrayList<Integer> temp = new ArrayList<>();

        int ind1 = start;
        int ind2 = middle + 1;

        while(ind1 <= middle && ind2 <= end){
            if (res.get(ind1) <= res.get(ind2)){
                temp.add(res.get(ind1));
                ind1++;
            }
            else{
                temp.add(res.get(ind2));
                ind2++;
            }
        }
        while(ind1 <= middle){
            temp.add(res.get(ind1));
            ind1++;
        }
        while(ind2 <= end){
            temp.add(res.get(ind2));
            ind2++;
        }
        for(int i = 0; i < temp.size(); start++){
            res.set(start, temp.get(i++));
        }
    }
}
