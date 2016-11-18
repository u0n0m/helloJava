package com.silentpeople.calculator; 
 
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  
 
public class calculatorMain {  
 
   public static void main(String [] args ) { 
   
      String inputVal;  
      String continueVal = "y";
      
      do{  
         System.out.println("Input:");  
         Scanner scan = new Scanner(System.in);  
         inputVal = scan.nextLine();
           
         System.out.println(inputVal);  
           
         String [] splitValues = inputVal.split("[\\+\\-\\*\\/\\=]");  
          
         System.out.println(splitValues.length);  
           
         for(int cnt=0; cnt<splitValues.length;cnt++) { 
            System.out.println(splitValues[cnt]);  
         }
           
         int [] num = {0,0,0,0,0,0,0,0,0,0};  
         for(int cnt=0; cnt<splitValues.length;cnt++){  
            try{  
               num[cnt] = Integer.parseInt(splitValues[cnt]);  
               System.out.println(num[cnt]);  
            }catch(java.lang.NumberFormatException e){  
               System.out.println("입력 범위 초과: -2147483648~2147483647");  
            }  
         }  
           
         System.out.println(num[0]);  
           
         int signOrder = indexOfChar(Pattern.compile("[\\+\\-\\*\\/\\=]{1}"), inputVal); 
         if(signOrder < 0){
         }
         
         char sign = '+';
         //   	System.out.println(signOrder);  
         sign = inputVal.charAt(signOrder);  
         System.out.println(sign);  
           
           
         if(num[1] == 0 && sign == '/') {  
            System.out.println("0으로 나누기는 불가능합니다. 다시 입력해 주세요!!");  
       	 	//scan.close(); 
            continue;  
         }  
                       
         long result=0;  
         double result2=0.0;  
         switch(sign){  
         case '+':  
            result = (long)num[0]+(long)num[1];  
            System.out.println(result);  
            break;  
         case '-':  
            result = (long)num[0]-(long)num[1];  
            System.out.println(result);  
            break;  
         case '*':  
            result = (long)num[0]*(long)num[1];  
            System.out.println(result);  
         case '/':  
            result2 = (double)num[0] / (double)num[1];  
            System.out.println(result2);  
            break;   
         default:  
            break;  
         }  
         System.out.println("yes(y) or no(n)");  
         continueVal = scan.nextLine(); 
         if(inputVal.equals("n")) { 
        	 scan.close(); 
        	 break;
         }
          
      }while(continueVal.equals("y"));     
   
      System.out.println("종료되었습니다."); 
   }     
     
   public static int indexOfChar(Pattern pattern, String s) { 
	   Matcher matcher = pattern.matcher(s); 
	   return matcher.find() ? matcher.start() : -1; 
   }
   
}  
 