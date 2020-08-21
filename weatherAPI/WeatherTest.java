import java.lang.Math;
public class WeatherTest
{
    private String Location[] = {"Sydney","Melbourne","Melbourne,AU","Canberra"};
    private String Tempt[] = {"Celcius","Fahrenheit","Kelvin"};
    private int LocationIndex, TemptIndex = 0;
    private Weather main = new Weather();
    public WeatherTest()
    {
      LocationIndex = LocationIndex + (int)(Math.random() * 4);
      TemptIndex = TemptIndex + (int)(Math.random() * 3);
      System.out.println(main.toString(Location[LocationIndex],Tempt[TemptIndex]));
    }
}
