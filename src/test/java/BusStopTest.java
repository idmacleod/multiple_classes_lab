import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {
    private BusStop busStop;
    private Person person;
    
    @Before
    public void setUp(){
        busStop = new busStop("Tranent High Street");
        person = new Person();
    }

    @Test
    public void queueStartsEmpty() {
        assertEquals(0, busStop.getQueueLength());
    }

    @Test
    public void canAddPersonToQueue(){
        busStop.addToQueue(person);
        assertEquals(1, busStop.getQueueLength());
    }
}
