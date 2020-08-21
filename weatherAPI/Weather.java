public class Weather
{
    private double Kelvin, Celcius, Fahrenheit;
    static final double kelvinConstant = 273.15;
    public Weather()
    {
    }
    public String toString(String Location, String type)
    {
        getAPI API = new getAPI();
        String APIResult = API.getAPIResult(Location);
        String result = "In " + getCity(APIResult) + ", " + getCountry(APIResult) + " = ";
        if (type.toUpperCase().equals("KELVIN"))
        {
            result = result + getKelvin(APIResult) + "K";
        }
        else if (type.toUpperCase().equals("CELCIUS"))
        {
            result = result + getCelcius(APIResult) + " " + Character.toString ((186)) + "C" ;
        }
        else if (type.toUpperCase().equals("FAHRENHEIT"))
        {
            result = result + getFahrenheit(APIResult) + " " + Character.toString ((186)) + "F";
        }
        result = result + " Wind : " + getWindSpeed(APIResult) +" details : "+ getDescription(APIResult);
        return result;
    }
    private int getKelvin(String APIResult)
    {
        return (int)Math.round(Double.parseDouble(getTemp(APIResult)));
    }
    private int getCelcius (String APIResult)
    {
        Celcius = getKelvin(APIResult) - kelvinConstant;
    
        return (int)Math.round(Celcius);
    }
    private int getFahrenheit (String APIResult)
    {
        Fahrenheit = (getKelvin(APIResult) - kelvinConstant) * 9 / 5 + 32;
    
        return (int)Math.round(Fahrenheit);
    }
    private String find(String APIResult, String keyword, int space)
    {
        int startnum = APIResult.indexOf(keyword);
        String find = "";
        for (int i = 0; i < 30; i++)
        {
            if((""+ APIResult.charAt(startnum + space + i)).equals((",")) || (""+ APIResult.charAt(startnum + space + i)).equals(("\"")) )
            {
                break;
            } 
            else
            find = find + APIResult.charAt(startnum + space + i) + "";
        }
        return find;
    }
    private String getTemp(String APIResult)
    {
        return find(APIResult,"temp",6);
    }
    private String getCity(String APIResult)
    {
        return find(APIResult,"name",7);
    }
    private String getCountry(String APIResult)
    {
        return find(APIResult,"country",10);
    }
    private String getWindSpeed(String APIResult)
    {
        return find(APIResult,"speed",7);
    }
    private String getDescription(String APIResult)
    {
        return find(APIResult,"description",14);
    }
}
