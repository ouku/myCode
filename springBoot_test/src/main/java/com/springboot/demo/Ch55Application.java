package com.springboot.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.vo.Author;

/**
 * springBoot 入口类
 * @author LM
 * springBoot--page : 155
 */
@RestController//组合注解 @Controller 和 @ResponseBody
@SpringBootApplication//扫描当前包及其子包
public class Ch55Application {
	
	@Autowired
	private Author author;
	
	@Value("${book.name}")
	private String bookname;
	@Value("${book.another}")
	private String bookanother;
	
	@RequestMapping("/")
	String index() {
		return  "bookname : "+bookname+"  bookanother :"+bookanother+" --"
				+ "- "+author.getName()+" "+author.getSex();
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public List returnMSG() {
		System.out.println("你好git");
		System.out.println("你好git");
		return null;
	} 
	public static void main(String[] args) {
		SpringApplication.run(Ch55Application.class, args);
	}
}
