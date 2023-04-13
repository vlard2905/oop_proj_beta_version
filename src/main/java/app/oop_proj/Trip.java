package app.oop_proj;

import java.io.Serial;
import java.io.Serializable;

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

    public int getBudget() {
        return budget;
    }

    public City getCity() {
        return city;
    }
}
