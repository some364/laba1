package Lab1v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValTest {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for(;;) {
		System.out.println("внутри regExPrice");	
        	String inputString = reader.readLine();
        	String pattern ="([a-zA-Z0-9А-Яа-я]){1}([a-zA-Z0-9А-Яа-я\\s\\-\\\"\\$\\.\\,\\)\\(\\[\\]\\'\\:\\\\\\/]){0,}";        
        	Pattern ptrn = Pattern.compile(pattern);
        	Matcher matcher = ptrn.matcher(inputString);  
        	if(matcher.matches()) {
        		System.out.println("norm"); 
        		
        	}
        	else {
        		System.out.println("NE norm"); 
        		continue;
        }
		
	}
	}
}