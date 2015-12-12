package ua.gvv;

public class TypeWorking {

	private int variableInt, pieceInt;
	private String pieceStr,variableStr;
	
	public int formaterToInt(String variable){
		
		variableInt=Integer.parseInt(variable);
		
		return variableInt;
		
	}
	
	public int pieceOfInt(String variable,int index){
		
		pieceStr = String.valueOf(variable.charAt(index));
		pieceInt = Integer.parseInt(pieceStr);
		
		return pieceInt;
		
	}
	
	public String formaterToString(int Variable){
		
		variableStr=String.valueOf(Variable);
		return variableStr;
	}
}
