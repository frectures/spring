package geizhals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class GeizhalsController {
	@Autowired
	private GeizhalsService geizhalsService;

	@GetMapping(path = "/")
	public String get(Model model) {
		// fill the model
		model.addAttribute("allProducts", geizhalsService.allProducts());
		model.addAttribute("allDiscounters", geizhalsService.allDiscounters());
		model.addAttribute("allPrices", geizhalsService.allPriceInfosByProductAndDiscounter());
		model.addAttribute("cheapestPrices", geizhalsService.cheapestPriceInfosByProduct());

		// forward to the view
		return "Geizhals";
	}
}
