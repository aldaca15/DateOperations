package DateOperations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
* A class to show how easy is to perform date parse
* using Java SimpleDateFormat class
*
* @author Ali Adame
* @version 1.0
* @since 2019-02-25
*/
public class ParsingWithSimpleDateFormat {
    
    public static void main(String[] args) {
        
        // In the next lines we'll cover a couple examples of efficient parsing with the SimpleDateFortam class
        
        String textDateEnglish = "05-05-2019";
        String textDateFrench = "2019/janvier/31";
        String textDateSpanish = "10 de Octubre de 2018";
        String textDateSpanish2 = "15 de   diciembre del    2018";
        
        // Parsing text in english
        try {
            java.util.Date newEnglishDate = new SimpleDateFormat("MM-dd-yyyy").parse(textDateEnglish);
            System.out.println(newEnglishDate);
        } catch (ParseException ex) {
            System.out.println("Parsing error of french text: "+ex.getMessage());
        }
        
        // Parsing text in french
        try {
            java.util.Date newFrenchDate = new SimpleDateFormat("yyyy/MMMM/dd", new Locale("FR", "FR")).parse(textDateFrench);
            System.out.println(newFrenchDate); // It's january 31st, 2019!
        } catch (ParseException ex) {
            System.out.println("Parsing error of french text: "+ex.getMessage());
        }
        
        // Parsing text in spanish
        try {            
            java.util.Date newSpanishDate = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("ES", "MX")).parse(textDateSpanish);
            System.out.println(newSpanishDate); // October 10th, 2018
        } catch (ParseException ex) {
            System.out.println("Parsing error of spanish text: "+ex.getMessage());
        }
        
        try {            
            // We can re-try the parse exception to intend another text parsing option            
            textDateSpanish2 = textDateSpanish2.replaceAll("^ +| +$|( )+", "$1");
            System.out.println(textDateSpanish2); // Text was '15 de   diciembre del    2018'
            // Previous line explanation can be found at stackoverflow
            // https://stackoverflow.com/questions/2932392/java-how-to-replace-2-or-more-spaces-with-single-space-in-string-and-delete-lead
            
            java.util.Date newSpanishDate = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy", new Locale("ES", "MX")).parse(textDateSpanish2);
            System.out.println(newSpanishDate); // December 15th, 2018
        } catch (ParseException ex) {
            System.out.println("Parsing error of spanish text: "+ex.getMessage());
        } catch (Exception e) {
            // Or a simple exception to deal with something more generic
            System.out.println("Another error of spanish text: "+e.getMessage());
        }
        
    }
    
}
