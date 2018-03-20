package Lab4Generics;

import Lab4Generics.PeopleClasses.Person;
import Lab4Generics.TransportClasses.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle> carsOnRoad;
    {
        carsOnRoad = new ArrayList<>();
    }
    public int getCountOfHumans(){
        int result = 0;
        for(Vehicle vehicle : carsOnRoad)
        {
            result += vehicle.getBusyPlaces();
        }
        return result;
    }

    public  <T extends Person> int getCountOf(T human){
        int result = 0;

        for(Vehicle vehicle : carsOnRoad)
        {
            for(Object obj : vehicle.passengersInVehicle)
                if(obj.getClass() == human.getClass())
                    ++result;
        }

        return result;
    }
    public boolean addVehicleToRoad(Vehicle<? extends Person> vehicle){
        if(!isVehicleOnRoad(vehicle))
            carsOnRoad.add(vehicle);

        return isVehicleOnRoad(vehicle);
    }
    public boolean removeVehicleFromRoad(Vehicle<? extends Person> vehicle){
        if(isVehicleOnRoad(vehicle))
            carsOnRoad.remove(vehicle);

        return !isVehicleOnRoad(vehicle);
    }
    public boolean isVehicleOnRoad(Vehicle<? extends Person> vehicle)
    {
        return carsOnRoad.contains(vehicle);
    }
}
