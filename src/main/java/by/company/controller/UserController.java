package by.company.controller;

import by.company.model.User;
import by.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping(value = "/add")
    public String getPageSave(Model model, User user) {
        model.addAttribute(user);
        return "userForm";
    }

    @PostMapping
    public String saveUsers(@RequestParam Long id, @RequestParam String name,
                            @RequestParam String lastName, @RequestParam String email) {
        User user = new User(id, name, lastName, email);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/update")
    public String getPageUpdate(Model model, @RequestParam Long id) {
        model.addAttribute(userService.get(id));
        return "userForm";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
