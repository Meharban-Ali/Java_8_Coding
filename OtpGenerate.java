import java.util.Random;

public class OtpGenerate {
    
    public static void main(String[] args) {
        
        System.out.println("This is Computer Science Book");
        Random random = new Random();
        String otp="";

        for(int i=0; i<=5; i++){
           int digit = random.nextInt(10);
           otp+=digit;
        }
        System.out.println("Otp Generated Succesfully..");
        System.out.println("OTP: "+otp);
    }
}
