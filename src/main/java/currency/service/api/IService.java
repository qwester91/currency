package currency.service.api;

public interface IService <T>{
    /**
     * создать запись в базе
     * @param t обьект для записи
     */
    void create(T t);

    /**
     * прочесть обьект из базы
     * @param id обьекта
     * @return обьект который прочитали
     */
    T read(long id);


    /**
     * обновить обьект
     * @param t измененный обьект со старым id
     */
    void update(T t);

    /**
     * удалить обьект по айдишнику
     * @param id
     */
    void delete (long id);


}
