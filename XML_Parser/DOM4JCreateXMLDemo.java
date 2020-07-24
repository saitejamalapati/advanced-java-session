import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DOM4JCreateXMLDemo {

   public static void main(String[] args) {
      
      try {
         Document document = DocumentHelper.createDocument();
         Element root = document.addElement( "SuperHeroes" );
         Element marvelElement = root.addElement("CinematicUniverse")
            .addAttribute("name", "Marvel");

         marvelElement.addElement("SuperHero")
            .addAttribute("name", "Peter Parker")
            .addText("Spider Man");

         marvelElement.addElement("SuperHero")
            .addAttribute("name", "Carol Danvers")
            .addText("Captain Marvel");

        Element dcElement = root.addElement("CinematicUniverse")
            .addAttribute("name", "DC");

         dcElement.addElement("SuperHero")
            .addAttribute("name", "Bruce Banner")
            .addText("Bat Man");

         dcElement.addElement("SuperHero")
            .addAttribute("name", "Diana Prince")
            .addText("Wonder Woman");

         // Pretty print the document to System.out
         OutputFormat format = OutputFormat.createPrettyPrint();
         XMLWriter writer;
         writer = new XMLWriter( System.out, format );
         writer.write( document );
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}