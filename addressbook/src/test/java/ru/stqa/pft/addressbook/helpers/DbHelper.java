package ru.stqa.pft.addressbook.helpers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.models.Contacts;
import ru.stqa.pft.addressbook.models.GroupAdressData;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public Groups groups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery("from GroupData").list();
        session.getTransaction().commit();
        session.close();
        return new Groups(result);
    }

    public Contacts contacts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupAdressData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
        session.getTransaction().commit();
        session.close();
        return new Contacts(result);
    }

    public GroupAdressData getContact(Integer id) {
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            List<GroupAdressData> result =session.createQuery("from ContactData where id=:id").setParameter("id",id).list();
            session.getTransaction().commit();
            session.close();
            return result.get(0);
          }

          public GroupData getGroup(Integer id) {
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            List<GroupData> result =session.createQuery("from GroupData where id=:id").setParameter("id",id).list();
            session.getTransaction().commit();
            session.close();
            return result.get(0);
          }
}