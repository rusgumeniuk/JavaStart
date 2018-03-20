package Lab4Generics;

import Lab4Generics.PeopleClasses.Fireman;
import Lab4Generics.PeopleClasses.Person;
import Lab4Generics.PeopleClasses.Policeman;
import Lab4Generics.TransportClasses.Bus;
import Lab4Generics.TransportClasses.Cars.FireTruck;
import Lab4Generics.TransportClasses.Cars.PoliceCar;
import Lab4Generics.TransportClasses.Cars.Taxi;
/*пасажир не може сидіти в декількох машинах одночасно
        */
public class Main {
    public static void main(String s[]) {
        Road road = new Road();
        Person pers = new Person();
        Policeman pm = new Policeman();
        Policeman pm2 = new Policeman();
        Fireman fm = new Fireman();
        Fireman fm2 = new Fireman();

        Taxi taxi = new Taxi();
        Bus bus = new Bus();
        PoliceCar policeCar = new PoliceCar();
        FireTruck fireTruck = new FireTruck();

        road.addVehicleToRoad(taxi);
        road.addVehicleToRoad(bus);
        road.addVehicleToRoad(policeCar);
        road.addVehicleToRoad(fireTruck);
        printTask(1);
        taxi.displayAllInfo();
        bus.displayAllInfo();
        policeCar.displayAllInfo();
        fireTruck.displayAllInfo();

        printTask(2);
        taxi.setAPassenger(pers);
        taxi.setAPassenger(pm);
        taxi.setAPassenger(pm2);
        taxi.setAPassenger(fm);
        taxi.setAPassenger(fm2);

        bus.setAPassenger(pers);
        bus.setAPassenger(pm);
        bus.setAPassenger(pm2);
        bus.setAPassenger(fm);
        bus.setAPassenger(fm2);
        policeCar.setAPassenger(pm);
        policeCar.setAPassenger(pm2);

        fireTruck.setAPassenger(fm);
        taxi.landingPassenger(fm2);
        fireTruck.setAPassenger(fm2);
        fireTruck.setAPassenger(fm2);


/*
        taxi.displayAllInfo();
        bus.displayAllInfo();
        policeCar.displayAllInfo();
        fireTruck.displayAllInfo();
*/

        System.out.println(road.getCountOf(new Fireman()));
        System.out.println(road.getCountOfHumans());

        fireTruck.landingPassenger(fm);
        fireTruck.landingPassenger(fm2);

        System.out.println(road.getCountOf(new Fireman()));
        System.out.println(road.getCountOfHumans());
    }
    private static void printTask(int i){
        System.out.println(("\n" + "Task #" + i).toUpperCase());
    }


}
