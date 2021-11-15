package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.vo.StudentVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class MainController {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("sendData")
	public String sendData(Model model) {
		
		String[] name = { "a", "b", "c" };
		
		HashMap<String, StudentVo> score = new HashMap<String, StudentVo>();
		
		StudentVo studentVo = new StudentVo();
		studentVo.setEngliash(100);
		studentVo.setKorean(100);
		studentVo.setMath(100);
		score.put("a", studentVo);
		
		studentVo.setEngliash(90);
		studentVo.setKorean(90);
		studentVo.setMath(90);
		score.put("b", studentVo);
		
		studentVo.setEngliash(80);
		studentVo.setKorean(80);
		studentVo.setMath(80);
		score.put("c", studentVo);
		
		studentVo.setEngliash(50);
		studentVo.setKorean(50);
		studentVo.setMath(50);
		score.put("a", studentVo);
		
		Gson gson = new GsonBuilder().create();
		
		String test = gson.toJson(score);
		
		model.addAttribute("name", name);
		model.addAttribute("score", test);
		
		return "sendData";
	}
	
}
