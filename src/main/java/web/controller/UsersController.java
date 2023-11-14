package web.controller;

import hiber.service.UserService;
import hiber.service.UserServiceImp;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userServiceImp;

    @Autowired
    public UsersController(UserService userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping()
    public String printUsersOrShowUserById(
            Model model, @RequestParam(name = "id",
            required = false) Integer userId) {
        if (userId == null) {
            model.addAttribute("users", userServiceImp.printUsers());
            return "users";
        } else {
            model.addAttribute("user", userServiceImp.showUserById(userId));
            return "show";
        }
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userServiceImp.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("user", userServiceImp.showUserById(id));
        return "edit";
    }

    @PostMapping
    public String update(@ModelAttribute("user") User user, @RequestParam(name = "id") int id) {
        userServiceImp.update(id, user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(@RequestParam(name = "id") int id) {
        userServiceImp.delete(id);
        return "redirect:/users";
    }
 }


