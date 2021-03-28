package servlet.kcServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.KC;

import service.KCService;

public class KCAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取请求参数
		String kcname = request.getParameter("kcname");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		// 封装
		KC kc = new KC();
		kc.setKcname(kcname);
		kc.setStarttime(starttime);
		kc.setEndtime(endtime);
		KCService kcService = new KCService();
		kcService.addKC(kc);
		// 跳转到列表页面
		response.sendRedirect(request.getContextPath() + "/kcQueryAllServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}