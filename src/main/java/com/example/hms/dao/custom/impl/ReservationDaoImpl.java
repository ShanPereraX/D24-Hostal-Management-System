package com.example.hms.dao.custom.impl;

import com.example.hms.dao.custom.ReservationDao;
import com.example.hms.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {

    @Override
    public Boolean save(Reservation entity, Session session) throws RuntimeException {
        session.save(entity);
        return true;
    }

    @Override
    public Boolean update(Reservation entity, Session session) {
        Transaction transaction = session.getTransaction();
        try (session) {
            transaction.begin();
            session.update(entity);
            transaction.commit();
            return true;
        } catch (RuntimeException exception) {
            transaction.rollback();
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Boolean delete(Reservation entity, Session session) {
        session.delete(entity);
        return true;
    }

    @Override
    public Reservation view(Reservation entity, Session session) {
        return null;
    }

    @Override
    public List<Reservation> getAll(Session session) {
        try (session) {
            String sql = "From Reservation";
            Query query = session.createQuery(sql);
            List<Reservation> list = query.list();
            return list;
        }
    }

    @Override
    public String getLastId(Session session) {
        try (session) {
            Query query = session.createQuery("SELECT res_id FROM Reservation ORDER BY res_id DESC");
            query.setMaxResults(1);
            List results = query.list();
            return (results.size() == 0) ? null : (String) results.get(0);
        }
    }
}