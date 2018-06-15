/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dematicket.print;

import java.util.Iterator;

/**
 *
 * @author lmonge
 */
public class TestPrinter {
    
    public static void main(String args[]) {
        DirectPrinter directPrinter = new DirectPrinter();
        directPrinter.initializeReceipt();
        directPrinter.setInterlineFit(45);
        directPrinter.setCondensedHib(1);
        //directPrinter.setCondensedHib(8);//requiere retornar
        //directPrinter.setComodin();
        //Iterator it = refrendo.getTokens().iterator();
        for (int i=0;i<3;i++){
            StringBuffer lineaActual=new StringBuffer("");
            boolean existeComandoEnLinea = false;
            //while (it.hasNext()){
                String token = "Av.Gregorio Escobedo 598 Jesús María";
                if(i==2){
                    directPrinter.setCondensedHib(1); 
                    directPrinter.setCondensedHib(1); 
                    token = "RUC: 20136424867";
                }
                directPrinter.print(CambiaTildes(token));
                /*if (token.equals("\n")){
                    if ((lineaActual.toString().trim().equals("")) && existeComandoEnLinea){
                        lineaActual=new StringBuffer("");
                    }else{
                        directPrinter.println("");
                        lineaActual=new StringBuffer("");
                    }
                    existeComandoEnLinea = false;
                }else 
                    if (isCommandMnemonic(token)){
                        existeComandoEnLinea = true;
                        String comando = token.substring(0,3);
                        String parametro;
                        int finParametro = token.indexOf(" ",4);
                        if (finParametro >=0){
                            parametro = token.substring(4,finParametro);
                        }else{
                            parametro = token.substring(4);
                        }
                        if (comando.equals("FNT")){
                            if (parametro.equals("CI")){ //Condensada
                                directPrinter.setCondensedHib(1); 
                            }else if (parametro.equals("CF")){ //Sin Condensar
                                directPrinter.setCondensedHib(8);
                            }else if (parametro.equals("CP")){ //corte parcial
                                directPrinter.setMoveAlong(7);
                                directPrinter.setCutePartial();
                            }
                        }
                    }else{
                        directPrinter.print(CambiaTildes(token));
                    }*/
            //}
            directPrinter.newPage();
            directPrinter.setMoveAlong(7);
            directPrinter.setCute();
            try{
                directPrinter.printHibrida("EPSON TM-T88V Receipt"); 
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
    
private static byte[] CambiaTildes(String sToken){
byte[] bToken = sToken.getBytes(); 
//Busca ñ, Ñ y minúsculas y maýusculas con tilde y las reemplaza por caracter para DOS.
for (int i=0; i<bToken.length; i++){
switch (bToken[i]){
case (byte)225:
bToken[i] = (byte)160; //á
break;
case (byte)233:
bToken[i] = (byte)130; //é
break;
case (byte)237:
bToken[i] = (byte)161; //í
break;
case (byte)243:
bToken[i] = (byte)162; //ó
break;
case (byte)250:
bToken[i] = (byte)163; //ú
break;
case (byte)193:
bToken[i] = (byte)65; //Á
break;
case (byte)201:
bToken[i] = (byte)69; //É
break;
case (byte)205:
bToken[i] = (byte)73; //Í
break;
case (byte)211:
bToken[i] = (byte)79; //Ó
break;
case (byte)218:
bToken[i] = (byte)85; //Ú
break;
case (byte)241:
bToken[i] = (byte)164; //ñ
break;
case (byte)209:
bToken[i] = (byte)165; //Ñ
break;
case (byte)-80:
bToken[i] = (byte)248; //º
break;
}
}
return bToken;
}

    
}