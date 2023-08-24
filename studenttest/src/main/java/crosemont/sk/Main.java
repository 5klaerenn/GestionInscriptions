package crosemont.sk;

import org.hibernate.*;

import java.lang.module.Configuration;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory;
        Session session = null;



        System.out.println("Hello world!");
    }
}