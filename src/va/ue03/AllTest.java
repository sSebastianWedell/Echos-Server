package va.ue03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AllTest {
	// ACHTUNG: damit Tests laufen, muss vorher Server gestartet werden
	Ue03DirectoryClient uedc;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		uedc = new Ue03DirectoryClient();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
	}

	/**
	 * Test der Query-Funktion auf mitgeschickte SID
	 */
	@Test
	void testQuery() {
		
		// In der spaeteren Implementation wuerden wir bei der Query-Anfrage alle registrierten 
		// Teilnehmer erwarten. 
		// In diesem Fall erwarten wir ein JSONString mit der gesendeten Anfrage
		
		String echoAnswer 	= uedc.query("bla");
		JSONObject jo 		= (JSONObject)JSONValue.parse(echoAnswer);
		String echoSID 		= (String)jo.get("SID");
		
		assertEquals("bla", echoSID);			// Ergebnis-Vergleich fuer den TEST
	}
	
	/**
	 * Test der query-function auf leere SID
	 */
	@Test
	void testQueryEmptySID()
	{
		String echoAnswer = uedc.query(null); 
		JSONObject jo = (JSONObject)JSONValue.parse(echoAnswer);
		String echoSID = (String)jo.get("SID");
		
		assertEquals(null, echoSID);			// Ergebnis-Vergleich fuer den TEST
	}

	@Test
	void testReturnNumber()
	{
		int returnedNumber = uedc.returnNumber(123);
		assertEquals(123, returnedNumber);
			
	}
	
	/**
     * Test der Register-Funktion mit allen Werten
     */
    @Test
    void testRegister() {
        String name = "Client1";
        String value = "127.0.0.1:8080";
        String SID = "1";
        String echoAnswer   = uedc.register(name, value, SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoName     = (String)jo.get("name");
        String echoValue    = (String)jo.get("value");
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(name, echoName);
        assertEquals(value, echoValue);
        assertEquals(SID, echoSID);
    }
    
    /**
     * Test der Register-Funktion ohne SID
     */
    @Test
    void testRegisterNoSID() {
        String name = "Client1";
        String value = "127.0.0.1:8080";
        String SID = null;
        String echoAnswer   = uedc.register(name, value, SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoName     = (String)jo.get("name");
        String echoValue    = (String)jo.get("value");
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(name, echoName);
        assertEquals(value, echoValue);
        assertEquals(SID, echoSID);
    }
    
    /**
     * Test der Register-Funktion ohne Name
     */
    @Test
    void testRegisterNoName() {
        String name = null;
        String value = "127.0.0.1:8080";
        String SID = "1";
        String echoAnswer   = uedc.register(name, value, SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoName     = (String)jo.get("name");
        String echoValue    = (String)jo.get("value");
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(name, echoName);
        assertEquals(value, echoValue);
        assertEquals(SID, echoSID);
    }
    
    /**
     * Test der Register-Funktion ohne Value
     */
    @Test
    void testRegisterNoValue() {
        String name = "Client1";
        String value = null;
        String SID = "1";
        String echoAnswer   = uedc.register(name, value, SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoName     = (String)jo.get("name");
        String echoValue    = (String)jo.get("value");
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(name, echoName);
        assertEquals(value, echoValue);
        assertEquals(SID, echoSID);
    }
    
    /**
     * Test der Register-Funktion mit nur einem gesetzten Parameter
     */
    @Test
    void testRegisterOneParamSet() {
        String name = null;
        String value = null;
        String SID = "1";
        String echoAnswer   = uedc.register(name, value, SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoName     = (String)jo.get("name");
        String echoValue    = (String)jo.get("value");
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(name, echoName);
        assertEquals(value, echoValue);
        assertEquals(SID, echoSID);
    } 
    
    /**
     * Test der Unregister-Funktion mit allen Werten
     */
    @Test
    void testUnregister() {
        String name = "Client1";
        String SID = "1";
        String echoAnswer   = uedc.unregister(name, SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoName     = (String)jo.get("name");
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(name, echoName);
        assertEquals(SID, echoSID);
    }
    
    /**
     * Test der Unregister-Funktion ohne SID
     */
    @Test
    void testUnregisterNoSID() {
        String name = "Client1";
        String SID = null;
        String echoAnswer   = uedc.unregister(name, SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoName     = (String)jo.get("name");
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(name, echoName);
        assertEquals(SID, echoSID);
    }
    
    /**
     * Test der Unregister-Funktion ohne Name
     */
    @Test
    void testUnregisterNoName() {
        String name = null;
        String SID = "1";
        String echoAnswer   = uedc.unregister(name, SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoName     = (String)jo.get("name");
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(name, echoName);
        assertEquals(SID, echoSID);
    }
    
    /**
     * Test der Reset-Funktion mit allen Werten
     */
    @Test
    void testReset() {
        // register mit gültigen Werten
        String SID = "1";
        String echoAnswer   = uedc.reset(SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoSID      = (String)jo.get("SID");
        
        assertEquals(SID, echoSID);
    }
    
    /**
     * Test der Reset-Funktion ohne SID
     */
    @Test
    void testResetNoSID() {
        // register mit gültigen Werten
        String SID = null;
        String echoAnswer   = uedc.reset(SID);
        JSONObject jo       = (JSONObject)JSONValue.parse(echoAnswer);
        String echoSID      = (String)jo.get("SID");
        
        // dieser Test ist grün: keine Werte sind gesetzt, also kann auch nichts kaputt geschrieben werden
        assertEquals(SID, echoSID);
    } 
    
}
