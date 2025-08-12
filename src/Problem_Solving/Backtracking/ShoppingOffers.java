package Problem_Solving.Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

//Working, just provide the input
public class ShoppingOffers {

	public static void main(String[] args) {
		List<Integer> price = new ArrayList<>();
		List<ArrayList<Integer>> special = new ArrayList<ArrayList<Integer>>();
		List<Integer> needs = new ArrayList<>();
		System.out.println(findOutMinPrice(price, special, needs, 0));
	}
	
	public static int findOutMinPrice(List<Integer> price, List<ArrayList<Integer>> special, List<Integer> needs, int index){
	       int minprice = directBuy(price, needs);
	      
	       for(int i=index; i<special.size(); i++){
	           List<Integer> offer = special.get(i);
	           List<Integer> tempNeeds = new ArrayList<>();
	           if(isValidOffer(offer, needs)){
	               int calculatedPrice = 0;
	               calculatedPrice = offer.get(offer.size()-1);
	               for(int j=0; j<needs.size(); j++){
	                   tempNeeds.add(needs.get(j) - offer.get(j));
	               }
	               minprice = Math.min(minprice, calculatedPrice + findOutMinPrice(price, special, tempNeeds, i));
	           }
	       }
	       return minprice;
	    }

	    public static boolean isValidOffer(List<Integer> offer, List<Integer> needs){
	        for(int i=0;i<needs.size();i++)
	            if(offer.get(i) > needs.get(i))
	                return false;
	        return true;
	    }

	    public static int directBuy(List<Integer> price, List<Integer> needs){
	        int total = 0;
	        for(int i=0;i<needs.size();i++)
	            total += price.get(i) * needs.get(i);
	        return total;
	    }
}
