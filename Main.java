public class Main {


    public static void main(String[] args) throws Exception {

        TruckLocation currentLocation = new TruckLocation(900, 9, Compass.South);

        try {
            RandomAddresses randomAddresses = new RandomAddresses();
            randomAddresses.GenerateAddresses();
            ReadAddresses.Reading("AddressList.txt");
            currentLocation.Destinations = ReadAddresses.Reading("AddressList.txt");

        } catch (Exception e) {
            System.out.println("oh there is an error");
        }




    }
}
