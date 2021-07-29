package pageObject;
import org.openqa.selenium.WebElement;
import elementRepository.ElementFactory;
import utility.Log;

public class FlightStatusPage{
   //Page object method for - btn_departure_initial
   public WebElement btn_departure_initial(){
     Log.info("Element Page Object >> btn_departure_initial");
     return ElementFactory.getElement("btn_departure_initial");
   }

   //Page object method for - txt_departure
   public WebElement txt_departure(){
     Log.info("Element Page Object >> txt_departure");
     return ElementFactory.getElement("txt_departure");
   }

   //Page object method for - btn_destination_initial
   public WebElement btn_destination_initial(){
     Log.info("Element Page Object >> btn_destination_initial");
     return ElementFactory.getElement("btn_destination_initial");
   }

   //Page object method for - txt_departure
   public WebElement txt_departure(){
     Log.info("Element Page Object >> txt_departure");
     return ElementFactory.getElement("txt_departure");
   }

   //Page object method for - btn_datePicker
   public WebElement btn_datePicker(){
     Log.info("Element Page Object >> btn_datePicker");
     return ElementFactory.getElement("btn_datePicker");
   }

   //Page object method for - btn_submit
   public WebElement btn_submit(){
     Log.info("Element Page Object >> btn_submit");
     return ElementFactory.getElement("btn_submit");
   }

}
