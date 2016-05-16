package net.lermex.inaction.home;

import net.lermex.inaction.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class HomeController {

	private Random random = new Random();
	@Autowired
	private TestBean testBean;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home/homeNotSignedIn");
		ArrayList<Integer> statNums = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			statNums.add(random.nextInt(6));
		}
		modelAndView.addObject("statNums", statNums);
		return modelAndView;
	}

	@RequestMapping(value = "/signup")
	public String signup() {
		return "signin/signin";
	}

}
