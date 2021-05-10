package dummy.WS.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;

    /**
     * Default constructor. 
     */
    public ServletDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DemoTest d = new DemoTest();
		this.response = response;
		
		int statusCode = d.testNumber(request) == 0 ? 0 : triggerErrorhandling("Wrong number input!", d.statusCode);
		double num1 = statusCode == 0 ? Double.parseDouble(request.getParameter("num1")) : 1;
		double num2 = statusCode == 0 ? Double.parseDouble(request.getParameter("num2")) : 1;
		statusCode = d.testOperation(request) == 0 ? 0 : triggerErrorhandling("Wrong operation input!", d.statusCode);
		String operation = statusCode == 0 ? request.getParameter("operation") : "addition";
		
		double result = 0;
		switch(operation) {
		case "addition":
			result = d.testAddition(num1, num2) == 0 ? num1 + num2 : triggerErrorhandling("Try again with different numbers", d.statusCode);
			break;
		case "subtraction":
			result = d.testSubtraction(num1, num2) == 0 ? num1 + num2 : triggerErrorhandling("Try again with different numbers", d.statusCode);
			break;
		case "multiplication":
			result = d.testMultiplication(num1, num2) == 0 ? num1 * num2 : triggerErrorhandling("Try again with different numbers", d.statusCode);
			break;
		case "division":
			result = d.testDivision(num1, num2) == 0 ? num1 / num2 : triggerErrorhandling("Try again with different numbers",d.statusCode);
			break;
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String answer = Double.toString(result).contentEquals("Infinity") ? "Status code: " + triggerErrorhandling("Division by zero not allowed!", 2) : Double.toString(result);
		response.getWriter().print("Answer is: "+ answer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public int triggerErrorhandling(String errorMessage, int statusCode) throws IOException {
		response.getWriter().print(errorMessage + " " + ErrorMessages.error(statusCode));
		return 0;
	}

}
