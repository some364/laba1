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
        	String inputString = reader.readLine();
        	String pattern = "[0-9]+";        
        	Pattern ptrn = Pattern.compile(pattern);
        	Matcher matcher = ptrn.matcher(inputString);  
        	if(matcher.matches()) {        		 
        		return inputString;
        	}
        	else {
        		System.out.println("не корректные данные, введите число заново"); 
        		continue;
        }
		}

    	}
	
	public  String regExString () throws IOException  {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
		System.out.println("внутри regExPrice");	
        	String inputString = reader.readLine();
        	String pattern ="([a-zA-Z0-9А-Яа-я]){1}([a-zA-Z0-9А-Яа-я\\s\\-\\\"\\$\\.\\,\\)\\(\\[\\]\\'\\://\\/]){0,}";    // : $ # /  "([a-zA-Z0-9А-Яа-я]){1}([a-zA-Z0-9А-Яа-я\\s\\-\\\"\\\']){0,}"
        	Pattern ptrn = Pattern.compile(pattern);
        	Matcher matcher = ptrn.matcher(inputString);  
        	if(matcher.matches()) {
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
        	String pattern ="([a-zA-Z0-9А-Яа-я]){1}([a-zA-Z0-9А-Яа-я\\s\\-\\\"]){0,}";// "(^|*\\?<>)";        
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



  
  
