public class SumAB {
    public int execute(int a, int b){
        if(b == 0) {
            return a;
        }
        
        return execute(a + 1, b - 1);
    }
}
