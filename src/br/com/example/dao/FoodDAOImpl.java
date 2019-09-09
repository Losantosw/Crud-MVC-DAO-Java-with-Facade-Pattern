package br.com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.example.model.Food;
import br.com.example.utils.ConnectionFactory;

public class FoodDAOImpl implements FoodDAO{
    Connection conn = null;
    PreparedStatement pstm = null;
    String qry = null;
    ResultSet rs;
    
    @Override
    public void save(Food food) {
        qry = "INSERT INTO foods (name, type, description) VALUES (?,?,?)";
        
        try {  
            conn = new ConnectionFactory().getConnection();
            pstm = conn.prepareStatement(qry);

            this.pstm.setString(1, food.getName());
            this.pstm.setString(2, food.getType());
            this.pstm.setString(3, food.getDescription());

            this.pstm.execute();
            this.pstm.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Comida Inserida Com Sucesso");
            
        }catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer connsulta" + Erro + "SQL" + qry);
        }
    }

    @Override
    public void edit(Food food) {
        qry = "UPDATE foods SET name=?, type=?, description=? WHERE id=?";
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstm = conn.prepareStatement(qry);
            
            this.pstm.setString(1, food.getName());
            this.pstm.setString(2, food.getType());
            this.pstm.setString(3, food.getDescription());
            this.pstm.setInt(5, food.getId());

            this.pstm.execute();
            this.pstm.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Comida Alterado Com Sucesso");
        }catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer connsulta" + Erro + "SQL" + qry);
        }
    }

    @Override
    public void delete(int id) {
        qry = "DELETE FROM foods WHERE id = ?";
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstm = conn.prepareStatement(qry);

            this.pstm.setInt(1, id);

            this.pstm.execute();
            this.pstm.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Foodro Deletado Com Sucesso");
        }catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + qry);
        }
    }

    @Override
    public List<Food> getFoods() {
        List<Food> list = new ArrayList<>();   
        qry = "SELECT * FROM foods";
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstm = conn.prepareStatement(qry);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Food(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("description")
                    )
                );
            }
            this.pstm.close();
            conn.close();
        }catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao busFood a lista" + Erro + "SQL" + qry);
        }

        return list;
    }
    
}