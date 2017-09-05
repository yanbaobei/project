package com.zhidisoft.blog.admin.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zhidisoft.blog.admin.entity.Article;
import com.zhidisoft.blog.admin.entity.ArticleType;
import com.zhidisoft.blog.admin.service.IArticleService;
import com.zhidisoft.blog.admin.service.IArticleTypeService;
import com.zhidisoft.blog.admin.vo.ArticleVo;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	IArticleService articleService;

	@Autowired
	IArticleTypeService articleTypeService;

	@GetMapping("/save")
	public ModelAndView saveUI() {
		List<ArticleType> articleTypeList = articleTypeService.findAll();
		ModelAndView mav = new ModelAndView("article/form.html");
		mav.addObject("typeList", articleTypeList);
		return mav;
	}

	/**
	 * @Valid 400报错可能问题 BindingResult 参数顺序不对 <br/>
	 * @Valid ArticleVo articleVo, BindingResult result <br/>
	 *        TODO HttpSession 是否可以提出来<br/>
	 * @param articleVo
	 * @param session
	 * @param result
	 * @return
	 */
	@PostMapping("/save")
	public ModelAndView save(@Valid ArticleVo articleVo, BindingResult result, HttpSession session,
			RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/article/list");
		if (result.hasErrors()) {
			// return "redirect:/error";
			// 1.转发
			// mav = new ModelAndView("/common/error.html");
			// mav.addObject("errorList", result.getAllErrors());

			// 2.重定向传递参数
			mav = new ModelAndView("redirect:/common/err");
			redirectAttributes.addFlashAttribute("errorList", result.getAllErrors());
			return mav;
		}
		Article article = new Article();
		article.setId(UUID.randomUUID().toString().replace("-", ""));
		article.setUserId(session.getAttribute("userId").toString());
		article.setInfo(articleVo.getInfo());
		article.setInfoTitle(articleVo.getInfoTitle());
		article.setTypeId(articleVo.getTypeId());
		article.setTitle(articleVo.getTitle());
		articleService.save(article);
		return mav;
	}

	/*
	 * @PostMapping("/save")
	 * 
	 * @ResponseBody public AjaxVo save(Article article){
	 * article.setId(UUID.randomUUID().toString().replace("-", ""));
	 * articleService.save(article); return new AjaxVo().setErrorCode("0"); }
	 */
	
	
}
