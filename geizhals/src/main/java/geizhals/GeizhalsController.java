package geizhals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class GeizhalsController {
	// TODO Of course you would not actually store domain state in the controller...
	private final List<String> greetees = new ArrayList<>(Arrays.asList("Alice", "Bob", "Carol"));

	@GetMapping(path = "/")
	public String get(Model model) {
		// fill the model
		model.addAttribute("isFormal", true);
		model.addAttribute("greetees", greetees);

		// forward to the view
		return "Geizhals";
	}

	@PostMapping(path = "/")
	public String post(@RequestParam("newGreetee") String newGreetee, Model model) {
		greetees.add(newGreetee);
		return get(model);
	}
}
