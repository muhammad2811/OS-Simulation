import java.util.ArrayList;
public class Opiration extends Priority {
     double sumWait,sumTurnaround;
      int numpro;
      double numprod;

    public Opiration(){
        sumWait=0;
        sumTurnaround=0;
    }

     public Opiration(int num){
        numpro=num;
        numprod=num;
    }

    static ArrayList<String> proOrder = new ArrayList<String>();
    static ArrayList<Double> proWait = new ArrayList<Double>();
    static ArrayList<Double> proTurnaround = new ArrayList<Double>();


     static public void setProOrder(String s){
         proOrder.add(s);
    }

    public void setProWait(double w){
        proWait.add(w);
        sumWait+=w;
    }
    public void setProTurnaround(double t){
        proTurnaround.add(t);
        sumTurnaround+=t;
    }

    public  void printOrders(){
        for (int k = 0; k < proOrder.size(); k++) {
            System.out.println((k+1)+":"+proOrder.get(k));
        }
    }
    public  void printWaiting(){
        for (int k = 0; k < proWait.size(); k++) {
            System.out.println("p"+(k+1)+":"+proWait.get(k));
        }
    }
    public  void printTurnaround(){
        for (int k = 0; k < proTurnaround.size(); k++) {
            System.out.println("p"+(k+1)+":"+proTurnaround.get(k));
        }
    }

    public void print(){
        System.out.println("Process execution order");
        printOrders();
        System.out.println("Waiting time for each process");
        printWaiting();
        System.out.println("Turnaround time for each process");
        printTurnaround();
        System.out.println("Average waiting time");
        System.out.println(sumWait/numprod);
        System.out.println("Average turnaround time");
        System.out.println(sumTurnaround/numprod);
    }
}
