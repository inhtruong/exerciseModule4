package com.codegym.config;


import com.codegym.repository.ITransferDTORepository;
import com.codegym.repository.IUserRepository;
import com.codegym.repository.impl.TransferDTORepositoryImpl;
import com.codegym.repository.impl.UserRepositoryImpl;


import com.codegym.service.ITransferDTOService;
import com.codegym.service.ITransferService;
import com.codegym.service.IUserService;


import com.codegym.service.impl.TransferDTOServiceImpl;
import com.codegym.service.impl.TransferServiceImpl;
import com.codegym.service.impl.UserServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan("com.codegym.controller")
public class AppConfiguration implements WebMvcConfigurer{

//    private ApplicationContext applicationContext;

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }

    @Bean
    public IUserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public IUserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public ITransferDTORepository transferDTORepository() {
        return new TransferDTORepositoryImpl();
    }

    @Bean
    public ITransferDTOService transferDTOService() {
        return new TransferDTOServiceImpl();
    }

    @Bean
    public ITransferService transferService() {
        return new TransferServiceImpl();
    }
    //Cấu hình Thymleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("validation");
        return messageSource;
    }
}
