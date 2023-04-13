package app.oop_proj;

import java.io.Serial;
import java.io.Serializable;

public class City implements Serializable{
    @Serial
    private static final long serialVersionUID = 8408791460313663504L;
    String cityName;
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String city) {
        this.cityName = city;
    }
}
