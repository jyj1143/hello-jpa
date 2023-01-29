package jpabook.jpashop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class ValueMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address address1 = new Address("city", "street", "10000");
            Address address2 = new Address("city", "street", "10000");

            System.out.println("address2 == address1 = " + (address2 == address1));
            System.out.println("address1.equals(address2) = " + (address1.equals(address2)));

//            Member member1 = new Member();
//            member1.setName("member1");
//            member1.setHomeAddress(address1);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("member2");
//            member2.setHomeAddress(address2);
//            em.persist(member2);
//
////            member1.getHomeAddress().setCity("NewCity");
//
//            Address newAddress = new Address("NewCity", address1.getStreet(), address1.getZipcode());
//            member1.setHomeAddress(newAddress); // 새롭게 다시 설정

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
