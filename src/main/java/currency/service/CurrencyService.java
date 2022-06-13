package currency.service;

import currency.dao.CurrencyDao;
import currency.entity.Currency;
import currency.service.api.IService;

import java.time.LocalDateTime;

public class CurrencyService implements IService<Currency> {
    private static final CurrencyService instance = new CurrencyService();

    private CurrencyDao dao = CurrencyDao.getInstance();

   private CurrencyService() {
    }

    @Override
    public void create(Currency currency) {
        if (currency.getName()!= null & currency.getCode()!= null & currency.getDescription()!=null){
            LocalDateTime now = LocalDateTime.now();
            currency.setCreateTime(now);
            currency.setUpdateTime(now);
            dao.create(currency);
        }else {
            throw new IllegalArgumentException("переданы не валидные значения");
        }
    }

    @Override
    public Currency read(long id) {
        Currency currency = null;
       if (id > 0){
           currency = dao.read(id);
       }
       if (currency == null){
           throw new IllegalArgumentException("запись не существует");
       }
        return currency;
    }

    @Override
    public void update(Currency currency) {
        if (currency.getName()!= null & currency.getCode()!= null & currency.getDescription()!=null & currency.getId()>0){
            LocalDateTime now = LocalDateTime.now();
            currency.setUpdateTime(now);
            dao.update(currency);
        }else {
            throw new IllegalArgumentException("переданы не валидные значения");
        }

    }

    @Override
    public void delete(long id) {

        if (id > 0){
            dao.delete(id);
        }


    }

    public static CurrencyService getInstance() {
        return instance;
    }
}
