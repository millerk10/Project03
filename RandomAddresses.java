import java.io.*;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.IOException;


/**
 * Created by espinoa@moravian.edu on 2/27/19.
 */
public class RandomAddresses {

    private int HouseNumber;
    private int StreetAddress;
    private int StreetNumber;
    private String StreetName;
    private String FinalAddress;
    private int count;
    private Random randomgenerator = new Random();

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

            StreetAddress = 1+randomgenerator.nextInt(10);
            FinalAddress = String.valueOf(HouseNumber) + " " + StreetName + " " + String.valueOf(StreetNumber) + " Street";
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
}

