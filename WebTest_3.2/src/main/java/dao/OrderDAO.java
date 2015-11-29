package dao;

import interseptors.LoggingInterceptor;
import entity.Event;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class OrderDAO {
    @Inject
    private DAO db;

    public Event create(Event event) {

        String tableName = event.tableName;

        int lastInsertedId = db.executeInsert("INSERT INTO " + tableName + " (eventId, name, type, mdate)" +
                " VALUES (" +
                event.getEventId() + ",\"" +
                event.getName() + "\", \"" +
                event.getType() + "\"," +
                event.getMdate() +
                ");");
        event.setEventId(lastInsertedId);

        return event;
    }

    public Event read(int id) {
        String tableName = Event.tableName;
        Event event = new Event();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE eventId = " + id);

        try {
            if (resultSet.next()) {
                event.setEventId(resultSet.getInt(1));
                event.setName(resultSet.getString(2));
                event.setType(resultSet.getString(3));
                event.setMdate(resultSet.getString(4));

                return event;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(int id) {
        String tableName = Event.tableName;
        db.execute("DELETE FROM " + tableName + " WHERE eventId = " + id );
    }

    public void update(Event event) {
        String tableName = Event.tableName;

        db.execute("UPDATE " + tableName + " SET " +
                "eventId = " + event.getEventId() + ", " +
                "name = \"" + event.getName() + "\", " +
                "type = \"" + event.getType() + "\"," +
                "mdate = \"" + event.getMdate() + "\" " +
                "WHERE eventId = " + event.getEventId());
    }

    public List<Event> findByBranch(String type) {
        String tableName = Event.tableName;

        ArrayList<Event> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE type = \"" + type + "\";");

        try {
            while (resultSet.next()) {
                Event event = new Event();

                event.setEventId(resultSet.getInt(1));
                event.setName(resultSet.getString(2));
                event.setType(resultSet.getString(3));
                event.setMdate(resultSet.getString(4));

                list.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Event> findByName(String name) {
        String tableName = Event.tableName;

        ArrayList<Event> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + " WHERE name = \"" + name + "\";");

        try {
            while (resultSet.next()) {
                Event event = new Event();

                event.setEventId(resultSet.getInt(1));
                event.setName(resultSet.getString(2));
                event.setType(resultSet.getString(3));
                event.setMdate(resultSet.getString(4));

                list.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Event> findAll() {
        String tableName = Event.tableName;

        ArrayList<Event> list = new ArrayList<>();

        ResultSet resultSet = db.query("SELECT * FROM " + tableName + ";");

        try {
            while (resultSet.next()) {
                Event event = new Event();

                event.setEventId(resultSet.getInt(1));
                event.setName(resultSet.getString(2));
                event.setType(resultSet.getString(3));
                event.setMdate(resultSet.getString(4));

                list.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
