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
    ArrayList<Devices> devices = new ArrayList<Devices>();
    Scanner input = new Scanner(System.in);
    
    public Outlet(double volts, double amps) {
        this.volts = volts;
        this.maxAmps = amps;
    }

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
    
    public void addDevice(Devices object){
        devices.add(object);
    }
    
    public void removeDevice(){
        System.out.println("Select device number to remove: ");
        devices.remove(input.nextInt()-1);
    }
    
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
