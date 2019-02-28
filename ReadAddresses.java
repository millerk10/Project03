import java.util.Scanner;
import java.util.PriorityQueue;

public class ReadAddresses {

    public static void ReadAddresses() throws Exception{
        PriorityQueue<String> addresses = new PriorityQueue<String>();
        Scanner sc = new Scanner("AddressList.txt");
        while(sc.hasNextLine()){
            addresses.add(sc.nextLine());
        }
    }
}
