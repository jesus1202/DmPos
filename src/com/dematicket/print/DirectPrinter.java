package com.dematicket.print;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;

public class DirectPrinter {
	private PrintCommands printCommands;
	private ArrayList printElements;
	private String outputFile;
	//public static String nombreImpresoraMatricial_Receipt = "EPSON TM-H5000II Receipt";//ticket-termico
	public static String nombreImpresoraHibrida_Receipt = "EPSON TM-H5000II Receipt (1)";//ticket-termico
	public static String nombreImpresoraHibrida_Slip = "EPSON TM-H5000II Slip";//matricial
	public static String codImpresoraHibrida_Receipt = "R";//ticket-termico
	public static String codImpresoraHibrida_Slip = "S";//matricial
	
	public DirectPrinter(){
                printCommands = new EpsonPrintCommands();
		printElements = new ArrayList();
		outputFile = "lpt1";
	}
	 
	public void print(String texto){
		printElements.add(texto.getBytes());
	}
	
	public void print(byte[] texto){
		printElements.add(texto);//ACA
	}
	
	public void println(String texto){
		printElements.add(texto.getBytes());
		printElements.add(printCommands.getCRCommmand());
		printElements.add(printCommands.getLFCommand());
	}
	
	public void println(byte[] texto){
		printElements.add(texto);
		printElements.add(printCommands.getCRCommmand());
		printElements.add(printCommands.getLFCommand());
	}
	
	public void setPrintCommands(PrintCommands printCommands){
		this.printCommands = printCommands;
	}
	
	public void print() throws IOException{
		FileWriter out = null;
		try{
			out = new FileWriter(outputFile);
			Iterator it = printElements.iterator();
			while (it.hasNext()){
				out.write(new String((byte[])it.next()));
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
			throw e;
		}finally{
			try{
				out.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void printHibrida(String _printName) throws PrintException{
		try{
    		StringBuilder salida = new StringBuilder(); 
			Iterator it = printElements.iterator();
			while (it.hasNext()){
		   		salida.append(new String((byte[])it.next()));				
			}   
			String printName=_printName.trim();			
			
  			PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); 			 
  	        AttributeSet aset = new HashAttributeSet();
  	        aset.add(new PrinterName(printName, null));  	 
  	        services = PrintServiceLookup.lookupPrintServices(null, aset);
  	        PrintService service = null;
  	        if(services.length == 0){
  	        	System.out.println("No se encontro impresora con nombre " + printName);
  	        }  	        
  	        for(int i=0; i<services.length; i++){
  	        	service = services[i];
  	        }
  	        
   			if (service != null) {
   				System.out.println("PRINT: "+service.getName());
   		    }else{
   		    	System.out.println("PRINT: no default print service");
   		    }			
   			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
   			DocPrintJob pj = service.createPrintJob();
   			byte[] bytes;   			
   			bytes=salida.toString().getBytes();			
   			Doc doc=new SimpleDoc(bytes,flavor,null);
   			pj.print(doc, null);
		}catch(PrintException e){
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public void printEstandar() throws PrintException{
		try{		
    		StringBuilder salida = new StringBuilder(); 
			Iterator it = printElements.iterator();
			while (it.hasNext()){
		   		salida.append(new String((byte[])it.next()));				
			}   
			PrintService service = PrintServiceLookup.lookupDefaultPrintService();
			System.out.println("Nombre impresora por defecto: "+service.getName());
			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			DocPrintJob pj = service.createPrintJob();
			String ss=new String("\n Linea 1");
			ss=ss+new String("\n Linea 2");			
			byte[] bytes;			
			bytes=salida.toString().getBytes();	
			Doc doc=new SimpleDoc(bytes,flavor,null);
			pj.print(doc, null);								
		}catch(PrintException e){
			System.out.println(e.getMessage());
		}	
	}
	
	public void setCondensedOn(){
		printElements.add(printCommands.getActivateCondensedFontCommand());
	}

	public void setCondensedOff(){
		printElements.add(printCommands.getDeactivateCondensedFontCommand());
	}

	public void setBoldOn(){
		printElements.add(printCommands.getActivateBoldFontCommand());
	}
	
	public void setBoldOff(){
		printElements.add(printCommands.getDeactivateBoldFontCommand());
	}
	
	public void setDrafModeOn(){
		printElements.add(printCommands.getActivateDraftModeCommand());
	}
	
	public void setDrafModeOff(){
		printElements.add(printCommands.getDeactivateDraftModeCommand());
	}
	
	public void setProportionalModeOn(){
		printElements.add(printCommands.getActivateProportionalModeCommand());
	}
	
	public void setProportionalModeOff(){
		printElements.add(printCommands.getDeactivateProportionalModeCommand());
	}
	
	public void initialize(){
		printElements.add(printCommands.getInitializeCommand());
	}
	
	public void initializeReceipt(){//termica
		printElements.add(printCommands.getInitializeCommand());
	}
	
	public void initializeSlip(){//matricial
		printElements.add(printCommands.getSlip1());
		printElements.add(printCommands.getSlip2());
		printElements.add(printCommands.getSlip3());
		printElements.add(printCommands.getSlip4());
	}
	
	public void newPage(){
		printElements.add(printCommands.getFormFeedCommand());
	}

	
	public void setFontName(String fontName){
		printElements.add(printCommands.getSetFontNameCommand(fontName));
	}
	
	public void setFontSize(int fontSize){
		printElements.add(printCommands.getSetFontSizeCommand(fontSize));
	}
	
	public void setLeftMargin(int margin){
		printElements.add(printCommands.getSetLeftMarginCommand(margin));
	}
	
	public void setRightMargin(int margin){
		printElements.add(printCommands.getSetRightMarginCommand(margin));
	}

	public void setLineSpacing(int mode) {
		printElements.add(printCommands.getSetLineSpacingCommand(mode));
	}	

	public void setSkipPerforationOn(int lineas) {
		printElements.add(printCommands.getActivateSkipPerforationCommand(lineas));
	}
	
	public void setSkipPerforationOff() {
		printElements.add(printCommands.getDeactivateSkipPerforationCommand());
	}

	public void setInternationalChars(int grupo) {
		printElements.add(printCommands.getSetInternationalCharsCommand(grupo));
	}
	
	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	
	public void setPageLength(int lineas) {
		printElements.add(printCommands.getSetPageLengthCommand(lineas));
	}
	
	public void setCutePartial() {
		printElements.add(printCommands.getCutePartial());
	}
	
	public void setCute() {
		printElements.add(printCommands.getCute());
	}
	
	public void setMoveAlong(int lineas){	
		printElements.add(printCommands.getMoveAlong(lineas));
	}
	
	public void setMoveBack(int lineas){	
		printElements.add(printCommands.getMoveBack(lineas));
	}
	
	public void setInterlineFit(int espacio) {
		printElements.add(printCommands.getInterlineFit(espacio));
	}
	
	public void setCondensedHib(int n) {
		printElements.add(printCommands.getCondensedHib(n));
	}
	
	public void setUnderlined() {
		printElements.add(printCommands.getUnderlined());
	}

        public void setComodin() {
                printElements.add(printCommands.getComodin());
        }
        
}
