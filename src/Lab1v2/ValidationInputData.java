package Lab1v2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationInputData  {

	//"(^\\W)"; 
	
	public   String regExPrice() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
		System.out.println("внутри regExPrice");	
        	String inputString = reader.readLine();
        	String pattern = "(\\d)";        
        	Pattern ptrn = Pattern.compile(pattern);
        	Matcher matcher = ptrn.matcher(inputString);  
        	if(matcher.find()) {
        		System.out.println("norm"); 
        		return inputString;
        	}
        	else {
        		System.out.println("NE norm"); 
        		continue;
        }
		}

    	}
	
	public  String regExString () throws IOException  {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
		System.out.println("внутри regExPrice");	
        	String inputString = reader.readLine();
        	String pattern = "\\W";        
        	Pattern ptrn = Pattern.compile(pattern);
        	Matcher matcher = ptrn.matcher(inputString);  
        	if(matcher.find()) {
        		System.out.println("norm"); 
        		return inputString;
        	}
        	else {
        		System.out.println("Вы ввели не корректное название, введите название заново"); 
        		continue;
        	}
		}

    }
		
	public String regExFileName() throws IOException  {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
		System.out.println("внутри regExPrice");	
        	String inputString = reader.readLine();
        	String pattern = "(^|*\\?<>)";        
        	Pattern ptrn = Pattern.compile(pattern);
        	Matcher matcher = ptrn.matcher(inputString);  
        	if(matcher.find()) {
        		System.out.println("norm"); 
        		return inputString;
        	}
        	else {
        		System.out.println("Вы ввели не допустимые символы, полный путь к файлу заново"); 
        		continue;
        }
		}

    	} 
    }



  
  
