package br.com.wisold.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizarInterceptor
  extends HandlerInterceptorAdapter
{
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
  {
    String uri = request.getRequestURI();
    if ((uri.endsWith("login")) || (uri.endsWith("sistema")) || (uri.contains("resources"))) {
      return true;
    }
    if (request.getSession().getAttribute("user") != null) {
      return true;
    }
    try
    {
      response.sendRedirect("login");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return false;
  }
}
