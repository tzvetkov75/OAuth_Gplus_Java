package oauth.vesselin;


import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.http.BasicAuthentication;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.http.GenericUrl;

public class OauthServlet extends AbstractAuthorizationCodeServlet {
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

//        // Make a request to list the the details of a parcitular map.
//        URL url = new URL("https://www.googleapis.com/mapsengine/v1/maps/YOUR_MAP_ID");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        connection.setDoOutput(true);
//        connection.setRequestProperty(
//            "Authorization", "Bearer " + getCredential().getAccessToken());
//        connection.connect();
//
//        BufferedReader reader = new BufferedReader(
//            new InputStreamReader(connection.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//          out.println(line);
//        }
    }

    @Override
    protected String getRedirectUri(HttpServletRequest req)
            throws ServletException, IOException {
        GenericUrl url = new GenericUrl(req.getRequestURL().toString());
        url.setRawPath("/TestOAuth/oauth2callback");
        return url.build();
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws IOException {
    	 
        return new GoogleAuthorizationCodeFlow.Builder(new NetHttpTransport(), new JacksonFactory(),
                "940835816268-ugtssahhnrps6nfjgr0ed0du4ic231ah.apps.googleusercontent.com", "jvbSnWivqd-Xg4uD5P7XFnax",
                Arrays.asList("https://www.googleapis.com/auth/userinfo.profile;https://www.googleapis.com/auth/userinfo.email".split(";"))
                ).build();

    }

    @Override
    protected String getUserId(HttpServletRequest req) throws ServletException,
            IOException {
        // replace this with code to generate a unique ID for each visitor.
        return "1234";
    }
}
