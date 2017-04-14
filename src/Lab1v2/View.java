package Lab1v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;



public class View {
	private static boolean isFlag;	
	
	public static void main (String[] args) throws IOException {
		
		System.out.println("���� �� ������ �������� ����� ����� ������� 1, ����� � ������ ����� ������ ������� �������� �����, ��������� � ����.");
		System.out.println("���� �� ������ �������  ����� ������� 2, ����� ������� �������� �����.");
		System.out.println("���� �� ������ ��������  ����� ������� 3, ����� ������� � ������ ����� ������ �������� ����� ������� �� ������ ���������, ����� ����� ��������, ��������� � ����.");
		System.out.println("���� �� ������ ����������� ���� � ������� ������� 4 � ������� ������ ���� � �����.");
		System.out.println("���� �� ������ ����������� ��� ����� � ���� ������� 5.");
		System.out.println("���� �� ������ ����� �� ��������� ������� Hasta la vista baby.");
	//	resources/DishMenu.xml 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
	   do {
    	   String order = reader.readLine();
    	   switch(order) {
    	   
       case "1":
    	 System.out.println("���������� �����. � ������ ����� ������ ������� �������� �����, ��������� � ���� ����� �������� �� ������ ��������.");    	   
    	   String[] dishData = new String[3];
     		for(int i =0; i < dishData.length; i++) {
      			String newOrder = reader.readLine();
     			dishData[i] = newOrder;
     			}
    	
   	       Controller c1 = new Controller();
   	       System.out.println(c1.addDish(dishData[0], dishData[1], Integer.valueOf(dishData[2]) ));  // ���� :)
       	   continue;
    	   
       case "2":
    	   System.out.println("�������� �����. ������� �������� ����� ������� �� ������ �������");
       	   String newOrder2 = reader.readLine();
    	   Controller c2 = new Controller();
    	   System.out.println(c2.removeDish(newOrder2));
    	   continue;
    	   
       case "3":
    	   System.out.println("��������� �����. ������� � ������ ����� ������ �������� ����� ������� �� ������ ���������, ����� ����� ��������, ��������� � ����.");
    	   String[] dishData3 = new String[4];
      		for(int i =0; i < dishData3.length; i++) {
       			String newOrder3 = reader.readLine();
      			dishData3[i] = newOrder3;
      			}
      		
      		Controller c3 = new Controller();
      		System.out.println(c3.updateDish(dishData3[0], dishData3[1], dishData3[3], Integer.valueOf(dishData3[3]))); // �����
    	   continue;
    	   
       case "4":
    	   System.out.println("����������� �����. ������� ������ ���� � �����.");
    	   String newOrder4 = reader.readLine();
    	   Controller c4 = new Controller();
    	   System.out.println(c4.uploadFile(newOrder4));    	   
      	   continue;
    	   
       case "5":
    	   System.out.println("������ ����.\n");
    	   MenuDish menuDish;
       	   Controller c5 = new Controller();
       	   menuDish =c5.showMenu();
       	   List<Dish> Dishlist = menuDish.getDishlist();
       	   for(Dish dish: Dishlist) {
       		   System.out.println(dish.getName() + ", " + dish.getCategory().get(0).getCategoryName() + ", " +dish.getPrice());
       	   }       	   
    	   continue;
    	   
       case "Hasta la vista baby":       	   
    	   isFlag = true;
    	   continue;
    	   
    	default :
    		System.out.println("�� ������� �������� ��������.");
    	   } 
        }
       while (!isFlag); 

		System.out.println("��������� ���������.");
		
		
		
	}
	
}
