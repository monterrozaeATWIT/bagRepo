package edu.wit.scds.comp2000.bag.app;
import edu.wit.scds.comp2000.bag.BagInterface ;
import edu.wit.scds.comp2000.bag.adt.ResizableArrayBag ;

import java.io.BufferedReader ;
import java.io.FileNotFoundException ;
import java.io.FileReader ;
import java.util.Iterator ;
import java.util.Scanner ;
/**
 * 
 *
 * @author monterrozae
 * @version 1.0.0 2021-09-27 Initial implementation
 *
 */
public class SpellChecker
    {
    public static void main( final String[] args ) throws FileNotFoundException {
    final BagInterface<String> incorrectSpellingBag = new ResizableArrayBag<>(10_000);
    final BagInterface<String> dictionaryBag = new ResizableArrayBag<>(98_568);
    
    //
    try
        {
        Scanner scan = new Scanner(new BufferedReader(new FileReader("./data/american-english-JL.txt")));
        String text = scan.nextLine();
        while(scan.hasNextLine())
            {
                dictionaryBag.add( text.toLowerCase() );//used toLowerCase to ignore capitalization
                text = scan.nextLine();

            }
        }
    catch ( FileNotFoundException e )
        {
        // TODO Auto-generated catch block
        e.printStackTrace() ;
        }
    
    //
       
    Scanner lancashire = new Scanner(new BufferedReader(new FileReader("./data/the-lancashire-cotton-famine.txt")));
    Scanner wit = new Scanner(new BufferedReader(new FileReader("./data/wit-attendance-policy.txt")));
    Scanner sources = new Scanner(new BufferedReader(new FileReader("./data/sources.txt")));

    
    Object[] lancashireArray = toArray(lancashire);
    Object[] witArray = toArray(wit);
    Object[] sourcesArray = toArray(sources);


    for(int i = 0; i < witArray.length; i++) {
    if(!dictionaryBag.contains((String) witArray[i] ))
        {
            if(!incorrectSpellingBag.contains((String) witArray[i]))
            incorrectSpellingBag.add((String) witArray[i] );
            System.out.println( witArray[i] ) ;
        }
    }
    for(int i = 0; i < lancashireArray.length; i++) {
    if(!dictionaryBag.contains((String) lancashireArray[i] ))
        {
            if(!incorrectSpellingBag.contains((String) lancashireArray[i]))
            incorrectSpellingBag.add((String) lancashireArray[i] );
            System.out.println( lancashireArray[i] ) ;
        }
        
    }
    
    if(!dictionaryBag.contains((String) sourcesArray[i] ))
        {
            if(!incorrectSpellingBag.contains((String) sourcesArray[i]))
            incorrectSpellingBag.add((String) sourcesArray[i] );
            System.out.println( sourcesArray[i] ) ;
        }
    }
	    
    
    System.out.println( "================" ) ;
        
    Object[] printArray = incorrectSpellingBag.toArray();
    
    for(int i = 0; i < printArray.length; i++)
        {
        System.out.println( printArray[i] ) ;
        }
    }

      public static Object[] toArray(Scanner scan)
      {
          final BagInterface<String> bag = new ResizableArrayBag<>(10_000);
          Object[] result;
          do {
          String text = scan.nextLine();
          String[] arr = text.split("\\W+"); //uses regex to separate words from a line to an individual element in an array
          for(int i = 0; i < arr.length; i++)       //currently not removing commas or periods, only separating words by spaces
              {
                  if(!arr[i].equals( "" )) {       //ignore empty lines (for wit-attendance file)
                  bag.add( arr[i].toLowerCase() ); //used toLowerCase to ignore capitalized words, since we are focusing on spelling
                  }
                  }                                    //also fixes issue of words spelled correctly, but put in the wrong bag due to capitalization
                  
          }while(scan.hasNextLine());
          
          result = bag.toArray();
          return result;
      }

 
    }
	// end class SpellChecker
