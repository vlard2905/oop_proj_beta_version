package app.oop_proj.general_logic;

import app.oop_proj.general_logic.City;

import java.io.Serial;
import java.io.Serializable;

/**
 * Object of this class represents factors of visiting places.
 */
public class Trip implements Serializable {

    @Serial
    private static final long serialVersionUID = 8397123610583239212L;
    public City city;
    boolean ActiveTrip;
    boolean PassiveTrip;
    long time;
    int budget;

    public void setActiveTrip(boolean activeTrip) {
        ActiveTrip = activeTrip;
    }

    public void setPassiveTrip(boolean passiveTrip) {
        PassiveTrip = passiveTrip;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public boolean isActiveTrip() {
        return ActiveTrip;
    }

    public boolean isPassiveTrip() {
        return PassiveTrip;
    }

    public double getTime() {
        return time;
    }

    public City getCity() {
        return city;
    }
}
