package Lab1v2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

//!
public class Model  { 
	private static final String FILE_NAME = "src/resources/DishMenu.xml"; 
	 boolean flag;
	
	 public String remove(String dishToRemove) {
		String removedFeedBack = null;
		try{
		 JAXBContext context = JAXBContext.newInstance(MenuDish.class);
         Unmarshaller um = context.createUnmarshaller();
         MenuDish menuDish = (MenuDish) um.unmarshal(new File(FILE_NAME));
         List<Dish> dishlist = menuDish.getDishlist(); 
        flag = false; 
         for (Dish dish : dishlist) {
          	 if(dish.getName().equalsIgnoreCase(dishToRemove)) {
          		 dishlist.remove(dish);                
          		 flag  = true;
                 break;
        	 }
         }
         if(flag == false) removedFeedBack = dishToRemove +" �� ������� ������� ��� ��� � ����, ����� ��� �����������"; 
         else removedFeedBack = "����� " +dishToRemove + " �������";
      
         Marshaller m = context.createMarshaller();
         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
         m.marshal(menuDish, new File(FILE_NAME));
         
		}catch (JAXBException e) 
		{
			System.out.println(e);
		}
		return removedFeedBack;
				
	}
	
	 public String add(String name, String nameOfCategory, int price) {
		String addedFeedBack = null;	

		try{
			 JAXBContext context = JAXBContext.newInstance(MenuDish.class);
	         Unmarshaller um = context.createUnmarshaller();
	         MenuDish menuDish = (MenuDish) um.unmarshal(new File(FILE_NAME));
	         List<Dish> dishlist = menuDish.getDishlist(); 
	         boolean flag = false;     
	         for (Dish dish : dishlist) {
	          	 if(dish.getName().equalsIgnoreCase(name)) { 
	    	        flag  = true;
	    	       
	          	    break;
	        	 }
	         }
	         
	         if(flag == true) addedFeedBack =name +" �� �������� ��������, � ���� ��� ���� ����� �����";
	         else {
	        	 Dish addDish = new Dish();
	        	 
	        	 	Category category = new Category();                           
	        	 	category.setCategoryName(nameOfCategory);						
	        	 	List<Category> ListOfCategory = new ArrayList<>();    
	        	 	ListOfCategory.add(category);									
	        	 	
	          		addDish.setCategory(ListOfCategory);
	          		addDish.setName(name);
	          		addDish.setPrice(price);
	          		dishlist.add(addDish);
	          		addedFeedBack =name + " �������� � ����";  
	         }
	         Marshaller m = context.createMarshaller();
	         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	         m.marshal(menuDish, new File(FILE_NAME));
	        

		}
		catch (JAXBException e) 
		{
			System.out.println(e);
		}
		return addedFeedBack;
		 
	}
	
	 public String update(String dishToUpdate, String newName, String newCategory, int newPrice) {
		String updatedFeedBack = null;
		try{
			 JAXBContext context = JAXBContext.newInstance(MenuDish.class);
	         Unmarshaller um = context.createUnmarshaller();
	         MenuDish menuDish = (MenuDish) um.unmarshal(new File(FILE_NAME));
	         List<Dish> dishlist = menuDish.getDishlist(); 
	         boolean locFlag = false;
	         for (Dish dishForLocFlag : dishlist) {
	          	 if(dishForLocFlag.getName().equalsIgnoreCase(newName))  {
	          		locFlag  = true;
	          	    break;
	        	 }
	         }
	         
	         boolean flag = false;
	         if (locFlag == false) {
	         for (Dish dish : dishlist) {
	          	 if (dish.getName().equalsIgnoreCase(dishToUpdate)) {
	          		 
	          		Category category = new Category();                          
	        	 	category.setCategoryName(newCategory);						
	        	 	ArrayList<Category> ListOfCategory = new ArrayList<>();    
	        	 	ListOfCategory.add(category);								
	          		 
	           		dish.setCategory(ListOfCategory);
	          		dish.setName(newName);
	          		dish.setPrice(newPrice);
		          		
	    	        flag  = true;
	          	    break;
	        	 }
	         	}
	         } 
	         
	         if(flag == false) updatedFeedBack =dishToUpdate +" �� �������� ��������, � ���� ��� ������ ����� ��� ��� " + newName +" ��� ������";
	         else {
	        	 updatedFeedBack =dishToUpdate + " ������� �� " + newName;  
	         }
	         Marshaller m = context.createMarshaller();
	         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	         m.marshal(menuDish, new File(FILE_NAME));
	    
	         
		}
		catch (JAXBException e) 
		{
			System.out.println(e);
		}
		return updatedFeedBack;
	
	}
	
	 public String copyFile(String fileToCopy)    throws FileNotFoundException { 
			
			String copiedFileFeedBack = "";
			try{
				 JAXBContext context = JAXBContext.newInstance(MenuDish.class);
		         Unmarshaller um = context.createUnmarshaller();
		         MenuDish menuDish = (MenuDish) um.unmarshal(new File(FILE_NAME));
		         List<Dish> dishlist = menuDish.getDishlist(); 
		         
		         JAXBContext context2 = JAXBContext.newInstance(MenuDish.class);
		         Unmarshaller um2 = context2.createUnmarshaller();			         
		         MenuDish menuDish2 = (MenuDish) um2.unmarshal(new File(fileToCopy));		        
		         List<Dish> dishlist2 = menuDish2.getDishlist(); 
		              		        
		         ArrayList<Dish> dishNoCopied = new ArrayList<>();		         
		         for (Dish dish : dishlist) {		        	 
		        	 Iterator<Dish> dishIter = dishlist2.iterator();
		        	 while(dishIter.hasNext()) {
		        		 Dish d =dishIter.next();		        		 
		        	 		if(dish.getName().equalsIgnoreCase(d.getName())) {
		        	 			dishNoCopied.add(dish);
		        	 			dishIter.remove();
		        	 		}
		        	 }
		        	 	
		         }
		         dishlist.addAll(dishlist2) ;
	
		         if(dishlist2.isEmpty()) copiedFileFeedBack ="���� " +fileToCopy +" �� ��� ��������, ��� ��� � �������� ����� ��� ���� ����� �����.";
		         else if (dishNoCopied.isEmpty()) copiedFileFeedBack ="���� " +fileToCopy + " ����������";
		         	else 
		         {
		         		copiedFileFeedBack ="���� " +fileToCopy + " ����������, "+dishNoCopied.size() + " ����� �� ���� ����������� ����� ����, ��� � �������� ����� ��� ���� ����� �����.";  // ������ � view
		         }
		         Marshaller m = context.createMarshaller();
		         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		         m.marshal(menuDish, new File(FILE_NAME));
		  		         
			}
			catch (JAXBException e ) 
			{
				System.out.println(e);
			}
			return copiedFileFeedBack;
		}

	 public MenuDish showData () {
		MenuDish menuDish = null;
		try{
			 JAXBContext context = JAXBContext.newInstance(MenuDish.class);
	         Unmarshaller um = context.createUnmarshaller();
	         menuDish = (MenuDish) um.unmarshal(new File(FILE_NAME));	        
	         
		}
		catch (JAXBException e ) 
		{
			System.out.println(e);
		}
		return menuDish;
	}
}
