package Lab4Generics;

import Lab4Generics.PeopleClasses.Person;
import Lab4Generics.TransportClasses.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private List<Vehicle> carsOnRoad;
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
    public List<Vehicle> getCarsOnRoad(){
        return carsOnRoad;
    }

    public int getCountOf(Class clas){

        int result = 0;

            for(Vehicle vehicle : carsOnRoad)
            {
                for(Object obj : vehicle.passengersInVehicle)
                    if(obj.getClass() == clas)
                        ++result;
            }


        return result;
    }
    public boolean addVehicleToRoad(Vehicle<? extends Person> vehicle){
        if(!isVehicleOnRoad(vehicle))
            carsOnRoad.add(vehicle);
        else return false;

        return isVehicleOnRoad(vehicle);
    }
    public boolean removeVehicleFromRoad(Vehicle<? extends Person> vehicle){
        if(isVehicleOnRoad(vehicle))
            carsOnRoad.remove(vehicle);
        else return false;

        return !isVehicleOnRoad(vehicle);
    }
    public boolean isVehicleOnRoad(Vehicle<? extends Person> vehicle)
    {
        return carsOnRoad.contains(vehicle);
    }
}
