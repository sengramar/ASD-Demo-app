package API;

public class weatherAPI
{
    private double Celcius, Fahrenheit;
    static final double kelvinConst = 273.15;
    public weatherAPI()
    {
        
    }
    public String request(String Location)
    {
        API API = new API();
        String APIResult = API.getAPIResult(Location);

        return APIResult;
    }
    
    public int getKelvin(String APIResult)
    {
        return (int)Math.round(Double.parseDouble(getTemp(APIResult)));
    }
    public int getCelcius (String APIResult)
    {
        Celcius = getKelvin(APIResult) - kelvinConst;
    
        return (int)Math.round(Celcius);
    }
    public int getFahrenheit (String APIResult)
    {
        Fahrenheit = (getKelvin(APIResult) - kelvinConst) * 9 / 5 + 32;
    
        return (int)Math.round(Fahrenheit);
    }
    public String find(String APIResult, String keyword, int space)
    {
        int startnum = APIResult.indexOf(keyword);
        String find = "";
        for (int i = 0; i < 30; i++)
        {
            if((""+ APIResult.charAt(startnum + space + i)).equals((",")) 
              || (""+ APIResult.charAt(startnum + space + i)).equals(("\"")) 
              || (""+ APIResult.charAt(startnum + space + i)).equals(("}")) )
            {
                break;
            } 
            else
            find = find + APIResult.charAt(startnum + space + i) + "";
        }
        return find;
    }
    public String getTemp(String APIResult)
    {
        return find(APIResult,"temp",6);
    }
    public String getCity(String APIResult)
    {
        return find(APIResult,"name",7);
    }
    public String getCountry(String APIResult)
    {
        return find(APIResult,"country",10);
    }
    public String getCloudy(String APIResult)
    {
        return find(APIResult,"all",5);
    }
    public String getHumidity(String APIResult)
    {
        return find(APIResult,"humidity",10);
    }
    public String getWindDeg(String APIResult)
    {
        return find(APIResult,"deg",5);
    }
    public String getWindSpeed(String APIResult)
    {
        return find(APIResult,"speed",7);
    }
    public String getDescription(String APIResult)
    {
        return find(APIResult,"description",14);
    }
    
}
