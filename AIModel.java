/**
 * AIModel is an abstract parent class 
 * that focuses on token calculation logic 
 * and will prevent code duplication
 */

public abstract class AIModel {
    
    //Attributes
   private String modelName; //Name of the ai mode
   private double price; //price in NPR per 1 lakh tokens
   private int parameterCount; //parameters in billions
   private int contextWindow; //represents max tokens per request
   
   //fixed tokens used for token calculation
   private static final int FIXED_TOKENS = 50;
   
   // constructor that accepts 4 arguements to initialize attributes
   public AIModel(String modelName, double price, int parameterCount, int contextWindow) {
      this.modelName = modelName;
      this.price = price;
      this.parameterCount = parameterCount;
      this.contextWindow = contextWindow;
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
    * 4. Return true if and only if given prompt so are within the context window
    */
   public boolean calculateTokenUsage(String promptText, int outputTokens) {
       /**assuming 4 letters = 1 token
        * used math.max so that if prompt text is 1 word only
        * then the token usage instead of being 0.25, 
        * maximum value will go and be set on the variable,
        * in this case instead of 0.25 it sets 1 as the inputToken
        */
       int inputTokens = Math.max(1, promptText.length() / 4);
       int totalUsage = inputTokens + outputTokens + FIXED_TOKENS; 
       
       //to check whether the logic works or not
       System.out.println("Estimated total usage = " + totalUsage + " tokens.");
       //checks whether the prompt does or doesn't exceed the context window and returns either true or false
       return totalUsage <= this.contextWindow;
   }
   public abstract String display();
}