import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Step 1: Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Inject Mock
        MyService service = new MyService(mockApi);

        // Step 3: Call the method
        service.fetchData();

        // Step 4: Verify interaction
        verify(mockApi).getData();
    }
}