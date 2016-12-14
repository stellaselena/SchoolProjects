package westerdals.com.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;
import westerdals.com.dto.City;
import westerdals.com.dto.Country;
import westerdals.com.dto.CountryLanguage;

import java.sql.SQLException;
import java.util.List;


public class App {

    //change these values for own database
    private static String databaseUrl = "jdbc:mysql://localhost:3306/world?useSSL=false";
    private static String username = "root";
    private static String pass = "stella1234";
    private static ConnectionSource connectionSource = null;

    private static Dao<City, Integer> cityDao;
    private static Dao<Country, String> countryDao;
    private static Dao<CountryLanguage, String> countryLanguagesDao;

    public static void main(String[] args) throws Exception {

        connect();
        countryDao = DaoManager.createDao(connectionSource, Country.class);
        cityDao = DaoManager.createDao(connectionSource, City.class);
        countryLanguagesDao = DaoManager.createDao(connectionSource, CountryLanguage.class);

        //CRUD demonstration
        System.out.println("Create:");
        createCity(1001, "ooo", "AFG", "ooo", 123);
        createCountry("OOO", "ooo", Country.ContinentEnum.Asia, "ooo", 123, 123, 123, 50, 50, 50, "ooo", "ooo", "ooo", 123, "oo");
        createCountryLanguage ("AFG", "ooo", CountryLanguage.isOfficialENum.T, 22);

        System.out.println("Update:");
        updateCity(1, "Athena", "AFG", "Test", 123);
        updateCountry("ABW", "Athena", Country.ContinentEnum.Europe, "Region", 222, 222, 222, 50, 10, 15, "asd", "asd", "asd", 22, "as");
        updateCountryLanguage("AFG", "StellaLanguage", CountryLanguage.isOfficialENum.F, 22);

        System.out.println("Read:");
        readCity(11);
        readCountry("AFG");
        readCountryLanguage("Yi");

        System.out.println("Delete:");
        deleteCity(16);
        //deleteCountry("ABW");
        deleteCountryLanguage("Yi");
        // close the connection
        connectionSource.close();
    }

