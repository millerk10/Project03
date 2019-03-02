import java.util.PriorityQueue;

public class TruckLocation {

    public static final DeliveryLocationsIndicater center = new DeliveryLocationsIndicater(910, Compass.South, 9);


    public DeliveryLocationsIndicater truckLocation;

    public PriorityQueue<DeliveryLocationsIndicater> Destinations = new PriorityQueue<>();

    public TruckLocation(int HouseNumber, int StreetNumber, Compass compass) {
        truckLocation = new DeliveryLocationsIndicater(HouseNumber, compass, StreetNumber);

    }

    public PriorityQueue<DeliveryLocationsIndicater> getDestinations() {
        return Destinations;
    }

    public void setDestinations(PriorityQueue<DeliveryLocationsIndicater> destinations) {
        Destinations = destinations;
    }

    public static DeliveryLocationsIndicater getCenter() {
        return center;
    }
}

