package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;


import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    public UsersController() {
    }

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    // метод возвращающий всех людей передает всех юзеров на представление
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }


    // Получение одного юзера по id о передача его на представление
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        return "show";
    }

    @GetMapping("/del{idDelete}")
    public String showDelete(@PathVariable("idDelete") Long id, Model model) {
        model.addAttribute("user", userService.findOne(id)); //getUserById(id));
        return "showDelete";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) { // проверка на валидность введ данных
        if (bindingResult.hasErrors())
            return "newUser";

        userService.save(user); // addUser(user);
        return "redirect:/users";

    }
// методы для обновления данных юзера  /users/3/edit //
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,          // если ошибки, возврат на страницу редактир
                         BindingResult bindingResult,@PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "edit";
        userService.update(id, user);
        return "redirect:/users";
    }

// метод для удаления юзера
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
