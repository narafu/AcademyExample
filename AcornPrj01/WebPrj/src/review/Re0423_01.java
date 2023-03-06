package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review/calculate")
public class Re0423_01 extends HttpServlet {

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

//		String plus = req.getParameter("plus");
//		String multiple = req.getParameter("multiple");
//		String minus = req.getParameter("minus");
//		String division = req.getParameter("division");
//
//		if (plus != null)
//			out.println("x + y = " + (x + y));
//		else if (multiple != null)
//			out.println("x * y = " + (x * y));
//		else if (minus != null)
//			out.println("x - y = " + (x - y));
//		else if (division != null)
//			out.println("x / y = " + (x / y));


		if (req.getParameter("plus") != null)
			out.println("x + y = " + (x + y));
		else if (req.getParameter("multiple") != null)
			out.println("x * y = " + (x * y));
		else if (req.getParameter("minus") != null)
			out.println("x - y = " + (x - y));
		else if (req.getParameter("minus") != null)
			out.println("x / y = " + (x / y));
	}

}
