package Controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.ListOperations;
import service.SetOperations;
import sun.awt.image.ImageWatched.Link;

@WebServlet(urlPatterns= {"/set"})

public class SetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
		Set<TouristPlace> set =new HashSet<TouristPlace>();
		SetOperations s=new SetOperations();
		
		if(add!=null) {
			// call the add method and store the return value in a set variable
			
			set=s.add(t);
			
			request.setAttribute("bucketListadd", set);
			request.setAttribute("message", "user added successfully");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/set.jsp");
			rd.forward(request, response);
		}

		if(remove!=null) {
			// call the remove method and store the return value in a set variable
			
			set=s.remove(t);
			
			request.setAttribute("bucketListremove", set);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/set.jsp");
			rd.forward(request, response);
		}

		
		if(sortbydestination!=null) {
			// call the sortByDestination method and store the return value in a set variable
			
			TreeSet<TouristPlace>  x=(TreeSet<TouristPlace>) s.sortByDestination(set);
			
			request.setAttribute("bucketList", x);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/set.jsp");
			rd.forward(request, response);
		}

		if(sortbyrank!=null) {
			// call the sortByRank method and store the return value in a set variable
			
			TreeSet<TouristPlace> x= (TreeSet<TouristPlace>) s.sortByRank(set);
			
			request.setAttribute("bucketList",x);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/set.jsp");
			rd.forward(request, response);
		}

		if(reset!=null) {
			// call the reset method and store the return value in a set variable
			
			 Set<TouristPlace> x =(Set<TouristPlace>) s.reset(set);
			 
			
			request.setAttribute("bucketList", x);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/set.jsp");
			rd.forward(request, response);
		}

	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}



}
