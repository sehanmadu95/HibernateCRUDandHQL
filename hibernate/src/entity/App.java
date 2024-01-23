package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();


            //HQL: hibernate Query language
            session.createQuery("delete from users where userId=4").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("DELETED...");

        }finally {
            session.close();
            factory.close();
        }

        /*new App().saveData();*/

    }




    public void saveData(){
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {
            //create object of entity class type
            users user=new users("Shehan 4","123","shehan 4","madushanka 4");

            //start transaction
            session.beginTransaction();

            //perform operation
            session.save(user);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Data save successfully....");
        }finally {
            session.close();
            factory.close();
        }
    }

    public void getData(){
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {
            //create object of entity class type
            users user=new users();

            //start transaction
            session.beginTransaction();

            //perform operation
            user=session.get(users.class,2);


            //commit the transaction
            session.getTransaction().commit();
            System.out.println(user);

            System.out.println("Data retrieve successfully....");
        }finally {
            session.close();
            factory.close();
        }
    }

    public void update(){
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {
            //create object of entity class type
            users user=new users();

            //start transaction
            session.beginTransaction();

            //perform operation
            user=session.get(users.class,2);

            //updat date using user id
            user.setFirstName("New Shehan");

            //commit the transaction
            session.getTransaction().commit();
            System.out.println(user);

            System.out.println("Data updated successfully....");
        }finally {
            session.close();
            factory.close();
        }
    }

    public void delete(){
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {
            //create object of entity class type
            users user=new users();

            //start transaction
            session.beginTransaction();

            //perform operation
            user=session.get(users.class,2);

            //delete record with user id
            session.delete(user);

            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Data deleted successfully....");
        }finally {
            session.close();
            factory.close();
        }
    }

    public void gtallHQL(){
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //HQL: hibernate Query language
            //old hibernate used .List()
            List<users>listUsers= session.createQuery("from users").getResultList();

            for (users u:listUsers
            ) {
                System.out.println(u);
            }



            //commit the transaction optional here bcz data retrieve
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

    public void whereWithHQL(){
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();

            //HQL: hibernate Query language
            //old hibernate used .List()
            List<users>listUsers= session.createQuery("from users where firstName='Shehan 2'" +"OR firstName='Shehan'")
                    .getResultList();

            for (users u:listUsers
            ) {
                System.out.println(u);
            }



            //commit the transaction
            //session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

    public void updateHSQL(){
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();


            //HQL: hibernate Query language
            session.createQuery("UPDATE users SET password='new123' where userId=5 ").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }

    }

    public void deleteHQL(){
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(users.class)
                .buildSessionFactory();


        Session session=factory.getCurrentSession();

        try {

            //start transaction
            session.beginTransaction();


            //HQL: hibernate Query language
            session.createQuery("delete from users where userId=1").executeUpdate();

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("DELETED...");

        }finally {
            session.close();
            factory.close();
        }
    }
}
