import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {
    private Bus bus;
    private Person person;
    private BusStop busStop;

    @Before
    public void setUp() {
        bus = new Bus("Tranent", 3);
        person = new Person();
        busStop = new BusStop("Tranent High Street");
        busStop.addToQueue(person);
    }

    @Test
    public void canGetPassengers() {
        assertEquals(0, bus.countPassengers());
    }

    @Test
    public void canAddPassenger() {
        bus.addPassenger(person);
        assertEquals(1, bus.countPassengers());
    }

    @Test
    public void cannotAddPassengersIfBusIsFull() {
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(3, bus.countPassengers());
    }

    @Test
    public void canRemoveAPassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.removePassenger();
        assertEquals(1, bus.countPassengers());
    }

    @Test
    public void cannotRemovePassengerFromEmptyBus() {
        bus.removePassenger();
        assertEquals(0, bus.countPassengers());
    }

    @Test
    public void canPickUpFromBusStop() {
        bus.pickUp(busStop);
        assertEquals(1, bus.countPassengers());
        assertEquals(0, busStop.getQueueLength());
    }
}
