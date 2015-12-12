package ua.gvv;

import java.util.ArrayList;

public class Division extends TypeWorking{
	// i change my class
	private int chislitelInt, znamenatelInt, resultInt,colProbelovInt,colShtrihovInt,znachenieArrayInt;
	private String chislitelStr, result, colProbelovStr,colShtihovStr,znachenieVArrayStr,
	znamenatelStr,chislitelForOutStr;
	private final int COL_ZUFR_CHISLITELJA,COL_MAIN_LOOP, PERVAYA_ZIFRA=0,DESJATJ=10;
	private double stepen;
	ArrayList<String> arrayZnacheiy = new ArrayList<String>();

	public Division(int chislo1,int chislo2){
		
		chislitelInt=chislo1;
		znamenatelInt=chislo2;
		resultInt=chislitelInt/znamenatelInt;
		chislitelStr=formaterToString(chislo1);
		result=formaterToString(resultInt);
		COL_MAIN_LOOP=result.length();
		COL_ZUFR_CHISLITELJA=chislitelStr.length();
		createArrayZnacheiy();
		arrayZnacheiy.add("");
		znamenatelStr=formaterToString(chislo2);
		outPutResultFirst();
			}
	
	private void createArrayZnacheiy(){
		
		for (int i=0;i<COL_MAIN_LOOP;i++){
			
			znachenieArrayInt=pieceOfInt(result,i)*znamenatelInt;
			znachenieVArrayStr=formaterToString(znachenieArrayInt);
			
			arrayZnacheiy.add(znachenieVArrayStr);
		}
	}

	
	public void mainLoop(){
		
		for (int i = 0;i<COL_MAIN_LOOP;i++){
			
			chislitelStr=setChislitel(i);
			colProbelovStr=getSpaces(i);
			colShtihovStr=getShtihi(colProbelovStr);
			outPutResult(colProbelovStr,chislitelStr,colShtihovStr,i);
		}
	}
	
	private String okruglenieChislitelja(String valueStr,int i) {

		if(valueStr.length()>arrayZnacheiy.get(i).length()){
			
			if (proverkaPervuhZifr(i)){		
				
				valueStr=valueStr.substring(0,arrayZnacheiy.get(i).length()+1);
				
			}else{
				
				valueStr=valueStr.substring(0,arrayZnacheiy.get(i).length());}
			
		}		
		return  valueStr;
	}

	private String setChislitel(int indexMainLoop){
		

		
		stepen=chislitelStr.length()-arrayZnacheiy.get(indexMainLoop).length();
		
		if(proverkaPervuhZifr(indexMainLoop)){
			
			stepen-=1;
			
		}
		znachenieArrayInt=formaterToInt(arrayZnacheiy.get(indexMainLoop));
	
		chislitelInt-=znachenieArrayInt*(Math.pow(DESJATJ,stepen ));
		
		chislitelStr=formaterToString(chislitelInt);
				
		return chislitelStr;

	}
	

	
	private boolean proverkaPervuhZifr(int index) {
		//variable for @if@ operation
		
		int a =pieceOfInt(chislitelStr,PERVAYA_ZIFRA);
		int b = pieceOfInt(arrayZnacheiy.get(index),PERVAYA_ZIFRA);
		if (a>=b){
			return false;
		}return true;
	}

	private String getSpaces(int index){
		colProbelovStr="";
		colProbelovInt = (COL_ZUFR_CHISLITELJA)-(formaterToString(chislitelInt).length());
		for (int i =0;i<colProbelovInt;i++){
			
			colProbelovStr=colProbelovStr+" ";
			
		}
		return colProbelovStr;
	}
	
	private String getShtihi(String variable){
		colShtihovStr="";
		colShtrihovInt=(COL_ZUFR_CHISLITELJA+1)-variable.length();
		
		for(int i = 0 ; i<colShtrihovInt;i++){
			
			colShtihovStr+="-";
			
		}
		
		return colShtihovStr;
		
	}
	private String getShtihiFirst(){
		colShtihovStr="-";
		if(result.length()>znamenatelStr.length()){
		
			colShtrihovInt=result.length();
				
		}else{
			
			colShtrihovInt=znamenatelStr.length();
			
		}
		
		for(int i = 0 ; i<colShtrihovInt-1;i++){
			
			colShtihovStr+="-";
			
		}
		
		return colShtihovStr;
		
	}
	
	private String getSpacesFirst(){
		colProbelovStr=" ";
		
		colProbelovInt = (COL_ZUFR_CHISLITELJA+1)-arrayZnacheiy.get(PERVAYA_ZIFRA).length();
		
		for (int i =0;i<colProbelovInt-1;i++){
			
			colProbelovStr+=" ";
			
		}
		
		return colProbelovStr;
	}
	
	private void outPutResultFirst(){
		
		colProbelovStr=getSpacesFirst();
		colShtihovStr=getShtihiFirst();
		
		System.out.println("_"+chislitelInt+"|"+znamenatelInt);
		System.out.println(" "+arrayZnacheiy.get(PERVAYA_ZIFRA)+colProbelovStr+colShtihovStr);
		System.out.println(getShtihi("")+"|"+result);
	}
	
	private void outPutResult(String arg0,String arg1,String arg2,int index){
		
		if (arrayZnacheiy.get(index+1).equals("0")){
			
			System.out.println(arg0+"_"+"0");
			System.out.println(arg0+" "+arrayZnacheiy.get(index+1));
			System.out.println(arg0+arg2);
			
		}else{if (arrayZnacheiy.get(index+1)!=""){
			if (proverkaPervuhZifr(index+1)){		
				chislitelForOutStr=okruglenieChislitelja(arg1,index+1);
				System.out.println(arg0+"_"+chislitelForOutStr);
				System.out.println(arg0+"  "+arrayZnacheiy.get(index+1));
				System.out.println(arg0+arg2);
				
			}else{
				chislitelForOutStr=okruglenieChislitelja(arg1,index+1);
				System.out.println(arg0+"_"+chislitelForOutStr);
				System.out.println(arg0+" "+arrayZnacheiy.get(index+1));
				System.out.println(arg0+arg2);}
		
		}else{System.out.println(arg0+" "+arg1);}}
		
	};
}