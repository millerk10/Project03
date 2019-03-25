import java.util.PriorityQueue;

public class Main2 {

    public static void main(String[] args) {
        RandomAddresses RandomList = new RandomAddresses();
        RandomList.GenerateAddresses();
        ReadAddresses.TimePriority();
        PriorityQueue<ReadAddresses> queue = new PriorityQueue<>();
        TruckRoute truckRoute = new TruckRoute();


            GUI gui = new GUI(truckRoute);



        TruckRoute.Main();
    }
}
