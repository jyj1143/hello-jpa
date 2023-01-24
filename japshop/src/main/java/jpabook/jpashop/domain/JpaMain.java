package jpabook.jpashop.domain;

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

            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // 회원 저장
            Member member = new Member();
            member.setName("member1");

            // 연관관계의 주인에 값 입력
            member.setTeam(team);
            em.persist(member);

            // 역방향(주인이 아닌 방향) 연관관계 설정
            // team.getMembers().add(member);

            // 1차 캐시 DB와 동기화
            /*em.flush();
            em.clear();*/

            System.out.println("====================");
            Team findTeam = em.find(Team.class, team.getId());
            System.out.println("====================");

            List<Member> members = findTeam.getMembers();
            for (Member m : members) {
                System.out.println("m.getName() = " + m.getName());
            }
            System.out.println("====================");


//            Member member = new Member();
//            member.setName("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);
//
//            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
