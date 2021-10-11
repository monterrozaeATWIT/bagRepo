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
public class Scanning
    {
    
    
    private  BagInterface<String> dictionaryBag = new ResizableArrayBag<>(10_000);
    private  Object[] lancashireArray;
    private  Object[] witArray;
    private  Object[] sourcesArray;
    
    /**
     * no-arg constructor initializes instance variables
     * 
     */
    public Scanning() 
    {
    
    Scanner lancashire = null ;
    Scanner wit = null;
    Scanner sources = null;
    Scanner dictionary = null;

    try
        {
        lancashire = new Scanner(new BufferedReader(new FileReader("./data/the-lancashire-cotton-famine.txt"))) ;
        wit = new Scanner(new BufferedReader(new FileReader("./data/wit-attendance-policy.txt")));
        sources = new Scanner(new BufferedReader(new FileReader("./data/sources.txt")));
        dictionary = new Scanner(new BufferedReader(new FileReader("./data/american-english-JL.txt")));

        }
    
    catch ( FileNotFoundException e ) //In case the file is not found
        {
        System.out.println( "Missing files" ) ;
        }
    
    this.lancashireArray = toArray(lancashire);
    this.witArray = toArray(wit);
    this.sourcesArray = toArray(sources);
    
    String text = dictionary.nextLine();       //making the dictionary bag
    while(dictionary.hasNextLine())
        {
            dictionaryBag.add( text.toLowerCase() );
            text = dictionary.nextLine();

        }
    
    
    
    }
    
    
    
    
        
      /**
     * Takes lines from the supplied text file and processes individual words, which is stored into an array 
     * 
     * 
     * @return
     */
    public static Object[] toArray(Scanner scan)
      {
          final BagInterface<String> bag = new ResizableArrayBag<>(10_000);
          Object[] result;
          do {
          String text = scan.nextLine();
          
          String[] arr = text.split("\\W+");//uses regex to separate words from a line to an individual element in an array
          for(int i = 0; i < arr.length; i++)       //currently counting numbers as words somehow
              {
                  if(!arr[i].equals( "" )) {       //ignore empty lines (e.g. for wit-attendance file)
                  bag.add( arr[i].toLowerCase() ); //used toLowerCase to ignore capitalized words, since we are focusing on spelling
                  }
                  }                                    //also fixes issue of words spelled correctly, but put in the wrong bag due to capitalization
                  
          }while(scan.hasNextLine());
          
          result = bag.toArray();
          return result;
      }

    
    /**
     * @return dictionaryBag
     */
    public BagInterface<String> getDictionaryBag()
        {
            
            return dictionaryBag;
        }
    
    /**
     * @return the lancashireArray
     */
    public Object[] getLancashireArray()
        {
            return lancashireArray ;
        }
    
    /**
     * @return the sourcesArray
     */
    public Object[] getSourcesArray()
        {
            return sourcesArray ;
        }
    
    /**
     * @return the witArray
     */
    public Object[] getWitArray()
        {
            return witArray ;
        }

    public static void main( final String[] args )  {
    
    }

 
 
    }
	// end class Scanning
