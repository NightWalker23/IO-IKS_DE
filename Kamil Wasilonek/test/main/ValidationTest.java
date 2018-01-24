package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationTest {

    @Test
    public void getInt () throws Exception {

        for ( int i = 1; i < 10; i++ ) {
            assertEquals( "Output of get int have to be 1 to 10", i, Validation.validateInt( String.valueOf( i ), 1, 10 ) );
        }

        char ch = 'c';
        assertEquals( "Output of get int have to be int", -1, Validation.validateInt( "testText", 1, 2 ) );
        assertEquals( "Output of get int have to be int", -1, Validation.validateInt( "4.8", 1, 2 ) );
        assertEquals( "Output of get int have to be int", -1, Validation.validateInt( String.valueOf( ch ), 1, 2 ) );
        assertEquals( "Output of get int have to be int", -1, Validation.validateInt( null , 1, 2 ) );
    }

    @Test
    public void getIntID () throws Exception {
        assertEquals( -1, Validation.validateIntID( String.valueOf( 0 ) ) );
        assertEquals( -1, Validation.validateIntID( String.valueOf( -5 ) ) );
        assertEquals( 5, Validation.validateIntID( String.valueOf( 5 ) ) );
        assertEquals( 1, Validation.validateIntID( String.valueOf( 1 ) ) );
        assertEquals( -1, Validation.validateIntID( null ) );

    }

    @Test
    public void validateUsername () throws Exception {
        assertEquals( "Kamil" , Validation.validateUsername( "Kamil") );
        assertEquals( null , Validation.validateUsername( "K") );
        assertEquals( null , Validation.validateUsername( "Ka") );
        assertEquals( "Kam" , Validation.validateUsername( "Kam") );
        assertEquals( null , Validation.validateUsername( null) );
        assertEquals( null , Validation.validateUsername( "!") );
        assertEquals( null , Validation.validateUsername( " ") );
        assertEquals( null , Validation.validateUsername( ".") );
    }
}