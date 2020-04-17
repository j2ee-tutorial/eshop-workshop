package com.tasnim.trade.eshop.web.controller;

import com.tasnim.trade.eshop.api.UserMapper;
import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.dto.UserDto;
import com.tasnim.trade.eshop.to.Product;
import com.tasnim.trade.eshop.to.User;
import com.tasnim.trade.eshop.util.JsonUtil;
import com.tasnim.trade.eshop.web.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/user")
@Controller
public class UserController {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserMapper mapper;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        LOGGER.info("Redirecting to login page ...");
        if (error != null) {
            LOGGER.warn("Your username and password is invalid.");
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            LOGGER.info("You have been logged out successfully.");
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "/user/login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        LOGGER.info("Redirecting to registration page ...");
        model.addAttribute("user", new UserDto());
        return "user/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") UserDto user, BindingResult bindingResult) {
        LOGGER.info("Save user information");
        LOGGER.info("{}", JsonUtil.jsonObject(user));

        // userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }

        userService.save(mapper.toUser(user));

        // securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

        LOGGER.info("Redirecting to index");
        return "user/profile";
    }

    @GetMapping("/profile")
    public String profile() {
        return "user/profile";
    }

    @PostMapping("/save")
    public String save(UserDto user, Model model) {
        LOGGER.info(JsonUtil.jsonObject(user));
        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size) {
        LOGGER.info("Show all products");

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<User> userPage = userService.findAll(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("userPage", userPage);
        int totalPages = userPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }        return "user/index";
    }
}
