package javatask.task1;
import joinery.DataFrame;

import java.io.IOException;

public class Joinery {

	 public static void main(String args[]){
	        try {
	            DataFrame<Object>  dfNumircal= DataFrame.readCsv ("C:\\Users\\iti\\eclipse-workspace\\task1\\src\\main\\java\\javatask\\task1//titanic.csv");
	            dfNumircal = dfNumircal.retain("PassengerId", "Survived", "Pclass","Age");
	            DataFrame<Object> describe =dfNumircal.describe ();
	            System. out.println(describe.toString());

	            System.out.println ("=========================================================================================");

	            //Make another seprated data frames then merge between it and dfNumircal in a new data frame called dfTitanic
	            DataFrame<Object> dfNotNumircal= DataFrame.readCsv ("C:\\Users\\iti\\eclipse-workspace\\task1\\src\\main\\java\\javatask\\task1//titanic.csv");
	            dfNotNumircal = dfNotNumircal.retain("Name","Sex","Ticket","Embarked");

	            DataFrame<Object> dfTitanic = dfNotNumircal.join(dfNumircal);

	            dfTitanic.iterrows ().forEachRemaining (System.out::println);
	            
	           
	            

	        } catch (IOException e) {
	            e.printStackTrace ();
	        }
	    }
}
