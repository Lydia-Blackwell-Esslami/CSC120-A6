import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine testEngine = new Engine(FuelType.ELECTRIC, 50, 200);
        assertEquals(FuelType.ELECTRIC, testEngine.getFuelType());
        assertEquals(50, testEngine.getCurrentFuel(), 0.0);
        assertEquals(200, testEngine.getMaxFuel(), 0.0);
    }

    @Test
    public void testEngineGo() {
        Engine testEngine = new Engine(FuelType.ELECTRIC, 200, 200);
        for (int i = 0; i < 4; i++) {
            testEngine.go();
        }
        assertFalse(testEngine.go());
        
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car testCar  = new Car(3);
        Passenger testPassengerA = new Passenger("A");
        assertTrue(testCar.addPassenger(testPassengerA));

    }

    @Test
    public void testCarRemovePassenger() {
        Car testCar  = new Car(3);
        Passenger testPassengerA = new Passenger("A");
        testCar.addPassenger(testPassengerA);
        assertTrue(testCar.removePassenger(testPassengerA));
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car testCar  = new Car(3);
        Passenger testPassengerA = new Passenger("A");
        testPassengerA.boardCar(testCar);
        assertEquals(1, testCar.passengers.size());
    }

    @Test
    public void testPassengerBoardCarFull() {
        Car testCar  = new Car(0);
        Passenger testPassengerA = new Passenger("A");
        testPassengerA.boardCar(testCar);
        assertEquals(0, testCar.passengers.size());
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        Train testTrain = new Train(FuelType.STEAM, 100, 3, 30);
        assertEquals(FuelType.STEAM, testTrain.getEngine().getFuelType());
        assertEquals(100, testTrain.getEngine().getMaxFuel(), 0.0);
        assertEquals(3, testTrain.cars.size());
        assertEquals(90, testTrain.getMaxCapacity());

    }

    @Test
    public void testTrainPassengerCount() {
        Train testTrain = new Train(FuelType.STEAM, 100, 3, 30);
        for (int i = 0; i < (testTrain.cars.size()); i++) {
            Car car = testTrain.cars.get(i);
            Passenger passenger = new Passenger("A");
            car.addPassenger(passenger);
        }
        assertEquals(87, testTrain.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        Train testTrain = new Train(FuelType.STEAM, 100, 3, 30);
        assertSame(testTrain.cars.get(2), testTrain.getCar(2));
    }

    @Test
    public void testTrainPrintManifest() {
        Train testTrain = new Train(FuelType.STEAM, 100, 3, 30);
        for (int i = 0; i < (testTrain.cars.size()); i++) {
            Car car = testTrain.cars.get(i);
            Passenger passenger = new Passenger("A");
            car.addPassenger(passenger);
        }    
        testTrain.printManifest();
    }
    
}
