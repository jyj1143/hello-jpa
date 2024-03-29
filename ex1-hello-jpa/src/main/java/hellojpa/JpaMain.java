package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            //조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//
            //수정
//            findMember.setName("HelloJPA");
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            //조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getId() = " + member.getId() +
//                        "member.getName() = " + member.getName());
//            }


//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("Hello100");
//
//            //영속
//            System.out.println("==== BEFORE PERSIST ====");
//            em.persist(member);
//            System.out.println("==== AFTER PERSIST ====");
//
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());


            // 영속
            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);*/

            /*Member member = em.find(Member.class, 150L);
            member.setName("ZZZZ");*/


            /*//엔티티 조회
            Member findMember = em.find(Member.class, 150L);

            // 엔티티 데이터 수정
            findMember.setName("AAAA");

            // 준영속화
            em.detach(findMember);*/

            Member member = new Member();
            member.setUsername("A");
            Member member2 = new Member();
            member2.setUsername("B");

            System.out.println("==========");
            em.persist(member);
            System.out.println("member ID : " + member.getId());
            em.persist(member2);
            System.out.println("member ID : " + member2.getId());
            System.out.println("==========");

            /*Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member1.setUsername("B");

            Member member3 = new Member();
            member1.setUsername("C");

            System.out.println("===============");
//            em.persist(member1);
//            em.persist(member2);
//            em.persist(member3);

            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member2.getId());
            System.out.println("member3 = " + member3.getId());

            System.out.println("===============");*/


            System.out.println("==== BEFORE COMMIT ====");
            tx.commit();
            System.out.println("==== AFTER COMMIT ====");
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
