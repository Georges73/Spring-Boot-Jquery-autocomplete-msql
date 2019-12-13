package com.demo.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entities.Product;
import com.demo.services.ProductService;
import com.google.gson.Gson;

@Controller
@RequestMapping("product")
public class ProductController {

	String name = "Achille";

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("name", name);

		return "product/index";
	}
	
	// -------------------------------propose le input au DB-------------------------------

	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(HttpServletRequest request) {

		System.err.println(productService.search(request.getParameter("term")));

		return productService.search(request.getParameter("term"));
	}
	
	// ---------------------------------------------------------------------------------------------------------------------

	@RequestMapping(value = "search_full", method = RequestMethod.GET)
	@ResponseBody
	public String searchFull(HttpServletRequest request) {
		
		String keyword = request.getParameter("inputParam");

		//System.err.println(productService.search(request.getParameter("keyword").toString()));
		
		Gson gson = new Gson();

		return gson.toJson( productService.searchFull(keyword));
	}

}