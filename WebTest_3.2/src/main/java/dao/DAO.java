package dao;

import java.sql.ResultSet;

 
public interface DAO {
    public ResultSet query(String query);
    public boolean execute(String query);
    public int executeInsert(String query);

}
