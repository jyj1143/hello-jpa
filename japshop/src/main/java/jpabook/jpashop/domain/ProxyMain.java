package jpabook.jpashop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class ProxyMain {

    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {


//            Member member = new Member();
//            member.setName("hello");
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember.getClass() = " + findMember.getClass());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            Member member1 = new Member();
            member1.setName("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference.getClass() = " + reference.getClass());

            Member m1 = em.find(Member.class, member1.getId());
            System.out.println("m1.getClass() = " + m1.getClass());

            System.out.println("m1 == reference : " + (m1 == reference));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }

    private static void printMember(Member member) {
        String name = member.getName();
        System.out.println("name = " + name);
    }

    private static void printMemberAndTeam(Member member) {
        String name = member.getName();
        System.out.println("name = " + name);

        Team team = member.getTeam();
        System.out.println("team.getName() = " + team.getName());

    }


}
