package com.tasnim.trade.eshop.web.validator;

import com.tasnim.trade.eshop.api.UserService;
import com.tasnim.trade.eshop.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class UserValidator implements Validator {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserValidator.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserDto user = (UserDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.could.not.be.empty");

        if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "username.must.be.between.min.and.max.characters", new Object[]{4, 32}, null);
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "username.already.exists");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.could.not.be.empty");

        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "password.should.be.at.least.min.characters.long", new Object[]{4}, null);
        }

        if (!Objects.equals(user.getPasswordConfirm(), user.getPassword())) {
            errors.rejectValue("passwordConfirm", "password.does.not.math.confirm.password");
        }
    }
}