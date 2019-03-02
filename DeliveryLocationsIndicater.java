//Abdullah

public class DeliveryLocationsIndicater implements Comparable<DeliveryLocationsIndicater>{

    int HouseNumber;
    int streetNumber;
    Compass StreetName;




    public DeliveryLocationsIndicater(int HouseNumber,  int streetNumber, Compass StreetName) {
        this.HouseNumber = HouseNumber;
        this.streetNumber = streetNumber;
        this.StreetName = StreetName;

    }

    @Override
    public String toString() {
        return HouseNumber + " " + StreetName + " " + streetNumber ;
    }


    public Compass getStreetName() {
        return StreetName;
    }

    public int DistanceBetweenTruckLocationAndOrder(DeliveryLocationsIndicater o) {

        int houeseNum = o.getHouseNumber();

        int streetNum = o.getStreetNumber();
        Compass compass = o.getStreetName();


        //  https://www.baeldung.com/java-distance-between-two-points
        if ( streetNum == streetNumber && compass == getStreetName() ) {
            return Math.abs(houeseNum - HouseNumber);
        }
        else {


            double x1 =  ((houeseNum-910) * ((houeseNum-910) + (streetNum - 9)*(streetNum - 9)));
            double y1 = ((streetNum-910) * ((houeseNum-910) + (streetNum - 9)*(streetNum - 9)));
            int x = (int) x1;
            int y = (int) y1;


            return x+y;


        }
    }


    @Override
    public int compareTo(DeliveryLocationsIndicater o) {
        int distanceO;
        int currDistance;
        distanceO = o.DistanceBetweenTruckLocationAndOrder(TruckLocation.center);
        currDistance = this.DistanceBetweenTruckLocationAndOrder(TruckLocation.center);
        if (currDistance > distanceO) {
            return 1;
        } else if (currDistance < distanceO)
            return -1;
        return 0;
    }

    public int getHouseNumber() {
        return HouseNumber;
    }


    public int getStreetNumber() {
        return streetNumber;
    }



}
