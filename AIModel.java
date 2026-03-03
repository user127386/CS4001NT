/**
 * AIModel is an abstract parent class 
 * that focuses on token calculation logic 
 * and will prevent code duplication
 */

import java.util.Scanner;

public abstract class AIModel {
    
    //Attributes
   private String modelName; //Name of the ai mode
   private double price; //price in NPR per 1 lakh tokens
   private int parameterCount; //parameters in billions
   private int contextWindow; //represents max tokens per request
   
   //fixed tokens used for token calclation
   private static final int fixed_tokens = 50;
   
   // contructor that accepts4 parameters to initialize attributes
   public AIModel(String modelName, double price, int parameterCount, int contextWindow) {
      this.modelName = modelName;
      this.price = price;
      this.contextWindow = contextWindow;
      this.parameterCount = parameterCount;
   }

   //getter methods to access all attributes
   public String getModelName() {
      return this.modelName;
   }

   public double getPrice() {
      return this.price;
   }

   public int getParameterCount() {
      return this.parameterCount;
   }

   public int getContextWindow() {
      return this.contextWindow;
   }

   /**
    * core token calculation logics:
    * 1. Estimate input tokens from prompt text.
    * 2. Get output tokens(user provided value).
    * 3. Add fixed system tokens.
    * 4. Return true if and only if total tokens are within the context window
    */
   public boolean calculateTokenUsage() {
       Scanner ex = new Scanner();
       
       System.out.println("Enter prompt text: ");
       String promptText = ex.nextLine();
       
       int estm = 
   }
}