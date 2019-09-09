package br.com.example.controller;

import java.util.List;
import javax.swing.JOptionPane;
import br.com.example.facadePattern.FoodFacade;
import br.com.example.model.Food;


public class FoodController {
	FoodFacade cf = new FoodFacade();
    List<Food> foods;
    

    public FoodController() {
        this.cf = new FoodFacade();
    }
    
    public void insert(Food food){
        if(!(food == null 
            || food.getName().trim().isEmpty()
            || food.getType().trim().isEmpty()
            || food.getDescription().trim().isEmpty()
        )){
            cf.save(food);
            JOptionPane.showMessageDialog(null, "Comida Inserida Com Sucesso");
        }else
            JOptionPane.showMessageDialog(null, "Todos os campos são necessários !!!");
    }
    
    public void delete(int id, String food){
        if(JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir o " 
            +  food,"Excluir",JOptionPane.YES_NO_OPTION) == 0){
            cf.delete(id);
            JOptionPane.showMessageDialog(null, "Comida Deletada Com Sucesso");      
        }else
            JOptionPane.showMessageDialog(null, "Cancelado");
    }
    
    public List<Food> getFoods(){
        this.foods = cf.getFoods(); 
        return this.foods;
    }
    
}