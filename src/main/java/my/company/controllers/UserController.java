package my.company.controllers;

import lombok.AllArgsConstructor;
import my.company.model.Adress;
import my.company.model.User;
import my.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        userService.deletedById(id);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String getPageSave(Model model, User user, @RequestParam(required = false) Integer id) {
        if (id != null) {
            model.addAttribute(userService.getById(id));
        }
        return "userForm";
    }

    @PostMapping
    public String saveUsers(@RequestParam(required = false) Integer id,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam Integer age,
                            @RequestParam(name = "adress.city") String city,
                            @RequestParam(name = "adress.street") String street,
                            @RequestParam(name = "adress.house") Integer house
    ) {

        User user = new User(id, firstName, lastName, age, new Adress(city, street, house));
        userService.addUser(user);
        return "redirect:/users";
    }
}
