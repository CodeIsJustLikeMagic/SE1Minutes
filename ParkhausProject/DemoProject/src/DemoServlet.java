import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * Servlet implementation class DemoServlet
 */
@WebServlet(name="/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] requestParamString = request.getQueryString().split("=");
		String command = requestParamString[0];
		String param = requestParamString[1];
		if ( "fun".equals( command ) && "sum".equals( param ) ){
		Float sum = getPersistentSum();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( sum );
		System.out.println( "sum = " + sum );
		} else {
		System.out.println( "Invalid Command: " + request.getQueryString() );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Float sum = getPersistentSum();
		String body = getBody( request ); System.out.println( body );
		String[] params = body.split(",");
		String event = params[0];
		String priceString = params[5];
		if ( ! "_".equals( priceString ) ){
		// strip € in front, parse the number behind
		float price = Float.parseFloat( priceString.split(" ")[2] );
		sum += price;
		// store sum persistently in ServletContext
		getApplication().setAttribute("sum", sum );
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( sum );
	}

	private ServletContext getApplication() {
		return getServletConfig().getServletContext();
	}

	private static String getBody(HttpServletRequest request) throws IOException{
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
		InputStream inputStream = request.getInputStream();
		if (inputStream != null) {
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		char[] charBuffer = new char[128];
		int bytesRead = -1;
		while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
		stringBuilder.append(charBuffer, 0, bytesRead);
		}
		} else {
		stringBuilder.append("");
		}
		} finally {
		if (bufferedReader != null) {
		bufferedReader.close();
		}
		}
		return stringBuilder.toString();
	}

	private Float getPersistentSum() {
		Float sum;
		ServletContext application = getApplication();
		sum = (Float)application.getAttribute("sum");
		if ( sum == null ) sum = 0.0f;
		return sum;
	}
	
	private Float getPersistentAverage() {
		Float sum;
		ServletContext application = getApplication();
		sum = (Float)application.getAttribute("ave");
		if ( sum == null ) sum = 0.0f;
		return sum;
	}
	
	private Float getPersistentShortestTime() {
		Float sum;
		ServletContext application = getApplication();
		sum = (Float)application.getAttribute("sti");
		if ( sum == null ) sum = 0.0f;
		return sum;
	}

}
