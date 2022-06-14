package currency.main;

import currency.dao.CurrencyDao;
import currency.entity.Currency;
import currency.service.CurrencyService;

public class Main1 {
    public static void main(String[] args) {
        Currency usd = new Currency();

        usd.setCode("usd");
        usd.setName("dollar");
        usd.setDescription("dengi");


        CurrencyService instance = CurrencyService.getInstance();
        instance.create(usd);
        Currency read = instance.read(1);
        System.out.println(read);
//        currencyDao.create(usd);
        usd.setCode("sas");
        usd.setName("grilop");
        usd.setDescription("sloba");
        instance.update(usd);
        read = instance.read(1);
        System.out.println(read);
    }
}
