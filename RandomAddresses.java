import java.io.*;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.IOException;

/*
 * Created by espinoa@moravian.edu on 2/27/19.
 */
public class RandomAddresses {
    int HouseNumber;
    int StreetAddress;
    int StreetNumber;
    String StreetName;
    String FinalAddress;
    int  count;
    int Hour;
    int Minute;
    static int MaxHour = 19;
    static int MinHour = 10;
    static int MaxMinute = 59;
    Random randomgenerator = new Random();
    Random HourGenerator = new Random();
    Random MinuteGenerator= new Random();

    public void GenerateAddresses()
    {
        String[] AddressList = new String[101];
        count = 0;
        while (count <= 100) {
            int s = randomgenerator.nextInt(2);
            if(s == 0){
                StreetName = "South";
                StreetNumber = randomgenerator.nextInt(20);
                HouseNumber = 10 + randomgenerator.nextInt(2000);
            }
            else{
                StreetName = "East";
                StreetNumber = randomgenerator.nextInt(10);
                HouseNumber = 1 + randomgenerator.nextInt(100);
                HouseNumber = HouseNumber * 10;
            }
            final int  MINIMUM= 100;
            final int MAX = 400;
            StreetAddress = 1+randomgenerator.nextInt(MAX - MINIMUM) + MINIMUM;
            Hour = HourGenerator.nextInt(MaxHour - MinHour) + MinHour;
            boolean Morning = true;
            if (Hour >= 13){
                Hour= Hour - 12;
                Morning = false;}
            if (Hour == 12){
                Morning = false;}
            Minute = MinuteGenerator.nextInt(MaxMinute);
            if (Minute < 10){
                FinalAddress = Hour + ":0" + Minute + (Morning ? "am" : "pm") + " " + String.valueOf(HouseNumber) + " " + StreetName + " " + String.valueOf(StreetNumber) + " Street";

            }
            else {
                FinalAddress = Hour + ":" + Minute + (Morning ? "am" : "pm")+ " " + String.valueOf(HouseNumber) + " " + StreetName + " " + String.valueOf(StreetNumber) + " Street";
            }
            AddressList[count] = FinalAddress;
            count++;
            WriteAddressToFile(AddressList);
            FinalAddress = "";
        }

    }

    public void WriteAddressToFile(String FinalAddress[]){
        try{
            FileWriter write = new FileWriter("AddressList.txt");
            BufferedWriter writer = new BufferedWriter(write);
            for(int i = 0; i <= 99; i++){
                writer.write(String.valueOf(FinalAddress[i]));
                if(i != 99){
                    writer.write("\r\n");
                }
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println();
        }
    }

    public int getHouseNumber() {
        return HouseNumber;
    }

    public int getStreetAddress() {
        return StreetAddress;
    }

    public int getStreetNumber() {
        return StreetNumber;
    }

    public String getStreetName() {
        return StreetName;
    }

    public String getFinalAddress() {
        return FinalAddress;
    }

    public int getCount() {
        return count;
    }
}