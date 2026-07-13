import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {

        // Create Mock
        RestClient mockRestClient = mock(RestClient.class);

        // Stub the response
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Inject mock into service
        ApiService apiService = new ApiService(mockRestClient);

        // Call method
        String result = apiService.fetchData();

        // Verify result
        assertEquals("Fetched Mock Response", result);
    }
}