/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.proje;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HilalSener
 */
public class App {
    public static void main(String[] args) throws Exception {
        Session s = HibernateUtil.getSessionFactory().openSession();
        
        Kisiler k = new Kisiler("ÖĞÇŞİöğçşı", "ÖĞÇŞİöğçşı", 33);
        Transaction t = s.beginTransaction();
        s.save(k);
        t.commit();
        s.close();
    }
}
