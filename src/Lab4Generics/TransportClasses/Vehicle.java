package Lab4Generics.TransportClasses;

import Lab4Generics.MyExcep.ExcepNoPass;
import Lab4Generics.MyExcep.ExcepNoPlace;
import Lab4Generics.MyExcep.ExcepPassHere;
import Lab4Generics.MyExcep.ExcepPassInOtherCar;
import Lab4Generics.PeopleClasses.Person;

import java.util.ArrayList;
import java.util.UUID;

abstract public class Vehicle <T extends Person> {
    private int maxAmountOfPlaces;
    private UUID id;
    public ArrayList<T> passengersInVehicle;

    {
        id = UUID.randomUUID();
        passengersInVehicle = new ArrayList<>();
        maxAmountOfPlaces = 20;
    }

    public boolean isPassengerInVehicle(T passenger){
        return passengersInVehicle.contains(passenger);
    }
    public  boolean setAPassenger(T passenger){
        if(!isHasFreePlace()) throw new ExcepNoPlace();
        if(!isPassengerInVehicle(passenger))
        {
            if(!passenger.isSeat()){
                passengersInVehicle.add(passenger);
                passenger.setSeat(true);
                return true;
            }
            else
                throw new ExcepPassInOtherCar();
              //System.out.println(new StringBuilder().append(passenger.getId()).append(" is already in some vehicle. Firstly land it"));
        }
        throw new ExcepPassHere();
        //System.out.println(new StringBuilder().append(passenger.getId()).append(" is already in this vehicle."));
        //return false;
    }
    public boolean landingPassenger(T passenger){
        if(passenger.isSeat() && isPassengerInVehicle(passenger))
        {
            passengersInVehicle.remove(passenger);
            passenger.setSeat(false);
            return true;
        }
        throw new ExcepNoPass();

        //System.out.println(String.valueOf(passenger.getId()) + " is not in " + this.getId());
        //return false;
    }

    void setMaxAmountOfPlaces(int maxAmountOfPlaces){
        this.maxAmountOfPlaces = maxAmountOfPlaces;
    }

    public int getMaxAmountOfPlaces() {
        return maxAmountOfPlaces;
    }
    public int getFreePlaces(){
        return getMaxAmountOfPlaces() - passengersInVehicle.size();
    }
    public int getBusyPlaces(){ return passengersInVehicle.size();}
    public UUID getId(){ return id;}

    public boolean isHasFreePlace(){
        return getFreePlaces() > 0;
    }

    public void displayAllInfo(){
        StringBuilder info = new StringBuilder();
        info.
                append("Type: ").append(this.getClass()).append("\n").
                append("Busy: ").append(getBusyPlaces()).
                append(", Free: ").append(getFreePlaces()).append("\n").
                append(getInfoAboutAllPassenger());
        System.out.println(info);
    }
    public String getInfoAboutAllPassenger(){
        StringBuilder info = new StringBuilder();
        for (T vehicle : passengersInVehicle){
            info.append(vehicle.toString()).append("\n");
        }
        return info.toString();
    }
}
