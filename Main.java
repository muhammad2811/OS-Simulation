import java.util.Scanner;
public class Main extends Opiration {

     static public int bestPriority(Priority arrPro[],int proSearch){
        int selectPriority=1000;
        for (int i = 0; i <=proSearch ; i++) {
            if(arrPro[i].priority<selectPriority){
                selectPriority=arrPro[i].priority;
            }
        }
         int i;
         for (i = 0; i <=proSearch ; i++) {
             if(selectPriority==arrPro[i].priority)
                 break;
         }
         return i;
    }
    public static void main(String[] args) {

        Scanner myObjI = new Scanner(System.in);
        Scanner myObjS = new Scanner(System.in);

        //set data of process
        System.out.println("Enter number of processes");
        int numPro = myObjI.nextInt();
        Priority arrPro[]=new Priority[numPro];
        int steps=0;
        for (int i=0;i<numPro;i++){
            System.out.println("Enter name of processes");
            String namePro = myObjS.nextLine();
            System.out.println("Enter arrival time of processes");
            int arrivalTime = myObjI.nextInt();
            System.out.println("Enter burst time of processes");
            int burstTime = myObjI.nextInt();
            System.out.println("Enter priority of processes");
            int priority = myObjI.nextInt();
            arrPro[i]=new Priority(namePro,arrivalTime,burstTime,priority);
            steps+=burstTime;
        }

        //algorithm of priority scheduling
        int goalRun;
        for (int i = 0,processesCome=0; i <steps ; i++) {
            goalRun=bestPriority(arrPro,processesCome);
            for (int k = 0; k <= processesCome; k++) {
                if (k==goalRun){
                    arrPro[k].burstTime--;
                    setProOrder(arrPro[k].name);
                    arrPro[k].workedTime++;
                    if (arrPro[k].burstTime==0){
                        arrPro[k].priority=1000;
                    }
                }
                else {
                    arrPro[k].starvation--;
                    if (arrPro[k].starvation==0){
                        arrPro[k].starvation=3;
                        arrPro[k].priority--;
                        if (arrPro[k].priority==0)
                            arrPro[k].priority=1;
                    }
                    if (arrPro[k].priority<500)
                        arrPro[k].waitingTime++;
                }
            }
            if (processesCome!=numPro-1&&i+1==arrPro[processesCome+1].arrivalTime){
                processesCome++;
            }
        }
        Opiration O=new Opiration(numPro);
        for (int k = 0; k < numPro; k++) {
            O.setProWait(arrPro[k].getWaitingTime());
            O.setProTurnaround(arrPro[k].getTurnaroundTime());
        }
        O.print();
    }
}