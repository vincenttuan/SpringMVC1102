package com.lab.jpa.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final String CLIEND_ID = "889955278565-585vm9tbd9nbfnm58t609j8s64cnkui6.apps.googleusercontent.com";
    
    @PostMapping("/check")
    //@ResponseBody
    public String check(HttpServletRequest req) {
        String id_token = req.getParameter("id_token");
        // 建立 Google Token 驗證器
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier(new NetHttpTransport(), new JacksonFactory());
        GoogleIdToken id_token_result = null;
        try {
            // 驗證 id_token
            id_token_result = verifier.verify(id_token);
            if(id_token_result != null) {
                // 索取使用者的公開Google資訊
                Payload payload = id_token_result.getPayload();
                String username = payload.get("name") + "";
                String email = payload.getEmail();
                String picture_url = payload.get("picture") + "";
                // 將使用者資料存放到session
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                session.setAttribute("picture_url", picture_url);
                session.setAttribute("email", email);
                return "redirect: ../dept/";
                //return "pass, " + username + ", " + email + ", " + picture_url;
            } else {
                return "redirect: ../../google_login.jsp";
            }
        } catch (Exception e) {
        }
        return "id_token: " + id_token;
    }
    
}
