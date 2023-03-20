/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ampcalculator;
import java.util.Scanner;
/**
 *
 * @author dsantos
 */
public class Devices extends Outlet{
    
    private String name;
    private double watts;

    //Constructor
    public Devices(String name, double watts, double volts, double amps) {
        super(volts, amps);
        this.name = name;
        this.watts = watts;
    }
    
    //Getters and setters
    public String getName() {
        return name;
    }

    public double getWatts() {
        return watts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWatts(double watts) {
        this.watts = watts;
    }
    
    
    
}
