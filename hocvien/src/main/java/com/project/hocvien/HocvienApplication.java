package com.project.hocvien;

import com.project.hocvien.services.HocVienServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HocvienApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(HocvienApplication.class, args);
		HocVienServices hocVienServices = applicationContext.getBean(HocVienServices.class);
		Test t = new Test(hocVienServices);
		t.testAll();
	}
}
