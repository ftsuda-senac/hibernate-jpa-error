package com.example.datajpaerror;

import static org.assertj.core.api.Assertions.assertThat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.Test;
import com.example.datajpaerror.entities.A;
import com.example.datajpaerror.entities.B;

class AppTest {

    @Test
    void runTest() {

        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hbm-em");
            EntityManager em = entityManagerFactory.createEntityManager();

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            String aIdOne = "boo";

            A a2 = new A(aIdOne, "baa");
            B b = new B("some2", "thing2");
            em.persist(a2);
            a2.setB_R1(b);
            b.setA_R1(a2);
            em.persist(b);

            transaction.commit();

            A result = em.createQuery("SELECT a FROM A a WHERE a.id.aOne = :param", A.class)
                    .setParameter("param", aIdOne)
                    .getSingleResult();
            // @formatter:off
            System.out.println("===== RESULT:"
                    + "\nA.id.aOne = "+ result.getId().getAOne()
                    + "\nA.id.aTwo = " + result.getId().getATwo()
                    + "\nB.id.bOne = " + result.getB_R1().getId().getBOne()
                    + "\nB.id.bTwo = " + result.getB_R1().getId().getBTwo());
            // @formatter:on
            assertThat(result.getId().getAOne()).isEqualTo(aIdOne);

            em.close();
            entityManagerFactory.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
