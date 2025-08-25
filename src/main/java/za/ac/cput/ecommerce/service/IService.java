package za.ac.cput.ecommerce.service;

public interface IService <T,ID>{

    T save(T t);
    T update(T t);
    void deletebyId(ID id);
    T findbyId(ID id);
}
