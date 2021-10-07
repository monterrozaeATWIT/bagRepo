package edu.wit.scds.comp2000.bag.app;

import edu.wit.scds.comp2000.bag.BagInterface ;
import edu.wit.scds.comp2000.bag.adt.ResizableArrayBag ;

import java.io.BufferedReader ;
import java.io.FileNotFoundException ;
import java.io.FileReader ;
import java.util.Scanner ;

/**
 * 
 *
 * @author monterrozae
 * @version 1.0.0 2021-10-01 Initial implementation
 *
 */
public class Dictionary
    {
        public static void main( final String[] args ) {
        final BagInterface<String> dictionaryBag = new ResizableArrayBag<>(98568);
        
        try
            {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("./data/american-english-JL.txt")));
            String text = scan.nextLine();
            while(scan.hasNextLine())
                {
                    dictionaryBag.add( text );
                    text = scan.nextLine();
                    System.out.println(text);

                }
            }
        catch ( FileNotFoundException e )
            {
            // TODO Auto-generated catch block
            e.printStackTrace() ;
            }
            
        //System.out.println(dictionaryBag.contains( "flax" ));
        
    }

    }
	// end class Dictionary