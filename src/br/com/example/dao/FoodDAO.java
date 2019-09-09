package br.com.example.dao;

import java.util.List;

import br.com.example.model.Food;

public interface FoodDAO {
	
	 public void save(Food food);
	    
	 public void edit(Food food);
	    
	 public void delete(int id);

	 public List<Food> getFoods();
}
