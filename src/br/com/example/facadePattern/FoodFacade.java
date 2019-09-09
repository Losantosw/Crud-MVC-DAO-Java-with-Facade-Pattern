package br.com.example.facadePattern;

import java.util.List;

import br.com.example.dao.FoodDAOImpl;
import br.com.example.model.Food;

public class FoodFacade {
	
	FoodDAOImpl fd = new FoodDAOImpl();
    
    public void save(Food food){
        fd.save(food);
    }
    
    public void edit(Food food){
        fd.edit(food);
    }
    
    public void delete(int id){
        fd.delete(id);
    }
    
    public List<Food> getFoods() {
        return fd.getFoods();
    }
}

/*
	O padr�o Facade oculta a complexidade de uma ou mais classes atrav�s de uma 
	fachada. O objetivo do pattern � oferecer uma interface �nica e simplificada
	para um subsistema complexo, fazendo com que o mesmo se torne mais "recicl�vel,
	reutiliz�vel e f�cil de personalizar".
*/
