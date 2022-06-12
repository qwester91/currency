package currency.main;

import currency.dao.CurrencyDao;
import currency.entity.Currency;

public class Main1 {
    public static void main(String[] args) {
        Currency usd = new Currency();
        usd.setCode("usd");
        usd.setName("dollar");
        usd.setDescription("american money");

        CurrencyDao currencyDao = new CurrencyDao();
        currencyDao.create(usd);
    }
}
