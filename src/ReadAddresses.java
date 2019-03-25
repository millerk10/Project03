import java.io.*;
//import java.util.Scanner;
import java.util.PriorityQueue;
public class ReadAddresses {



    public static PriorityQueue TimePriority(){
        PriorityQueue<String> queue = new PriorityQueue<>();
        File file = new File("AddressList.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            String st;
            while ((st = reader.readLine()) != null){
                queue.add(st);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return queue;
    }
}