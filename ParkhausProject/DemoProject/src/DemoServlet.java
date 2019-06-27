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
		}
		if ("fun".equals( command ) && "ave".equals( param )){
			int timeAve = getPersistentTAve();
			Float ave = getPersistentAverage();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Average time: " + timeAve  + "			");
			out.println("Average Price: " + ave);
			System.out.println( "TimeAverage = " + timeAve );
			System.out.println( "Average Price = " + ave );
		}
		if ("fun".equals( command ) && "sti".equals( param )){
			int shortestTime = getPersistentShortestTime();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println( shortestTime );
			System.out.println( "Shortest Time = " + shortestTime );
		}
		
		else {
		System.out.println( "Invalid Command: " + request.getQueryString() );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float sum = getPersistentSum();
		float ave = getPersistentAverage();
		int tAve = getPersistentTAve();
		int sti = getPersistentShortestTime();
		int cars = getPersistentAmountCars();
		int time = getPersistentTime();
		String body = getBody( request ); System.out.println( body );
		String[] params = body.split(",");
		String event = params[0];
		String priceString = params[5];
		if ( ! "_".equals( priceString ) ){
		// strip € in front, parse the number behind
		float price = Float.parseFloat( priceString.split(" ")[2] );
		sum += price;
		cars++;
		time += Integer.parseInt(params[4]);
		ave = sum/cars;
		tAve = time/cars;
		if(sti > Integer.parseInt(params[4]) || sti == 0) {
			sti = Integer.parseInt(params[4]);
			getApplication().setAttribute("sti", sti);
		}
		
		// store sum persistently in ServletContext
		getApplication().setAttribute("sum", sum );
		getApplication().setAttribute("car", cars);
		getApplication().setAttribute("ave", ave);
		getApplication().setAttribute("tAve", tAve);
		getApplication().setAttribute("time", time);
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
		Float average;
		ServletContext application = getApplication();
		average = (Float)application.getAttribute("ave");
		if ( average == null ) average = 0.0f;
		return average;
	}
	
	private int getPersistentTAve() {
		Integer average;
		ServletContext application = getApplication();
		average = (Integer)application.getAttribute("tAve");
		if ( average == null ) average = 0;
		return (int) average;
	}
	
	private int getPersistentShortestTime() {
		Integer sTime;
		ServletContext application = getApplication();
		sTime = (Integer)application.getAttribute("sti");
		if ( sTime == null ) sTime = 0;
		return (int) sTime;
	}
	
	private int getPersistentAmountCars() {
		Integer cars;
		ServletContext application = getApplication();
		cars = (Integer)application.getAttribute("car");
		if ( cars == null ) cars = 0;
		return (int) cars;
	}
	
	private int getPersistentTime() {
		Integer time;
		ServletContext application = getApplication();
		time = (Integer)application.getAttribute("time");
		if ( time == null ) time = 0;
		return (int) time;
	}

}
