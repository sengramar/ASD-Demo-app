package API;

import java.io.*;
import java.net.*;
 
public class API {
    static String Domain ="http://api.openweathermap.org/data/2.5/weather?q=";
    static String APIKey ="&APPID=c44f884c1fce1cdfe6d8227e4d9ad305";
    static String inputLine; 
    public static String getAPIResult(String Location) {
        try {
            URL google = new URL(Domain + Location +APIKey);
            BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));
            while ((inputLine = in.readLine()) != null) {
                // Process each line.
                return inputLine;
            }
            in.close(); 
 
        } catch (MalformedURLException me) {
            System.out.println(me); 
 
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return null;
    }//end main
}