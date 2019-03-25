import javax.swing.*;

public class GUI extends JFrame {

    GUI(TruckRoute truck){
        setTitle("Sandwich Truck Simulation");
        add(new GridSimulation(truck));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }

    }

