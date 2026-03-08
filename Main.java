import java.util.Scanner;

public class Main{
    public static void main(String[] x){
        Scanner ex = new Scanner(System.in);
        PersonalPlan personal = new PersonalPlan("Kola-PersonalAI", 0, 20, 500, 120);
        
        ProPlan pro = new ProPlan("Kola-ProAI", 1999.9, 100, 500, 6);
        
        System.out.println("=========AI PLANS==========");
        System.out.println(personal.display());
        System.out.println();
        System.out.println(pro.display());
        System.out.println();
        
        System.out.println("=========LOGISTICS DEMONSTRATION==========");
        while(true){
            System.out.println("Currently using peronal plan. Generating...");
            String result = personal.usePrompt("Hello", 10);
            System.out.println(result);
            if("Monthly Quota Exhausted".equals(result)){
                break;
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Purchasing 100 more prompts for your personal plan....");
        System.out.println(personal.purchasePrompt(100));
        System.out.println(personal.display());
        
        System.out.println();
        System.out.println("Entering a long prompt so that input tokens + output tokens + fixed tokens is greater then context window");
        String longPrompt = "a".repeat(1800);
        String personalLimit = personal.usePrompt(longPrompt, 0);
        System.out.println("Result: " + personalLimit);
        
        System.out.println("\nTesting context limit on ProPlan...");
        String proLimit = pro.usePrompt("a".repeat(1800), 0);
        System.out.println("Result: " + proLimit);
        
        System.out.println("\nTesting valid ProPlan prompt (no quota limit)...");
        String proValid = pro.usePrompt("Hello", 10);
        System.out.println("Result: " + proValid);
    }
}