package CommonUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


public class FlightCodeMapping {
	
	private static Map<String,String> flightCodeMap = new HashMap<String,String>();

	public FlightCodeMapping() {
		
		if(flightCodeMap.isEmpty()) {
			System.out.println("Creating map");
				flightCodeMap = new HashMap<String,String>();
		        FileInputStream fis;
		        try {
		            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testData/FlightCodeMaping.properties");
		            ResourceBundle resources = new PropertyResourceBundle(fis);
		
		            //convert ResourceBundle to Map
		            Enumeration<String> keys = resources.getKeys();
		            while (keys.hasMoreElements()) {
		                String key = keys.nextElement();
		                flightCodeMap.put(key, resources.getString(key));            
		            }
		            //Now you can use the 'map' object as you wish.
		
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			}

    }
	
	public String getNameByCode(String code) {
		
		if(flightCodeMap.containsKey(code))
		return flightCodeMap.get(code);
		else
			return code;
	}
	
	public static void main(String a[]) {
		FlightCodeMapping codeMap = new FlightCodeMapping();
		System.out.println(codeMap.getNameByCode("BER"));
	}

}
