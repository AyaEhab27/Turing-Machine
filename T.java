package turingmachine;

  
import java.util.*;
public class T{
        public static int enter_nStates() throws Exception{
            Scanner sc=new Scanner(System.in);
                System.out.println("Enter The number of states:");

                int nStates=sc.nextInt();
                return nStates;
        }
        public static int enter_nAlphabet(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter The number of Alphabet:");
                int nAlphabet=sc.nextInt();
                 return nAlphabet;
        }
        public static String [] storAlphabet(int size) throws Exception{
            Scanner sc=new Scanner(System.in);
            String []Alphabet=new String[size];
                for(int i=0;i<size;i++){
                    System.out.println("Enter Alphabet Number"+""+(i+1)+":");
                    Alphabet[i]=sc.next();
                }
            return Alphabet;
        }
        public static int enter_nMachine(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter The number Alphabet of Machine :");
                int nMachine=sc.nextInt();
                 return nMachine;
        }
        public static String [] storMachine(int size) throws Exception{
            Scanner sc=new Scanner(System.in);
            String []Machine=new String[size];
                for(int i=0;i<size;i++){
                    System.out.println("Enter Alphabet Number"+""+(i+1)+":");
                    Machine[i]=sc.next();
                }
            return Machine;
        }
        public static int initialState()throws Exception{
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter The Number of  intial state :");
                int intialState=sc.nextInt();
                return intialState;
        }
        public static int hPosition(){
             Scanner sc=new Scanner(System.in);
            System.out.println("Enter The Head Position :");
                int hPosition=sc.nextInt();
                return hPosition;
        }
        public static String[][] Transition(int nStates,int nMachine,int nAlphabet) throws Exception{
            Scanner sc =new Scanner(System.in);
            System.out.print("Enter the transition function  at format: " );
                String[][]transition = new String[(nStates)*(nMachine+nAlphabet)][5];
                for (int i = 0; i < (nStates)*(nMachine+nAlphabet); i++) {
                   System.out.println("\n"+"read State"+ "\n"+"read Symbol"+ "\n"+"write State"+ "\n"+"write Symbol"+ "\n"+"Action"+"\n");
                    for(int j=0;j<5;j++){
                        System.out.print("Enter in position "+"("+i+","+j+")");
                       transition[i][j] = sc.next(); 
                }}
            return transition;
            
        }
	public static void main(String[] args) throws Exception{
	
            Scanner sc=new Scanner(System.in);
            int nStates;
            while(true){
              try{
                 nStates= enter_nStates();
                  break;
              }  
              catch(Exception e){
                  System.out.println(e);
                  System.out.println("Try again .");
                  
              }
            }
            int nAlphabet;
            while(true){
              try{
                 nAlphabet= enter_nAlphabet();
                  break;
              }  
              catch(Exception e){
                  System.out.println(e);
                  System.out.println("Try again .");
                  
              }
            }
            
            while(true){
                try{
                    
                    storAlphabet(nAlphabet);
                    break;
                    
                }
                catch(Exception e){
                    System.out.println(e);
                  System.out.println("Try again .");
                }
            }
            int nMachine;
            while(true){
              try{
                 nMachine= enter_nMachine();
                  break;
              }  
              catch(Exception e){
                  System.out.println(e);
                  System.out.println("Try again .");
                  
              }
            }
            
            while(true){
                try{
                    
                    storMachine(nMachine);
                    break;
                    
                }
                catch(Exception e){
                    System.out.println(e);
                  System.out.println("Try again .");
                }
            }
            System.out.println("Enter The String:");
            String str=sc.next();
            String string=str + "#";
            
            int initialState;
            while(true){
                try{
                    
                   initialState= initialState();
                    break;
                    
                }
                catch(Exception e){
                    System.out.println(e);
                  System.out.println("Try again .");
                }
            }
            int hPosition;
            
            while(true){
                try{
                    
                   hPosition= hPosition();
                    break;
                    
                }
                catch(Exception e){
                    System.out.println(e);
                    
                  System.out.println("Try again .");
                }
            }
            String [][]transition;
            while(true){
                try{
                    
                   transition= Transition(nStates,nAlphabet,nMachine);
                    break;
                    
                }
                catch(Exception e){
                    System.out.println(e);
                    
                  System.out.println("Try again .");
                }
            }
            int currentState = initialState;
            char[] tape = string.toCharArray();
            int currentPosition = hPosition;
            int writeState;
            char writeSymbol;
            char Action;
                while (true) {
            int nRows=-1;
            char readSymbol=tape[currentPosition];
             for (int i = 0; i < (nStates)*(nMachine+nAlphabet); i++) {
                 int rS=Integer.parseInt(transition[i][0]);
                 char rSm=transition[i][1].charAt(0);
                 if(rS==currentState && rSm==readSymbol){
                     nRows =i;
                     break;
                 }
             }
             if(nRows==-1){
                 System.out.println("Symbol Not Found.");
             }
             writeState=Integer.parseInt(transition[nRows][2]);
             writeSymbol=(transition[nRows][3]).charAt(0);
             Action=(transition[nRows][4]).charAt(0);
             tape[currentPosition]=writeSymbol;
            
             if (Action=='Y') {
                System.out.println("String  is accepted .");
                break;
            } else if (Action=='N') {
                System.out.println("String is  rejected .");
                break;
            }
           
            if (Action=='R') {

                currentPosition++;
                 
           
            } else if (Action=='L') {
                currentPosition--;
                 
                
            }
            if (currentPosition < 0 || currentPosition >= tape.length) {
                System.out.println("Head position out of String Of Lenght.");
                break;
            }
            currentState = writeState;
        }
        System.out.println(" then Final configuration is:");       
        System.out.print("(S,"+ str+")");
        System.out.print("|-------");
        System.out.println("(h ,"+ new String (tape)+").");
        System.out.println(" The Head Position is(string numbering starts from zero): " + currentPosition);
    }
}
