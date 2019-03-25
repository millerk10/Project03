import javax.swing.*;
import java.awt.*;

public class GridSimulation extends JPanel {

    private TruckRoute t;
    public int lineDistance = 1;

    public GridSimulation(TruckRoute truck) {
        t = truck;
    }

    @Override
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        drawGrid(g);
        drawTruck(g);

    }

    private void drawGrid(Graphics2D g) {
        setBackground(Color.green);

        if (getWidth() < getHeight())
            lineDistance = this.getWidth() / 18;
        else
            lineDistance = this.getHeight() / 18;
        for (int i = 0; i < 20; i++) {
            int currentXY = i * lineDistance;
            g.drawLine(currentXY, 0, currentXY, getHeight());
            g.drawLine(0, currentXY, getWidth(), currentXY);
        }
    }

    private void drawTruck(Graphics2D g) {
        RandomAddresses RandomList = new RandomAddresses();
        Color c = g.getColor();
        g.setColor(Color.RED);

        int houseDistance = lineDistance / 9;
        int blockX, blockY;

        if (RandomList.getStreetName().equals("East")) {
            // Y value is street number, house is X
            blockY = RandomAddresses.getStreetNumber() * lineDistance;
            blockX = ((RandomList.getHouseNumber() / 100) * lineDistance)
                    - ((RandomList.getHouseNumber() % 100) * houseDistance);
        } else {
            // X value is street number, house is Y
            blockX = RandomList.getStreetNumber() * lineDistance;
            blockY = ((RandomList.getHouseNumber() / 100) * lineDistance)
                    - ((RandomList.getHouseNumber() % 100) * houseDistance);
        }

        g.fillOval(blockX, blockY, 5, 5);
        g.setColor(c);

    }


}
