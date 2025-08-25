package za.ac.cput.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.ecommerce.domain.User;
import za.ac.cput.ecommerce.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/deleteUser{id}")
    public void deleteById(@PathVariable String id) {
        userService.deletebyId(id);
    }
    @GetMapping("/user{id}")
    public User findById(@PathVariable String id) {
        return userService.findbyId(id);
    }
    @GetMapping("/all_user")
    public List<User> findAll() {
        return userService.findAll();
    }
}
