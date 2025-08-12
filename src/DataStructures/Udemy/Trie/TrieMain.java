package DataStructures.Udemy.Trie;

public class TrieMain {

	public static void main(String[] args) {
		Trie t  =new Trie();
		
		//CASE#1
//		t.insert("bcde");
//		t.insert("bckg");
//		t.delete("bcde");
//		System.out.println(t.search("bcde"));	//False
//		System.out.println(t.search("bckg"));	//True
		
//		t.preorder(t.root, "abcdefghijklmnopqrstuvwxyz");
		
		//CASE#2
//		t.insert("bcde");
//		t.insert("bcdefg");
//		t.delete("bcde");
//		System.out.println(t.search("bcde"));		//False
//		System.out.println(t.search("bcdefg"));	//True
		
		
		//CASE#3
		t.insert("bcde");
		t.insert("bc");
		t.delete("bcde");
		System.out.println(t.search("bcde"));	//False
		System.out.println(t.search("bc"));		//True
		System.out.println(t.search("b"));			//False
		System.out.println("----"+t.startsWith("b"));
		System.out.println("----"+t.startsWith("bc"));
		
		
		//CASE#4
//		t.insert("bcde");
//		t.delete("bc");
//		t.delete("bcde");
//		System.out.println(t.search("bcde"));	//False
//		System.out.println(t.search("bc"));	//False
	}

}//End of Class