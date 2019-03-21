/*
Created by Kimberly Miller on March 15th.
 */


import java.awt.*;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class TruckRoute extends ReadAddresses{

    public static LinkedList getCurrentRoute(){
        //DISTRIBUTION CENTER IS 910 SOUTH 9TH STREET
        String DistributionCenter = "10:00am 910 SOUTH 9 STREET";
        int count = 0;
        int blocks = 0;

        //gets the priority queue and adds the distribution center as the first element, because that is where the truck starts.
        PriorityQueue queue = TimePriority();
        queue.add(DistributionCenter);

        //gets the first element and splits it into a list
        String fullLine = (String)queue.poll();
        String[] temp = fullLine.split(" ");

        //the number of the house and the number of the street are put into variables
        int startingPointX = Integer.parseInt(temp[1]);
        System.out.println(startingPointX);
        int startingPointY = Integer.parseInt(temp[3]);
        System.out.println(startingPointY);

        //gets the second element and splits it into a list
        fullLine = (String)queue.poll();
        temp = fullLine.split(" ");

        //the number of the house and the number of the street are put into variables
        int endingPointX = Integer.parseInt(temp[1]);
        System.out.println(endingPointX);
        int endingPointY = Integer.parseInt(temp[3]);
        System.out.println(endingPointY);

        //moves the truck one house in each direction needed, think of it like a coordinate grid
        if(startingPointX > endingPointX){
            while(startingPointX > endingPointX){
                if(startingPointX % 100 == 0) {
                    blocks++;
                }
                startingPointX--;
                count++;
            }
        }
        if(startingPointX < endingPointX){
            while(startingPointX < endingPointX){
                if(startingPointX % 100 == 0) {
                    blocks++;
                }
                startingPointX++;
                count++;
            }
        }
        if(startingPointY > endingPointY){
            while(startingPointY > endingPointY){
                if(startingPointX % 100 == 0) {
                    blocks++;
                }
                startingPointY--;
                count++;
            }
        }
        if(startingPointY < endingPointY){
            while(startingPointY < endingPointY){
                if(startingPointX % 100 == 0) {
                    blocks++;
                }
                startingPointY++;
                count++;
            }
        }

        LinkedList<Integer> route = new LinkedList<>();
        route.add(blocks);
        route.add(count);

        return route;
    }

    public static int getHowManyBlocks(LinkedList route){
        int blocks;
        blocks = (int)route.get(0);
        return blocks;
    }

    public static int ComputeLengthOfTruckRoute(LinkedList route){
        int time = 0;
        //for every block add 2 minutes onto the time
        for(int block = getHowManyBlocks(route); block > 0; block--){
            time = time + 2;
        }
        return time;
    }

    public static void PrintLengthOfTruckRoute(){
        //Prints the truck route length in minutes
        LinkedList currentRoute = getCurrentRoute();
        int truckRouteLength = ComputeLengthOfTruckRoute(currentRoute);
        System.out.print("The truck route length is about " + truckRouteLength + " minutes.");
    }

    public static void Main(){
        PrintLengthOfTruckRoute();
    }
}