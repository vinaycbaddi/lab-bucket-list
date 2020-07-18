package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.ListOperations;


@WebServlet(urlPatterns= {"/list"})
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<TouristPlace> list =new ArrayList<TouristPlace>();
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		
		TouristPlace t=new TouristPlace(name, destination, rank);
		
		String sortbydestination = request.getParameter("sortbydestination");
		String sortbyrank = request.getParameter("sortbyrank");
		String remove = request.getParameter("delete");
		String reset = request.getParameter("reset");
		
		ListOperations l=new ListOperations();
		
		System.out.println("Entering into list");
	
		if(add!=null) {
			// Call the add method in list operations and store the return list in list variable
			System.out.println("calling add equals method");
			
			list=l.add(t);
			
			request.setAttribute("bucketList", list);
			request.setAttribute("message", "user added successfully");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(remove!=null) {
			// call the remove method and store the return list in a list variable
			list=l.remove(t);
			request.setAttribute("bucketList", list);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		
		if(sortbydestination!=null) {
			// call the sortByDestination method and store the value in a list variable
			
			List<TouristPlace> l1=(List<TouristPlace>) l.sortByDestination(list);
			
			request.setAttribute("bucketList", l1);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(sortbyrank!=null) {
		// call the sortByRank method and store the value in a list variable
			
			List<TouristPlace>	l2=  (List<TouristPlace>) l.sortByRank(list);
			
			request.setAttribute("bucketList", l2);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(reset!=null) {	
			// call the clear method and store the value in a list variable
			
			List<TouristPlace>	l3 = (List<TouristPlace>) l.reset(list);
			
			request.setAttribute("bucketList", l3);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
