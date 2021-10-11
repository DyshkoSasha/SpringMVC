package my.company.controllers;

import lombok.RequiredArgsConstructor;
import my.company.model.User;
import my.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> allUser = userService.findAllUser();
        model.addAttribute("allUser", allUser);
        return "users";
    }

    @GetMapping(value ="/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.selectAll());
        return "users";
    }
}
