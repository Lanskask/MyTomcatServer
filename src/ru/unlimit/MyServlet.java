package ru.unlimit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(urlPatterns="/MyServlet", 
			description="Описание Сервлета",
			displayName="Some DisplayName")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	 * response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Running MyServlet.doGet()");
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("Name from request: "+name
				+"; Last Name: "+lastName);
		
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
// or 
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
//		out.println("<h1>Я хочу в Китеж-Град!</h1><br>"
//				+ "And where it is?"
//				+ "Рядом с Кузькиной матерью!");
		out.println("<h3>пример от MyServlet.GET</h3><br>"
					+ name+" "+lastName);
		out.close();
	} // end of doGet
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Running MyServlet.doGet()");
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
//		String job = request.getParameter("job");
		String[] job = request.getParameterValues("job");
		
		String gender = request.getParameter("gender");
		if (gender == null) {
			gender="-";
		}
		String age18 = request.getParameter("age18");
		if (age18 == null) {
			age18="-";
		}
		
		String password = request.getParameter("password");
		String file = request.getParameter("file");
		
		System.out.println("Name from request: "+name
							+"; Last Name: "+lastName);

		System.out.println("Колличество ролей "
						+ job.length);
		for (String job_item : job) {
			System.out.println(job + ", ");
		}
		
		System.out.println("\nПол: " + gender
							+"\nСтарше 18ти ?: " + age18
				);
		
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
// or 
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
//		out.println("<h1>Я хочу в Китеж-Град!</h1><br>"
//				+ "And where it is?"
//				+ "Рядом с Кузькиной матерью!");
		out.println("<h3>пример от MyServlet.POST</h3>");
		out.println("<h3>Профиль сотрудника</h3>");
		out.println("Имя: " +name+"<br>");
		out.println("Фамилия: " +lastName+"<br>");
		
//		if (job.length == 1) {
//			out.println("Должность: " + job[0]+"<br>");
//		} else {
//			out.println("Должности: <br>");
//			for (int i = 0; i < job.length; i++) {
//				out.println(job[i]+"<br>");
//			}
//		}

		out.println("Колличество ролей "
				+ job.length+"<br>");
//		for (String job_item : job) {
//			out.println(job_item + ", ");
//		}
		out.println("Должности: "+
		Arrays.deepToString(job));
		
		out.println("<br>Пол: " + gender+"<br>"
				+"<br>Старше 18ти ?: " + age18+"<br>");
		out.println("Файл: " +file+"<br>");
		out.println("Пароль: " +password+"<br>");
		
		out.close();
	} // end of doPost

}
