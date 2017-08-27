package geizhals;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class GeizhalsController {
	private final GeizhalsService geizhalsService = new GeizhalsService();

	@GetMapping(path = "/")
	public String get(Model model) {
		// fill the model
		model.addAttribute("allProducts", geizhalsService.allProducts());
		model.addAttribute("allDiscounters", geizhalsService.allDiscounters());

		// forward to the view
		return "Geizhals";
	}
}
