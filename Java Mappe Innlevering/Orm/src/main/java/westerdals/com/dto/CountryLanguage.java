package westerdals.com.dto;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "countrylanguage")
public class CountryLanguage {

    @DatabaseField
    private String CountryCode;
    @DatabaseField(uniqueCombo = true,id = true)
    private String Language;
    @DatabaseField(dataType = DataType.ENUM_STRING)
    private isOfficialENum isOfficial;
    @DatabaseField
    private float Percentage;


    public CountryLanguage() {
        //no-arg constructor
    }

    public CountryLanguage(String countryCode, String language, isOfficialENum isOfficial, float percentage) {
        this.CountryCode = countryCode;
        this.Language = language;
        this.isOfficial = isOfficial;
        this.Percentage = percentage;
    }

    public enum isOfficialENum {
        T, F;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public isOfficialENum getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(isOfficialENum isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return Percentage;
    }

    public void setPercentage(float percentage) {
        Percentage = percentage;
    }



    @Override
    public String toString() {
        return "CountryLanguage{" +
                ", CountryCode='" + CountryCode + '\'' +
                ", Language='" + Language + '\'' +
                ", isOfficial=" + isOfficial +
                ", Percentage=" + Percentage +
                '}';
    }
}
