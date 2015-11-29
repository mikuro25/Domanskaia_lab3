package dao;

import entity.Type;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO {
    @Inject
    private DAO db;

    public Type create(Type type) {
        String tableName = Type.tableName;

        int lastInsertedId = db.executeInsert("INSERT INTO " + tableName + " (typeId, name) VALUES (" +
                type.getTypeId() + ",\"" +
                type.getName() + "\");");
        type.setTypeId(lastInsertedId);

        return type;
    }

    public Type read(int id) {
        String tableName = Type.tableName;
        Type type = new Type();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE typeId = " + id);

        try {
            if (resultSet.next()) {
                type.setTypeId(resultSet.getInt(1));
                type.setName(resultSet.getString(2));

                return type;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(int id) {
        String tableName = Type.tableName;

        db.execute("DELETE FROM " + tableName + " WHERE typeId = " + id );
    }

    public void update(Type type) {
        String tableName = Type.tableName;

        db.execute("UPDATE " + tableName + " SET typeId = " + type.getTypeId() +
                                                ", name = \"" + type.getName() +
                                                "\" WHERE typeId = " + type.getTypeId());
    }

    public List<Type> findAll() {

        String tableName = Type.tableName;
        ArrayList<Type> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + ";");

        try {
            while (resultSet.next()) {
                Type type = new Type();

                type.setTypeId(resultSet.getInt(1));
                type.setName(resultSet.getString(2));

                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
