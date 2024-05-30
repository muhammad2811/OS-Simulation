public class Priority {
    public String name;
    public int arrivalTime;
    public int burstTime;
    public int priority;
    public int starvation;
    public double waitingTime;
    public double workedTime;

    public Priority(){
        waitingTime=0;
        workedTime=0;
    }

    public Priority(String name,int arrivalTime,int burstTime,int priority){
        this.name=name;
        this.arrivalTime=arrivalTime;
        this.burstTime=burstTime;
        this.priority=priority;
        starvation=3;
    }

      public double getWaitingTime(){
        return waitingTime;
    }
      public double getTurnaroundTime(){
        return (waitingTime+workedTime);
    }
}
