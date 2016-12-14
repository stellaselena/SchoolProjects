package westerdals.com.dto;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "city")
public class City {

    @DatabaseField(id = true)
    private int ID;
    @DatabaseField
    private String Name;
    @DatabaseField
    private String CountryCode;
    @DatabaseField
    private String District;
    @DatabaseField
    private int Population;


    public City() {
        //no-arg constructor
    }

    public City(int ID, String Name, String CountryCode,String District, int Population) {
        this.ID = ID;
        this.Name = Name;
        this.CountryCode = CountryCode;
        this.District = District;
        this.Population = Population;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }
}
