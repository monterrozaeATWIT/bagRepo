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

        static BagInterface<String> dictionaryBagResult = new ResizableArrayBag<>(10_000);
        public static void main( final String[] args ) {
        final BagInterface<String> dictionaryBag = new ResizableArrayBag<>(98568);
        
        try
            {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("./data/american-english-JL.txt")));
            String text = scan.nextLine();
            while(scan.hasNextLine())
                {
                    dictionaryBag.add( text.toLowerCase() );
                    text = scan.nextLine();

                }
            }
        catch ( FileNotFoundException e )
            {
            e.printStackTrace() ;
            }
        
            dictionaryBagResult = dictionaryBag;
        
    }
        public BagInterface<String> getDictionaryBag()
        {
        main(null);
        return this.dictionaryBagResult;
        }
        
        

    }
	// end class Dictionary
