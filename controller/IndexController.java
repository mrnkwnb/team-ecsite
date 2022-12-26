package jp.co.internous.utopia.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.utopia.model.domain.MstCategory;
import jp.co.internous.utopia.model.domain.MstProduct;
import jp.co.internous.utopia.model.form.SearchForm;
import jp.co.internous.utopia.model.mapper.MstCategoryMapper;
import jp.co.internous.utopia.model.mapper.MstProductMapper;
import jp.co.internous.utopia.model.session.LoginSession;

@Controller
@RequestMapping("/utopia")
public class IndexController {

	@Autowired
	LoginSession loginSession;
	
	@Autowired
	MstProductMapper productMapper;
	
	@Autowired
	MstCategoryMapper categoryMapper;

	List<MstProduct> mstProduct;
	List<MstCategory> mstCategory;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		int guestId = loginSession.getGuestId();
		
		if(!loginSession.isLoginflg() && guestId == 0) {
			int max = 999_999_999;
			int min = 100_000_000;
			int random = new Random().nextInt(max - min +1) + min;
			guestId = random * -1;
			
			loginSession.setGuestId(guestId);
		}
		
		mstProduct = productMapper.findAll();
		mstCategory = categoryMapper.findAll();
		
		model.addAttribute("mstProduct", mstProduct);
		model.addAttribute("mstCategory", mstCategory);
		model.addAttribute("selected", 0);
		
		model.addAttribute("loginSession", loginSession);
		
		return "index";
	}

	@RequestMapping("/searchItem")
	public String search(SearchForm searchForm, Model model) {
		mstProduct = null;
		
		String productName = searchForm.getItemName().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		String[] arrayProductName = productName.split(" ");
		int categoryId = searchForm.getCategory();
		
		if(categoryId == 0) {
			mstProduct = productMapper.findByArrayProductName(arrayProductName);
		} else {
			mstProduct = productMapper.findByCategoryIdAndProductName(categoryId, arrayProductName);
		}

		model.addAttribute("mstProduct", mstProduct);
		model.addAttribute("mstCategory", mstCategory);
		model.addAttribute("keywords", productName);
		model.addAttribute("selected", categoryId);
		
		model.addAttribute("loginSession", loginSession);

		return "index";
	}
}
