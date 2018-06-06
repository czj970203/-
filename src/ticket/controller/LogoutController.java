package ticket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import ticket.config.Message;

@Controller
@RequestMapping(value="logout")
public class LogoutController {
	
	@RequestMapping(value="allout")
	@ResponseBody
	public Message logout(HttpSession session) {
		try {
            session.setAttribute("member", null);
            session.setAttribute("hall", null);
            session.setAttribute("manager", null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(false,"�ǳ�ʧ��,���Ժ�����");
        }
		return new Message(true,"�ǳ��ɹ�");
	}

}
