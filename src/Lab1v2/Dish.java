package Lab1v2;


import java.util.List;

import javax.xml.bind.annotation.XmlType;



@XmlType(propOrder = { "name", "category", "price"})
public class Dish {

      private String name;
      private List<Category> category;
      private int price;
     


      public String getName() {
              return name;
      }

      public void setName(String name) {
              this.name = name;
      }

      public List<Category> getCategory() {
              return category;
      }

      public void setCategory(List<Category> category) {
              this.category = category;
      }

      public int getPrice() {
              return price;
      }

      public void setPrice(int price) {
              this.price = price;
      }

    

}