/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author yses9
 */

public class dailyWeatherAPI {
    private double MaxCelcius, MinCelcius ;
    static final double kelvinConst = 273.15;
    
    public dailyWeatherAPI(){
    
    }
     public String request(String Location)
    {
        API API = new API();
        String APIResult = API.getAPIWeatherForecastResult(Location);

        return APIResult;
    }
     
    public String[] Split(String APIResult)
    {
        String[] parts = APIResult.split("\"dt\":");
        return parts;
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
    public String getDate(String APIResult)
    {
        return find(APIResult,"dt_txt",9);
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

    public String getTemp(String APIResult)
    {
        double Kelvin = Double.parseDouble(find(APIResult,"temp",6));
        String celcius = "" + (int)(Kelvin - kelvinConst);
        return celcius;
    }

    public String getDescription(String APIResult)
    {
        return find(APIResult,"description",14);
    }
}
