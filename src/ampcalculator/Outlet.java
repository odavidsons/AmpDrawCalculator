/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ampcalculator;
import java.util.ArrayList;

import java.util.Scanner;

public class Outlet {
    private double volts;
    private double maxAmps;
    //Arraylist for storing devices
    ArrayList<Devices> devices = new ArrayList<Devices>();
    Scanner input = new Scanner(System.in);
    
    //Constructor
    public Outlet(double volts, double amps) {
        this.volts = volts;
        this.maxAmps = amps;
    }

    //Getters and setters
    public double getVolts(){
        return volts;
    }
    
    public double getMaxamps(){
        return maxAmps;
    }

    public void setVolts(double volts){
        this.volts = volts;
    }
    
    public void setAmps(double amps){
        this.maxAmps = amps;
    }
    
    //Function for adding a device to the arraylist
    public void addDevice(Devices object){
        devices.add(object);
    }
    
    //Function for removing a device from the arraylist
    public void removeDevice(){
        System.out.println("Select device number to remove: ");
        devices.remove(input.nextInt()-1);
    }
    
    //Function for listing the arraylist containing the devices
    public void getDevices(){
        if (devices.size()>0){
            System.out.println("List of connected devices: ");
        for (int i=0;i < devices.size();i++){
            System.out.println("Device "+(i+1)+" - "+ devices.get(i).getName()+" | "+devices.get(i).getWatts()+" watts");
        }
        }else{
            System.out.println("There are no devices.");
        }
    }
    
    //Function for calculating the total Amp and Wattage draw of the outlet
    public void calculateDraw(){
        double ampsDraw = 0;
        double wattsDraw = 0;
        for (int i = 0;i < devices.size();i++){
            double calcAmp = devices.get(i).getWatts() / this.volts;
            ampsDraw = ampsDraw + calcAmp;
            wattsDraw = wattsDraw + devices.get(i).getWatts();
        }
        System.out.println("Total wattage draw: "+ wattsDraw);
        System.out.println("Total amp draw: "+ String.format("%.2f", ampsDraw) +" / "+this.maxAmps);
        if (ampsDraw > this.maxAmps){
            System.out.println("WARNING You are drawing more amps than the outlet limit!");
        }
    }
}
