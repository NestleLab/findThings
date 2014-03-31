package com.nestlelab.router;

import odata.transformer.DataTransformer;
import odata.transformer.HqlWhereClauseTransformer;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Router extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String filterString = "Name eq 'a'";
        DataTransformer transformer = new HqlWhereClauseTransformer();
        String whereClause = transformer.transform(filterString, null);

        out.println("Hello Servlet!");
        out.println(whereClause);

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        // TODO
    }
}
