//  https://www.baeldung.com/java-distance-between-two-points
public class DeliveryLocationsIndicater implements Comparable<DeliveryLocationsIndicater> {

    private int HouseNumber;
    private int streetNumber;
    private Compass StreetName;


    public DeliveryLocationsIndicater(int HouseNumber, Compass compass, int streetNumber) {
        this.HouseNumber = HouseNumber;
        this.streetNumber = streetNumber;
        this.StreetName = compass;


    }


    public int DistanceBetweenTwoPoints(DeliveryLocationsIndicater o) {
        Compass facing = o.getStreetName();
        if (o.getStreetNumber() == streetNumber && facing == o.getStreetName()) {
            return Math.abs(o.getHouseNumber() - HouseNumber);
        } else if (facing == StreetName) {
            int x1 = Math.abs(o.getHouseNumber() - HouseNumber);
            int y1 = Math.abs((o.getStreetNumber() * 100) - (streetNumber * 100));
            return y1 + x1;
        } else {
            int x1 = Math.abs(o.getHouseNumber() - (streetNumber * 100));
            int y1 = Math.abs((o.getStreetNumber() * 100) - HouseNumber);
            return y1 + x1;
        }


    }

    @Override
    public int compareTo(DeliveryLocationsIndicater o) {

       return Integer.compare(this.DistanceBetweenTwoPoints(TruckLocation.center), o.DistanceBetweenTwoPoints(TruckLocation.center));
    }

    public int getHouseNumber() {
        return HouseNumber;
    }


    public int getStreetNumber() {
        return streetNumber;
    }


    public Compass getStreetName() {
        return StreetName;
    }

    @Override
    public String toString() {
        return "\n"+ "[" + HouseNumber + " " + StreetName + " " + streetNumber + "]";
    }
}

