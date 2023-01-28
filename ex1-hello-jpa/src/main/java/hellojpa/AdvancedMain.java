package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AdvancedMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Movie movie = new Movie();
            movie.setActor("로버트 다우니 주니어");
            movie.setDirector("존 파브로");
            movie.setName("아이언맨");
            movie.setPrice(10000);
            em.persist(movie);

            em.flush();
            em.clear();

            Item findMovie = em.find(Item.class, movie.getId());
            System.out.println("findMovie.getId() = " + findMovie.getId());
            System.out.println("findMovie.getName() = " + findMovie.getName());
            System.out.println("findMovie.getPrice() = " + findMovie.getPrice());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
