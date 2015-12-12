package ua.gvv;

import java.util.Scanner;

public class Main {

	private static Scanner sn = new Scanner (System.in);
	private static int chislo1,chislo2;
	private static final String CHISLITEL="Vvedite Chislitel",
							ZNAMENATEL="Vvedite Znamenatel",
							WHISH="Zhelaete poprobuvat' eshcho?",
							BUY="Programma okonchena. Dosvidanija.",
							EXCEPTION_MESSEGE="Vu vveli ne chislo!!!",
							YES="yes";
	private static boolean zikl=true;
	public static String answer;
		
	public static void main(String[] args) {
		for(;zikl;){
			try{
				outConsolMessege(CHISLITEL);		
				chislo1=outPutInt();
				outConsolMessege(ZNAMENATEL);	
				chislo2=outPutInt();
				Division div = new Division(chislo1,chislo2);
				div.mainLoop();
			}catch(Exception e){
				outConsolMessege(EXCEPTION_MESSEGE);
			}
			outConsolMessege(WHISH);
		
			if (outPutString().equalsIgnoreCase(YES)){
			
			}else{			
				outConsolMessege(BUY);
				zikl=false;
		
			}
	}
		
		sn.close();	
	}
	private static int outPutInt(){

		return sn.nextInt();
	}
	private static void outConsolMessege(String messege){
		
		System.out.println(messege);
		
	}
	private static String outPutString(){
		
		return sn.nextLine();
	}
}
