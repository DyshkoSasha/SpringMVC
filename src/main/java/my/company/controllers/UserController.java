package my.company.controllers;

import lombok.AllArgsConstructor;
import my.company.model.Adress;
import my.company.model.Role;
import my.company.model.User;
import my.company.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@RequestMapping(value = "/user")
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> allUser = userService.findAllUser();
        model.addAttribute("allUser", allUser);
        return "users";
    }

    @GetMapping(value ="/adress")
    public String getUsersAdress(Model model, @RequestParam Long id) {
        model.addAttribute(userService.getById(id));
        return "adress";
    }

    @GetMapping("/add")
    public String getPageSave(Model model, User user, @RequestParam(required = false) Long id) {
        if (id != null) {
            model.addAttribute(userService.getById(id));
        }
        return "userForm";
    }

    @PostMapping
    public String saveUsers(@RequestParam(required = false) Long id,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam Integer age,
                            @RequestParam String password,
                            @RequestParam(name = "adress.city") String city,
                            @RequestParam(name = "adress.street") String street,
                            @RequestParam(name = "adress.house") String house,
                            @RequestParam String role) {

        User user = new User(id, firstName, lastName, age, password, new Adress(city, street, house),
               new Role(role));
        userService.addUser(user);
        return "redirect:/user";
    }
}
