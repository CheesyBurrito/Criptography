/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hills.cipher;

/**
 *
 * @author willi
 */
public class CipherLogic {
    
    final static String REF = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
    
    public static String cipherText(int[][] key, String txt){
        txt = txt.toUpperCase();
        
        while(txt.length() % 3 != 0){
            txt += " ";
        }
        
        char[] charArray = txt.toCharArray();
        
        String cipherTxt = "";
        
        for(int i = 0; i < charArray.length; i++){
            int num1 = REF.indexOf(charArray[i]);
            
            int num2 = REF.indexOf(charArray[++i]);
            
            int num3 = REF.indexOf(charArray[++i]);
            
            int cipherNum1 = (key[0][0] * num1 + key[0][1] * num2 + key[0][2] * num3) % 27;
            int cipherNum2 = (key[1][0] * num1 + key[1][1] * num2 +key[1][2] * num3) % 27;
            int cipherNum3 = (key[2][0] * num1 + key[2][1] * num2 + key[2][2] * num3) % 27;
            
            cipherTxt += REF.charAt(cipherNum1) + "" + REF.charAt(cipherNum2) + "" + REF.charAt(cipherNum3);
        }
        return cipherTxt;
    }
    
}
