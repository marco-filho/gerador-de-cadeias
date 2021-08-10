import java.util.regex.*;
import java.util.Random;
import java.util.Scanner;

class stringGenerator {
    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    private static String[] outputs = new String[5];

    public static void main(String[] args) {
        System.out.println("Insira a expressão regular: ");
        while(true)
            if(getInput()) {
                System.out.println("Input válido.");
                break;
            } else 
                System.out.println("Input inválido, tente novamente.");

        System.out.println("Deseja gerar quantas cadeias?");
        int amount = scanner.nextInt();
        outputs = amount > 0 ? new String[amount] : outputs;
        generateStrings();
        
        System.out.println("Possíveis cadeias geradas:");
        for (String output : outputs) {
            System.out.println(output);
        }
    }

    //tratamento e validação de input
    static boolean getInput() {
        input = scanner.nextLine();
        input = input.replace("^+", "*");
        input = input.replaceFirst("\\*{2,}", "*");
        System.out.println("Input lido: " + input);
        
        int openParenth = 0, closeParenth = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') openParenth++;
            else if (c == ')') closeParenth++;
        }
        if (openParenth != closeParenth) return false;

        Pattern p = Pattern.compile("\\(*\\w[\\(*[\\w|\\*|\\(*]\\)*]*");
        Matcher m = p.matcher(input);
        return m.matches();
    }

    //geração de cadeias aleatórias
    static void generateStrings() {
        char[] regex = input.toCharArray();
        String output = "";
        Random random = new Random();
        
        for (int c = 0; c < outputs.length; c++) {
            for (int i = 0; i < regex.length; i++) {
                if (regex[i] == '*') continue;
                
                if ((i + 1 == regex.length || regex[i+1] != '*') && regex[i] != '(') {
                    output += regex[i];
                    continue;
                }
                
                String onParentheses = "";
                if (regex[i] == '(') {
                    i++;
                    while (regex[i] != ')') {
                        onParentheses += regex[i];
                        i++;
                    }
                }
                for (int j = 0; j < random.nextInt(11); j++)
                    output +=
                        (onParentheses.equals("") &&
                        String.valueOf(regex[i]).matches("\\w"))
                        ? regex[i] : onParentheses;
            }
            outputs[c] = output;
            output = "";
        }
    }
}