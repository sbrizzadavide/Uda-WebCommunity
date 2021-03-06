/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapping.Evento;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FSEVERI\sbrizza3331
 */
public class DAOEventi {
    
    private final SessionFactory sessionFactory=hibernate.HibernateUtil.getSessionFactory();
    
    public Integer addEvento(int id, String titolo, String luogo, Calendar data){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        Integer idEvento=null;

        try{
            tx=session.beginTransaction();
            Evento event=new Evento(id, titolo, luogo, data);
            idEvento=(Integer) session.save(event);
            tx.commit();    
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return idEvento;
    }
        
        
    public List<Evento> showEventi(){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List listaE=null;
        try{
            tx=session.beginTransaction();
            listaE = session.createQuery("From Evento").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaE;
      
    }
    
    public List<Evento> showEventiSvolti(){
        Session session =sessionFactory.openSession();
        Transaction tx=null;
        List listaE=null;
        
        try{
            tx=session.beginTransaction();
            listaE=session.createQuery("From Evento Where data<current_date() Order by luogo").list();
            tx.commit();
        }catch(HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return listaE;
    }
}
