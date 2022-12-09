package myservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import methods.BankingForAdmin;
import methods.BankingForUser;
import methods.LoginPage;
import methods.PersonPojo;
import userexception.UserException;




/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login1=request.getParameter("button");
		BankingForUser user= new BankingForUser();
		BankingForAdmin admin =new BankingForAdmin();
		HttpSession session = request.getSession(true);
		String role=null;
	
			int userId=Integer.parseInt(request.getParameter("CustomerId"));
			String password=request.getParameter("password");

			Map map=new HashMap();
			map.put("name", "ansar");
			map.put("role", "user");

			LoginPage login = new LoginPage();
			try {
				role=login.getUserIdDetails(userId, password);
				session.setAttribute("role", role);
				session.setAttribute("userId", userId);
				if(role.equals("user")){
					
					try {
					Map mymap=user.viewUserDetails(userId,role);
					PersonPojo userDetails =(PersonPojo) mymap.get(userId);
					Gson gson = new GsonBuilder().create();
					String json = gson.toJson(userDetails);
											
						response.getWriter().write(json);
					} catch (UserException e) {
						// TODO Auto-generated catch block
					
					}
					
					

				}
				else {
					response.getWriter().write("admin");
				}
			} catch (UserException e) {
				Map map1=new HashMap();
				map1.put("message", e.getMessage());
				
				response.getWriter().write(new Gson().toJson(map1));
			}


		}

		
		
		
	}


