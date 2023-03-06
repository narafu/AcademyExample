package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review/multiplition")
public class Re0422_01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int x = 0;
		int y = 0;

		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");

		if (x_ != null && !x_.equals(""))
			x = Integer.parseInt(x_);

		if (y_ != null && !y_.equals(""))
			y = Integer.parseInt(y_);

		PrintWriter out = resp.getWriter();

		out.println(x * y);

	}

}
