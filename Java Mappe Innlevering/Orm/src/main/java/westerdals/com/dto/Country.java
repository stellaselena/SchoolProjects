package westerdals.com.dto;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "country")
public class Country {

    @DatabaseField(id = true)
    private String Code;
    @DatabaseField
    private String Name;
    @DatabaseField(unknownEnumName = "Europe")
    private ContinentEnum Continent;
    @DatabaseField
    private String Region;
    @DatabaseField
    private float SurfaceArea;
    @DatabaseField
    private int IndepYear;
    @DatabaseField
    private int Population;
    @DatabaseField
    private float LifeExpectancy;
    @DatabaseField
    private float GNP;
    @DatabaseField
    private float GNPOld;
    @DatabaseField
    private String LocalName;
    @DatabaseField
    private String GovernmentForm;
    @DatabaseField
    private String HeadOfState;
    @DatabaseField
    private int Capital;
    @DatabaseField
    private String Code2;


    public Country() {
        //no-arg constructor

    }

    public Country(String code) {
        this.Code = code;

    }

    public Country(String code, String name, ContinentEnum continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float GNP, float GNPOld, String localName, String governmentForm, String headOfState, int capital, String code2) {
        this.Code = code;
        this.Name = name;
        this.Continent = continent;
        this.Region = region;
        this.SurfaceArea = surfaceArea;
        this.IndepYear = indepYear;
        this.Population = population;
        this.LifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.LocalName = localName;
        this.GovernmentForm = governmentForm;
        this.HeadOfState = headOfState;
        this.Capital = capital;
        this.Code2 = code2;
    }
    private ContinentEnum continentEnum = ContinentEnum.Europe;

    public enum ContinentEnum {
        Asia, Europe, North_America, Africa, Oceania, Antactica, South_America;
    }

    public ContinentEnum getContinentEnum() {
        return continentEnum;
    }

    public void setContinentEnum(ContinentEnum continentEnum) {
        this.continentEnum = continentEnum;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ContinentEnum getContinent() {
        return Continent;
    }

    public void setContinent(ContinentEnum continent) {
        Continent = continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public float getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        SurfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public float getLifeExpectancy() {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        LifeExpectancy = lifeExpectancy;
    }

    public float getGNP() {
        return GNP;
    }

    public void setGNP(float GNP) {
        this.GNP = GNP;
    }

    public float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return LocalName;
    }

    public void setLocalName(String localName) {
        LocalName = localName;
    }

    public String getGovernmentForm() {
        return GovernmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        GovernmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public void setHeadOfState(String headOfState) {
        HeadOfState = headOfState;
    }

    public int getCapital() {
        return Capital;
    }

    public void setCapital(int capital) {
        Capital = capital;
    }

    public String getCode2() {
        return Code2;
    }

    public void setCode2(String code2) {
        Code2 = code2;
    }

    public int getIndepYear() { return IndepYear; }

    public void setIndepYear(int indepYear) { IndepYear = indepYear; }

    @Override
    public String toString() {
        return "Country{" +
                "Code='" + Code + '\'' +
                ", Name='" + Name + '\'' +
                ", Continent=" + Continent +
                ", Region='" + Region + '\'' +
                ", SurfaceArea=" + SurfaceArea +
                ", IndepYear=" + IndepYear +
                ", Population=" + Population +
                ", LifeExpectancy=" + LifeExpectancy +
                ", GNP=" + GNP +
                ", GNPOld=" + GNPOld +
                ", LocalName='" + LocalName + '\'' +
                ", GovernmentForm='" + GovernmentForm + '\'' +
                ", HeadOfState='" + HeadOfState + '\'' +
                ", Capital=" + Capital +
                ", Code2=" + Code2 +
                '}';
    }
}
