package bit;

public class NumberofStepstoReduceaNumbertoZero {



    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        int obt=num%2;
        int res=num/2;
        return obt + 1 + numberOfSteps(res);
    }

    public static void main(String[] args) {
        NumberofStepstoReduceaNumbertoZero obj=new NumberofStepstoReduceaNumbertoZero();
        assert obj.numberOfSteps(14)==6;
        assert obj.numberOfSteps(8)==4;
    }
}
