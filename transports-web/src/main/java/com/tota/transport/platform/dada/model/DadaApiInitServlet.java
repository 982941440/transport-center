package com.tota.transport.platform.dada.model;

import com.tota.transport.platform.dada.config.DadaApiConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


@WebServlet(name = "dadaapi",loadOnStartup = 2,urlPatterns = "/dadaapiServlet")
public class DadaApiInitServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            DadaApiConfig.getInstance().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

    }
}