    private static void connect() {
        //create a connection
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl, username, pass);
            System.out.println("Connection established");
            System.out.println("\n");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    //create
    private static void createCountry(String code, String name, Country.ContinentEnum continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float GNP, float GNPOld, String localName, String governmentForm, String headOfState, int capital, String code2) {
        //instantiate the dao
        try {
            //create instance of country
            Country country = new Country();
            country.setCode(code);
            country.setName(name);
            country.setContinent(continent);
            country.setRegion(region);
            country.setSurfaceArea(surfaceArea);
            country.setIndepYear(indepYear);
            country.setPopulation(population);
            country.setLifeExpectancy(lifeExpectancy);
            country.setGNP(GNP);
            country.setGNPOld(GNPOld);
            country.setLocalName(localName);
            country.setGovernmentForm(governmentForm);
            country.setHeadOfState(headOfState);
            country.setCapital(capital);
            country.setCode2(code2);
            //persist the object to the database
            countryDao.createOrUpdate(country);
            System.out.println("Country created: " + country.toString());
            System.out.println("\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    private static void createCity(int id, String name, String countryCode, String district, int population) {
        try {
            City city = new City();
            city.setID(id);
            city.setName(name);
            city.setCountryCode(countryCode);
            city.setDistrict(district);
            city.setPopulation(population);
            //persist the object to the database
            cityDao.createOrUpdate(city);
            System.out.println("City created: " + city.toString());
            System.out.println("\n");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void createCountryLanguage(String countryCode, String language, CountryLanguage.isOfficialENum isOfficial, float percentage) {
            try {
                CountryLanguage countryLanguage = new CountryLanguage();
                countryLanguage.setCountryCode(countryCode);
                countryLanguage.setLanguage(language);
                countryLanguage.setIsOfficial(isOfficial);
                countryLanguage.setPercentage(percentage);
                //persist the object to the database
                countryLanguagesDao.createOrUpdate(countryLanguage);
                System.out.println("Country Language created: " + countryLanguage.toString());
                System.out.println("\n");


            } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    //read
    private static void readCountry(String id) {
        try {
            Country country = countryDao.queryForId(id);
            List<Country> results = countryDao.queryBuilder().where().eq("Region", country.getRegion()).query();
            System.out.println(results.size());
            System.out.println(results.toString());
            System.out.println("\n");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void readCity(int id) {
        try {
            City city = cityDao.queryForId(id);
            List<City> results = cityDao.queryBuilder().where().eq("ID", city.getID()).query();
            System.out.println(results.size());
            System.out.println(city.toString());
            System.out.println("\n");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    private static void readCountryLanguage(String id) {
        try {
            CountryLanguage countryLanguage = countryLanguagesDao.queryForId(id);
            List<CountryLanguage> results2 = countryLanguagesDao.queryBuilder().where().eq("Language", countryLanguage.getLanguage()).query();
            System.out.println(results2.size());
            System.out.println(countryLanguage.toString());
            System.out.println("\n");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    //update
    private static void updateCountry(String code, String name, Country.ContinentEnum continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float GNP, float GNPOld, String localName, String governmentForm, String headOfState, int capital, String code2) {
        try {
            Country country = new Country();
            country.setCode(code);
            country.setName(name);
            country.setContinent(continent);
            country.setRegion(region);
            country.setSurfaceArea(surfaceArea);
            country.setIndepYear(indepYear);
            country.setPopulation(population);
            country.setLifeExpectancy(lifeExpectancy);
            country.setGNP(GNP);
            country.setGNPOld(GNPOld);
            country.setLocalName(localName);
            country.setGovernmentForm(governmentForm);
            country.setHeadOfState(headOfState);
            country.setCapital(capital);
            country.setCode2(code2);
            countryDao.update(country);
            System.out.println("Country Updated " + country.toString());
            System.out.println("\n");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void updateCity(int id, String name, String countryCode, String district, int population) {
        try {
            City city = new City();
            city.setID(id);
            city.setName(name);
            city.setCountryCode(countryCode);
            city.setDistrict(district);
            city.setPopulation(population);
            cityDao.update(city);
            System.out.println("City Updated " + city.toString());
            System.out.println("\n");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    private static void updateCountryLanguage(String countryCode, String language, CountryLanguage.isOfficialENum isOfficial, float percentage) {
        try {
            CountryLanguage countryLanguage = new CountryLanguage();
            countryLanguage.setCountryCode(countryCode);
            countryLanguage.setLanguage(language);
            countryLanguage.setIsOfficial(isOfficial);
            countryLanguage.setPercentage(percentage);
            countryLanguagesDao.update(countryLanguage);
            System.out.println("Country Language updated: " + countryLanguage.toString());
            System.out.println("\n");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    //delete
    private static void deleteCity(int id) {

        DeleteBuilder db = cityDao.deleteBuilder();
        try {
            City city = cityDao.queryForId(id);
            db.where().eq("ID", city.getID());
            cityDao.delete(db.prepare());
            System.out.println("City has been deleted");
            System.out.println("\n");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void deleteCountry(String code) {

        DeleteBuilder db = countryDao.deleteBuilder();
        try {
            Country country = countryDao.queryForId(code);
            db.where().eq("Code", country.getCode());
            countryDao.delete(db.prepare());
            System.out.println("Country has been deleted");
            System.out.println("\n");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void deleteCountryLanguage(String language) {
        DeleteBuilder db = countryLanguagesDao.deleteBuilder();
        try {
            CountryLanguage countryLanguage = countryLanguagesDao.queryForId(language);
            db.where().eq("Language", countryLanguage.getLanguage());
            countryLanguagesDao.delete(db.prepare());
            System.out.println("Country Language has been deleted");
            System.out.println("\n");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
