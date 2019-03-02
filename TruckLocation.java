//Abdullah Alramyan
public class TruckLocation {
    public static final DeliveryLocationsIndicater center = new DeliveryLocationsIndicater(910, 9, Compass.East);

    public DeliveryLocationsIndicater trucklocation;
    public TruckLocation(int HouseNumber, int StreetNumber, Compass compass) {
        trucklocation = new DeliveryLocationsIndicater(HouseNumber, StreetNumber, compass);
    }
    public DeliveryLocationsIndicater locationofthetrucknow() {
        return trucklocation;
    }
}
