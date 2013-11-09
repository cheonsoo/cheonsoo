package mansoo.board.web;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mansoo.board.data.Contact;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/loginpage", method=RequestMethod.GET)
	public String loginpage(Locale locale, Model model, HttpServletRequest request) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			for (GrantedAuthority gauth : auth.getAuthorities()) {
				if (gauth.getAuthority().equals("ROLE_USER")) {
					model.addAttribute("login", "success");
					model.addAttribute("userid", auth.getName());
				} else {
					model.addAttribute("login", "fail");
				}
			}
		} else {
			model.addAttribute("login", "fail");
		}
		
		return "login";
	}
	
	/*
	@RequestMapping("/loginpage")
    public String loginHome(Map<String, Object> map) {
		System.out.println("### Login");
		
		return "login";
    }
	*/
	
	/*
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
        return "redirect:/";
    }
    */
}