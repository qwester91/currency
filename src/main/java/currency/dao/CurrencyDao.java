package currency.dao;

import currency.dao.api.Idao;
import currency.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CurrencyDao implements Idao<Currency> {

    @Override
    public void create(Currency currency) {
        EntityManager entityManager = EntityManagerFactory.getInstance().getManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(currency);
        transaction.commit();



    }

    @Override
    public Currency read(long id) {
        return null;
    }

    @Override
    public Currency read(String code) {
        return null;
    }

    @Override
    public void update(Currency t1, Currency t2) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void delete(String code) {

    }
}
