/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ampcalculator;

import java.util.Scanner;
public class AmpCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("-----Amp Calculator-----");
        System.out.println("This application helps you calculate the ammounts of amps used by the connected devices you have to an outlet.");
        System.out.println("You will be asked for the outlet's voltage and each device's wattage");
        
        System.out.println("Input the outlet voltage: ");
        double v = input.nextDouble();
        System.out.println("Input the outlet's max amp draw: ");
        double a = input.nextDouble();
        Outlet outlet = new Outlet(v, a);
        
        boolean menu = true;
        while (menu==true){
            System.out.println("------------------------------------");
            System.out.println("Option:");
            System.out.println("1 - Add device");
            System.out.println("2 - Remove device");
            System.out.println("3 - Calculate total amp draw");
            System.out.println("4 - List devices");
            System.out.println("0 - Exit");
            String option = input.next();
            switch (option){
                case "1":
                    System.out.println("------------------------------------");
                    System.out.println("Device name: ");
                    String name = input.next();
                    System.out.println("Rated wattage: ");
                    double watts = input.nextDouble();
                    Devices device = new Devices(name, watts, outlet.getVolts(), outlet.getMaxamps());
                    outlet.addDevice(device);
                    break;
                case "2":
                    System.out.println("------------------------------------");
                    outlet.getDevices();
                    System.out.println("------------------------------------");
                    outlet.removeDevice();
                    break;
                case "3":
                    System.out.println("------------------------------------");
                    outlet.calculateDraw();
                    break;
                case "4":
                    System.out.println("------------------------------------");
                    outlet.getDevices();
                    break;
                case "0": 
                    System.out.println("Closing...");
                    menu = false;
                    break; 
            }
        }
    }
    
}
