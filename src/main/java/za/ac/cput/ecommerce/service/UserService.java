package za.ac.cput.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ecommerce.domain.User;
import za.ac.cput.ecommerce.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User save (User user){
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);

    }
    @Override
    public void deletebyId(String id){
        userRepository.deleteById(id);
    }

    @Override
    public User findbyId(String id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
