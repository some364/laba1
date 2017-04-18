package Lab1v2;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement (name = "Menu")
public class MenuDish {

  
    @XmlElementWrapper(name = "dishList")
   
    @XmlElement(name = "Dish")
    private List<Dish> dishList;
    
    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
}

public List<Dish> getDishlist() {
        return dishList;

  }
}
