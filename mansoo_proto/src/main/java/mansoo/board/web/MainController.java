package mansoo.board.web;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mansoo.board.data.Contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.SessionScope;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		
		// Set Spring Security Holder
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean login = false;
		if (auth != null) {
			for (GrantedAuthority gauth : auth.getAuthorities()) {
				if (gauth.getAuthority().equals("ROLE_USER")) {
					login = true;
				}
			}
		}
		
		// Set Main Page
		String body;
		if (login) {
			body = request.getParameter("body");
			if (request.getParameter("body") == null) {
				body = "/home";
			}
			model.addAttribute("body", body);
			
//			model.addAttribute("login", "success");
//			model.addAttribute("userid", auth.getName());
			
		} else {
			body = "/home";
//			model.addAttribute("login", "fail");
		}
		
		model.addAttribute("body", body);
		
		return "main";
	}
}
