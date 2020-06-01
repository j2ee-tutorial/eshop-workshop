package com.tasnim.trade.eshop.web.error;

import com.tasnim.trade.eshop.exception.MyDataIntegrityViolationException;
import com.tasnim.trade.eshop.web.controller.ProductController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(MyDataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(HttpServletRequest request, Exception e) {
        LOGGER.info("Handle Data Integrity Violation Exception");
        // LOGGER.error(e.getMessage(), e);
        LOGGER.error("Requested URL=" + request.getRequestURL());
        LOGGER.error("Exception Raised=" + e);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
