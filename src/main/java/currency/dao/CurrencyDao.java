package currency.dao;

import currency.dao.api.Idao;
import currency.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDateTime;

public class CurrencyDao implements Idao<Currency> {

    private final static CurrencyDao instance = new CurrencyDao();
   private EntityManager entityManager = EntityManagerFactory.getInstance().getManager();

    private CurrencyDao() {
    }

    @Override
    public void create(Currency currency) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(currency);
        transaction.commit();
    }

    @Override
    public Currency read(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Currency currency = entityManager.find(Currency.class, id);
        transaction.commit();
        return currency;
    }


      @Override
    public void update(Currency t) {
          EntityTransaction transaction = entityManager.getTransaction();
          transaction.begin();
          Currency currency = entityManager.find(Currency.class, t.getId());
          currency.setDescription(t.getDescription());
          currency.setCode(t.getCode());
          currency.setName(t.getName());
          currency.setUpdateTime(LocalDateTime.now());

          transaction.commit();


    }

    @Override
    public void delete(long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Currency currency = entityManager.find(Currency.class, id);
        entityManager.remove(currency);

        transaction.commit();
    }

    public static CurrencyDao getInstance() {
        return instance;
    }
}
