package Problem_Solving.Graph.Pepcoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AccountsMerge {

	//We are using unique Id for union and find, so that comparison becomes easy.
	int par[];
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		par = new int[10001];
		for (int i = 0; i < 10001; i++) {
			par[i] = i;
		}
		
		HashMap<String, Integer> emailToUniqId = new HashMap<>();
		HashMap<String, String> emailToName = new HashMap<>();
		int uid = 0;
		for(List<String> account: accounts) {
			String name = "";
			for(String email: account) {		//skip 1st string as it is the name and not the email
				if(name == "") {
					name = email;
					continue;
				}
				
				if(!emailToUniqId.containsKey(email)) {			//map the email to unique id
					emailToUniqId.put(email, uid);
					uid++;
				}
				if(!emailToName.containsKey(email)) {			//map the email to the name
					emailToName.put(email, name);
				}
				
				int e1uid = emailToUniqId.get(account.get(1));		//find first email id of this account list
				int currUid = emailToUniqId.get(email);					// find the current email id of this account list
				
				int p1 = findPar(e1uid);
				int p2 = findPar(currUid);	
				if(p1 != p2)														// make 1st email id as parent of all email ids of this account list 
					par[p2] = p1;
			}
		}
		
		HashMap<Integer, List<String>> parentToEmail = new HashMap<>();
		for(String email: emailToName.keySet()) {
			int currUid = emailToUniqId.get(email);
			int parent = findPar(currUid);
			if(parentToEmail.containsKey(parent))				//if parent (or leader of the set) already exists, add the email to the same set
				parentToEmail.get(parent).add(email);
			else {
				parentToEmail.put(parent, new ArrayList<>());		//else create a new ArrayList and add it to the map
				parentToEmail.get(parent).add(email);
			}
		}
		List<List<String>> ans = new ArrayList<>();
		for(List<String> emails: parentToEmail.values()) {
			Collections.sort(emails);
			List<String> tp = new ArrayList<>();
			String email = emails.get(0);
			String name = emailToName.get(email);
			tp.add(name);
			for(String e: emails) 
				tp.add(e);
			ans.add(new ArrayList<>(tp));
		}
		return ans;
	}
	
	private int findPar(int currUid) {
		if(par[currUid] == currUid)
			return currUid;
		return par[currUid] = findPar(par[currUid]);
	}
	
	public static void main(String[] args) {

	}

}
