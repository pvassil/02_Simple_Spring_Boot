package gr.uoi.cs.daintiness.naiveSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SingleController {
	
	/**
	 * Just showing a text message without anything else at nothing than the default folder
	 * The <code>@ResponseBody</code> tag creates the result
	 *   
	 * @return String with the resulting text to be returned as a web page
	 */
	@RequestMapping(value = "/naiveResponseBody")
	@ResponseBody
	public String naiveResponseBody() {
		return "<p>Hang on, hang on for your life \n"
				+ "<p>The animals are all insane -- God help us";
	}

	/**
	 * Here there is no <code>@ResponseBody</code>. But, there is the name of a page returned.
	 * So basically, it goes into the resources and finds it into the templates/ folder
	 * 
	 * @return a String with the name of the page to be shown
	 */
	@RequestMapping(value = "/bootstrapExample")
	public String bootstrapExample(){
		return "bootstrapExample";
	}
	
	/**
	 * If you run simply localhost:8080/greeting  -> a simple hello WASP
	 * but if you run localhost:8080/greeting?name=blackie -> it instantiates the parameter name    
	 * 
	 * The trick here is that it uses a <code>Model</code> to hold the parameters that are passed to the web page 
	 * So, you have a Map<AttributeName, AttributeValue> being passed to the web page.
	 * In our case, it is the attribute "name" that either 
	 *  (i) takes a default value "WASP" if no parameter is given
	 *  (ii) takes the value coming from the request ?name=<value>
	 *   
	 * @param name the possibly empty value from the url used
	 * @param model a Model which will be carrying the mapping of attribute "name" to the value
	 * @return a String with the name of the page to be shown
	 */
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="WASP") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}


	
	/**
	 * The most sophisticated of all ways: ModelAndView. What you return is a pair of a model and a view.
	 * See how spring gives you a model, to which you add attribute-value pairs
	 * Then, you new a ModelAndView with 
	 *   (a) the page you 're heading at +
	 *   (b) the model you have populated with attribute-value pairs
	 *    
	 * @param model a Model which will be carrying attribute-value pairs as a map
	 * @return a ModelAndView object with the pair of target page path and the updated model
	 */
	@RequestMapping(value = "/model-view")
	public ModelAndView welcome(ModelMap model) {
		model.put("name", "lawless");
		return new ModelAndView("model-view", model);
	}
}//end class
