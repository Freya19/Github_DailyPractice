package gepeng18.test;

public class printOddAndEven {
    int i=0;



    // 0 2 4 6 8 10
    public void printOdd(){
        System.out.println(i);
        i++;
    }

    // 1 3 5 7 9
    public void printEven(){
        System.out.println(i);
        i++;
    }

    public static void main(String[] args) {
        printOddAndEven printOddAndEven = new printOddAndEven();
        while(printOddAndEven.i<10){
            printOddAndEven.printOdd();
            printOddAndEven.printEven();
        }
    }
}
