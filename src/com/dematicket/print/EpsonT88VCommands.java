package com.dematicket.print;

public class EpsonT88VCommands implements PrintCommands {
	private static String FONT_ROMAN = "Roman";
	private static String FONT_SANS_SERIF = "Sans Serif";
	private static String FONT_COURIER = "Courier";
	private static String FONT_PRESTIGE = "Prestige";
	private static String FONT_SCRIPT = "Script";
	private static String FONT_ROMAN_T = "Roman T";
	private static String FONT_SANS_SERIF_H = "Sans Serif H";
	
	public byte[] getActivateCondensedFontCommand() {
		byte res[] = {(byte)15};
		return res;
	}

	public byte[] getCRCommmand() {
		byte res[] = {(byte)13};
		return res;
	}

	public byte[] getDeactivateCondensedFontCommand() {
		byte res[] = {(byte)18};
		return res;
	}

	public byte[] getFormFeedCommand() {
		byte res[] = {(byte)12};
		return res;
	}

	public byte[] getInitializeCommand() {
		byte res[] = {(byte)27, (byte)64};
		return res;
	}
	
	public byte[] getLFCommand() {
		byte res[] = {(byte)10};
		return res;
	}

	public byte[] getSetFontNameCommand(String fontName) {
		byte font = -1;
		if (fontName.trim().equalsIgnoreCase(FONT_ROMAN)){
			font = 0;  
		}else if (fontName.trim().equalsIgnoreCase(FONT_SANS_SERIF)){
			font = 1;
		}else if (fontName.trim().equalsIgnoreCase(FONT_COURIER)){
			font = 2;
		}else if (fontName.trim().equalsIgnoreCase(FONT_PRESTIGE)){
			font = 3;
		}else if (fontName.trim().equalsIgnoreCase(FONT_SCRIPT)){
			font = 10;
		}else if (fontName.trim().equalsIgnoreCase(FONT_ROMAN_T)){
			font = 10;
		}else if (fontName.trim().equalsIgnoreCase(FONT_SANS_SERIF_H)){
			font = 11;
		}
		
		if (font >=0){
			byte res[] = {(byte)27, (byte)'k', font};
			return res;
		}else {
			byte res[] = {};
			return res;
		}
	}

	public byte[] getSetFontSizeCommand(int fontSize) {
		if (fontSize== 10){
			byte res[] = {(byte)27, (byte)'P'};
			return res;
		}else if (fontSize==12){
			byte res[] = {(byte)27, (byte)'M'};
			return res;
		}else if (fontSize==15){
			byte res[] = {(byte)27, (byte)'g'};
			return res;
		}else{
			return null;
		}
	}

	public byte[] getActivateProportionalModeCommand(){
		byte res[] = {(byte)27, (byte)'p', 1};
		return res;
	}
	
	public byte[] getDeactivateProportionalModeCommand(){
		byte res[] = {(byte)27, (byte)'p', 0};
		return res;
	}

	public byte[] getActivateBoldFontCommand() {
		byte res[] = {(byte)27, (byte)'E'};
		return res;
	}

	public byte[] getDeactivateBoldFontCommand() {
		byte res[] = {(byte)27, (byte)'F'};
		return res;
	}
	
	public byte[] getActivateDraftModeCommand() {
		byte res[] = {(byte)27, (byte)'x', 0};
		return res;
	}


	public byte[] getDeactivateDraftModeCommand() {
		byte res[] = {(byte)27, (byte)'x', 1};
		return res;
	}

	public byte[] getSetLeftMarginCommand(int margin) {
		byte res[] = {(byte)27, 1, (byte)margin};
		return res;
	}

	public byte[] getSetRightMarginCommand(int margin) {
		byte res[] = {(byte)27, (byte)'Q', (byte)margin};
		return res;
	}
	public byte[] getSetLineSpacingCommand(int mode){
		if (mode==0){ // 1/8 pulgada
			byte res[] = {(byte)27, (byte)'0'}; 
			return res;
		}else if (mode==1){ // 1/6 pulgada
			byte res[] = {(byte)27, (byte)'2'};
			return res;			
		}else{
			byte res[] = {};
			return res;
		}
	}
	public byte[] getActivateSkipPerforationCommand(int lineas){
		byte res[] = {(byte)27, (byte)'N', (byte)lineas};
		return res;		
	}
	
	public byte[] getDeactivateSkipPerforationCommand(){
		byte res[] = {(byte)27, (byte)'O'};
		return res;		
	}
	
	public byte[] getSetInternationalCharsCommand(int grupo){
		byte res[] = {(byte)27, (byte)'R', (byte)'7'}; 
		return res;
	}
	public byte[] getSetPageLengthCommand(int lineas){
		byte res[] = {(byte)27, (byte)74, (byte)lineas};
		return res;
	}
	
	public byte[] getSlip1() {
		byte res[] = {(byte)27, (byte)99, (byte)48, (byte)4};
		return res;
	}	
	public byte[] getSlip2() {
		byte res[] = {(byte)27, (byte)99, (byte)49, (byte)4};
		return res;
	}
	public byte[] getSlip3() {
		byte res[] = {(byte)27, (byte)99, (byte)51, (byte)16};
		return res;
	}	
	public byte[] getSlip4() {
		byte res[] = {(byte)27, (byte)99, (byte)52, (byte)32};
		return res;
	}
	
	public byte[] getHorizontal() {
		byte res[] = {(byte)27, (byte)74, (byte)250};
		return res;
	}

	public byte[] getVertical() {
		byte res[] = {(byte)27, (byte)86, (byte)49};
		return res;
	}
	
	public byte[] getCutePartial() {		
		byte res[] = {(byte)27, (byte)109};
		return res;
	}
	
	public byte[] getCute() {		
		byte res[] = {(byte)27, (byte)105};
		return res;
	}
	
	public byte[] getMoveAlong(int lineas) {		
		byte res[] = {(byte)27, (byte)100, (byte)lineas};
		return res;
	}
	
	public byte[] getMoveBack(int lineas) {		
		byte res[] = {(byte)27, (byte)101, (byte)lineas};
		return res;
	}
	
	public byte[] getInterlineFit(int espacio) {
		byte res[] = {(byte)27, (byte)51, (byte)espacio};
		return res;
	}
	
	public byte[] getCondensedHib(int n) {
		byte res[] = {(byte)27, (byte)33, (byte)n};
		//byte res[] = {(byte)29, (byte)66, (byte)1};//manchado negro
		return res;
	}
	
	public byte[] getUnderlined() {
		byte res[] = {(byte)27, (byte)33, (byte)128};
		return res;
	}

	public byte[] getComodin() {
		byte res[] = {(byte)27, (byte)33, (byte)128};
		return res;
	}

        public byte[] getDefaultAligment() {
		byte res[] = {(byte)27, (byte)97, (byte)0};
		return res;
	}
        
	public byte[] getLeftAligment() {
		byte res[] = {(byte)27, (byte)97, (byte)0};
		return res;
	}
        
        public byte[] getCenterAligment() {
		byte res[] = {(byte)27, (byte)97, (byte)49};
		return res;
	}
        
        public byte[] getRightAligment() {
		byte res[] = {(byte)27, (byte)97, (byte)50};
		return res;
	}
        
}
