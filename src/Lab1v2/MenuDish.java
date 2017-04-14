package Lab1v2;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name = "Menu")
public class MenuDish {

  
    @XmlElementWrapper(name = "dishList")
   
    @XmlElement(name = "Dish")
    private List<Dish> dishlist;
    
    public void setDishList(List<Dish> dishlist) {
        this.dishlist = dishlist;
}

public List<Dish> getDishlist() {
        return dishlist;

  }
}
