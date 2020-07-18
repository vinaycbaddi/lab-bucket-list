package service;
import model.TouristPlace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListOperations{
	List<TouristPlace> list=new ArrayList<TouristPlace>();
	
	public List<TouristPlace> add(TouristPlace places)
	{	
		list.add(places);
		return list;	
	}
	public List<TouristPlace> remove(TouristPlace places){
		list.remove(places);
		return list;
	}
	public Object sortByDestination(List<TouristPlace> places) {
		Comparator<TouristPlace> a=	Comparator.comparing(TouristPlace::getDestination);
		Collections.sort(list,a);
		return a;
	}
	public Object sortByRank(List<TouristPlace> places) {
		Comparator<TouristPlace> b=Comparator.comparing(TouristPlace::getRank);
		Collections.sort(list,b);
		return b;
		
	}
	public Object reset(List<TouristPlace> places) {
		places.clear();
		return places;
	}

}