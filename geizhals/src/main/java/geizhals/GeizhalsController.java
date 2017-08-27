package geizhals;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class GeizhalsController {
	@GetMapping(path = "/")
	public String get(Model model) {
		// fill the model
		model.addAttribute("isFormal", true);
		model.addAttribute("greetees", new String[] { "Alice", "Bob", "Carol" });

		// forward to the view
		return "Geizhals";
	}
}
