package Lab1v2;


import java.io.IOException;


public class Controller {
	
	
	public String addDish(String name, String category, int price) {
		Model m = new Model();
		return m.add(name, category, price);
		
	}
	public String removeDish (String nameToRemove) {
		Model m = new Model();
		return m.remove(nameToRemove);
	}
	
	public String updateDish(String nameOld, String nameNew, String category, int price ) {
		Model m = new Model();
		return m.update(nameOld, nameNew, category, price);
	}
	
	public String uploadFile(String fileName) {
		Model m = new Model();
		String feedBack = "";	
		try {
			feedBack = m.copyFile(fileName);
		} catch (IOException e) { //
			System.out.println(e +" файл не найден");
			e.printStackTrace();
		}	
		return feedBack;		
	}
	
	public MenuDish showMenu() {
		Model m = new Model();
		return m.showData();
	}	
	
}
