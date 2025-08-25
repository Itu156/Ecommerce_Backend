package za.ac.cput.ecommerce.service;

import za.ac.cput.ecommerce.domain.User;

import java.util.List;

public interface IUserService extends IService <User,String>{
    List<User> findAll();
}
