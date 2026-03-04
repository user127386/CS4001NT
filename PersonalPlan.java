public class PersonalPlan extends AIModel {
    //tracks remaining requests for the month
    private int promptRemaining;
    
    public PersonalPlan(String modelName, double price, int parameterCount, int contextWindow, int promptRemaining){
        super(modelName, price, parameterCount, contextWindow);
        this.promptRemaining = promptRemaining;
    }
    
    public String purchasePrompt(int amount) {
        if (amount <= 0) {
            return "ERROR: amount must be positive";
        }
        promptRemaining += amount;
        return "Successfully purchased!! " + amount + " prompts. Prompts Amount: " + promptRemaining;
    }
    
    public String usePrompt(String promptText, int outputTokens) {
        //Quota Check 
        if (promptRemaining <= 0){
            return "Monthly Quota Exhausted :( ";
        }
        //Context Check
        boolean withinContext = calculateTokenUsage(promptText, outputTokens);
        if (!withinContext) {
            return "Context Limit Reached!!";
        }
        //Successfull
        promptRemaining -= 1;
        return "Prompts used. Prompts Remained: " + promptRemaining;
    }
    
    @Override
    public String display() {
        return "Personal plan\n" 
        + "Model: " + getModelName() + "\n" 
        + "Price: " + getPrice() + " NPR\n"
        + "Parameters: " + getParameterCount() + "\n" 
        + "Context Window: " + getContextWindow() + " tokens\n" 
        + "Prompts Remaining(Monthly Quota): " + getPromptRemaining();
    }
    
    //getter method for promptRemaining 
    public int getPromptRemaining(){
        return promptRemaining;
    }
}