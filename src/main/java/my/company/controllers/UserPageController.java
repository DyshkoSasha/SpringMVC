package my.company.controllers;

import my.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserPageController {
    private final UserService userService;

    public UserPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.selectAll());
        return "users";
    }

    @GetMapping("/adress")
    public String getUsersAdress(Model model, @RequestParam Integer id) {
        model.addAttribute(userService.get(id));
        return "adress";
    }
}
