package currency.dao.api;

public interface Idao <T>{
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
     * прочесть обьект из базы
     * @param code код обьекта
     * @return обьект который прочитали
     */
    T read(String code);

    /**
     * изменить обьеки в базе
     * @param t1 обьект который нужно изменить
     * @param t2 обьект на который хотим его заменить
     */
    void update(T t1, T t2);

    /**
     * удалить обьект по айдишнику
     * @param id
     */
    void delete (long id);

    /**
     * удалить обьект по коду
     * @param code
     */
    void delete (String code);


}
