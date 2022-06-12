package currency.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerFactory {
    private EntityManager manager;
    private static final EntityManagerFactory instance = new EntityManagerFactory();

    private EntityManagerFactory() {
        jakarta.persistence.EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("entity");
        this.manager = managerFactory.createEntityManager();
    }

    public EntityManager getManager() {
        return manager;
    }

    public static EntityManagerFactory getInstance(){
        return instance;
    }

}
