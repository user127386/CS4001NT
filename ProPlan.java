public class ProPlan extends AIModel{
    private int availableSlots;
    
    public ProPlan(String modelName, double price, int parameterCount, int contextWindow, int availableSlots){
        super(modelName, price, parameterCount, contextWindow);
        this.availableSlots = availableSlots;
    }
    
    public String addTeamMember(){
        if (availableSlots <= 0) {
            return "Alert!! No more slots remaining for any new members.";
        }
        availableSlots -= 1;
        return "New Member Added!!" + "\n" + "Remaining slots: " + availableSlots;
    }
    
    public String removeTeamMember(){
        availableSlots += 1;
        return "Your Team member has been removed. Available Slots: ";
    }
    
    public String usePropmt(String promptText, int outputTokens) {
        boolean withinContext = calculateTokenUsage(promptText, outputTokens);
        if (withinContext){
            return "Prompt Received. Since You have pro plan no quota was reduced.";
        }
        return "ERROR: Context Limit Reached!!";
    }
    
    @Override
    public String display() {
        return "Pro/Team plan\n" 
        + "Model: " + getModelName() + "\n" 
        + "Price: " + getPrice() + " NPR\n"
        + "Parameters: " + getParameterCount() + "\n" 
        + "Context Window: " + getContextWindow() + " tokens\n" 
        + "Available Slots For A Team: " + getAvailableSlots();
    }
    
    public int getAvailableSlots(){
        return availableSlots;
    }
}