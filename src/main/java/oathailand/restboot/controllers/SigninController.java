package oathailand.restboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * If you annotate a method with @ResponseBody,
 * spring will try to convert its return value and write it to the http response automatically.
 *
 * @author peerapat
 */
@RestController
public class SigninController {

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String post(
		@RequestParam(value = "user", required = true) final String username
		, @RequestParam(value = "passwd", required = true) final String passwd
	) {
		if ("norbor".equals(username) == "password".equals(passwd)) {
			return "true";
		} else {
			return "false";
		}
    }

}
