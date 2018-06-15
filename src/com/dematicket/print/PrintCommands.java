package com.dematicket.print;

public interface PrintCommands {
	public byte[] getInitializeCommand();
	public byte[] getCRCommmand();
	public byte[] getLFCommand();
	public byte[] getFormFeedCommand();
	public byte[] getSetFontNameCommand(String fontName);
	public byte[] getSetFontSizeCommand(int fontSize);
	public byte[] getActivateCondensedFontCommand();
	public byte[] getDeactivateCondensedFontCommand();
	public byte[] getActivateProportionalModeCommand();
	public byte[] getDeactivateProportionalModeCommand();
	public byte[] getActivateBoldFontCommand();
	public byte[] getDeactivateBoldFontCommand();
	public byte[] getActivateDraftModeCommand();
	public byte[] getDeactivateDraftModeCommand();
	public byte[] getSetLeftMarginCommand(int margin);
	public byte[] getSetRightMarginCommand(int margin);
	public byte[] getSetLineSpacingCommand(int mode);
	public byte[] getActivateSkipPerforationCommand(int lineas);
	public byte[] getDeactivateSkipPerforationCommand();
	public byte[] getSetInternationalCharsCommand(int grupo);
	public byte[] getSetPageLengthCommand(int lineas);
	//nuevos 28/09/2016
	public byte[] getSlip1();	
	public byte[] getSlip2();
	public byte[] getSlip3();	
	public byte[] getSlip4();
	public byte[] getHorizontal();
	public byte[] getVertical();
	public byte[] getCutePartial();
	public byte[] getCute();
	public byte[] getMoveAlong(int lineas);
	public byte[] getMoveBack(int lineas);	
	public byte[] getInterlineFit(int espacio);
	public byte[] getCondensedHib(int n);	
	public byte[] getUnderlined();
	public byte[] getComodin();
	public byte[] getDefaultAligment();
        public byte[] getLeftAligment();
        public byte[] getCenterAligment();
        public byte[] getRightAligment();
}
