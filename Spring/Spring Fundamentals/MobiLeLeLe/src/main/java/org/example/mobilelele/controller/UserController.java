package org.example.mobilelele.controller;

import org.example.mobilelele.model.dtoS.view.UserRoleViewDto;
import org.example.mobilelele.service.role.UserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserRoleService userRoleService;

    public UserController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        List<UserRoleViewDto> roleServiceAll = this.userRoleService.getAll();

        modelAndView.addObject("roles", roleServiceAll);

        return super.view("auth-register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister() {
        return super.redirect("auth-login");
    }
}
