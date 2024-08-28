package test.com.thymeleaf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestWebConfig implements WebMvcConfigurer{

	//웰컴파일을 지정지정 메소드 추가가능 - http://localhost:8801/  <<<< index.html
	//static/index.html파일 생성
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.html");
	}
	
}
