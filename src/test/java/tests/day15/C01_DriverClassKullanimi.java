package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

       // Driver driver=new Driver();
        // Driver class indan obje üretilemesin istedigimiz icin Driver class i SINGLETON yapiyoruz.
        // bunun icin default constructor yerine parametresiz bir Constructor olsuturup access modiefier i private
        // seciyoruz.



    }


}
