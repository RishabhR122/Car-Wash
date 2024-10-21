package com.washerplatform;

import com.washerplatform.controller.WasherController;
import com.washerplatform.models.WasherProfile;
import com.washerplatform.service.WasherProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WasherControllerTest {

    @InjectMocks
    private WasherController washerController;

    @Mock
    private WasherProfileService washerProfileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addWasher_shouldReturnCreatedWasher() {
        WasherProfile washerProfile = new WasherProfile();
        washerProfile.setFullName("John Doe");
        
        when(washerProfileService.addWasher(any(WasherProfile.class))).thenReturn(washerProfile);

        ResponseEntity<WasherProfile> response = washerController.addWasher(washerProfile);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("John Doe", response.getBody().getFullName());
        verify(washerProfileService, times(1)).addWasher(any(WasherProfile.class));
    }

    @Test
    void updateDetails_shouldReturnOk() {
        WasherProfile updatedProfile = new WasherProfile();
        
        doNothing().when(washerProfileService).updateDetails(anyString(), any(WasherProfile.class));

        ResponseEntity<Void> response = washerController.updateDetails("john@example.com", updatedProfile);

        assertEquals(200, response.getStatusCodeValue());
        verify(washerProfileService, times(1)).updateDetails(eq("john@example.com"), any(WasherProfile.class));
    }

    @Test
    void getAllWashers_shouldReturnListOfWashers() {
        List<WasherProfile> washerList = new ArrayList<>();
        washerList.add(new WasherProfile());
        
        when(washerProfileService.getAllWashers()).thenReturn(washerList);

        List<WasherProfile> response = washerController.getAllWashers();

        assertNotNull(response);
        assertEquals(1, response.size());
        verify(washerProfileService, times(1)).getAllWashers();
    }

    @Test
    void getWasher_shouldReturnListOfWashers() {
        List<WasherProfile> washerList = new ArrayList<>();
        washerList.add(new WasherProfile());
        
        when(washerProfileService.getWasher(anyString())).thenReturn(washerList);

        List<WasherProfile> response = washerController.getAllWashers("John");

        assertNotNull(response);
        assertEquals(1, response.size());
        verify(washerProfileService, times(1)).getWasher("John");
    }

    @Test
    void deleteWasher_shouldCallDeleteById() {
        doNothing().when(washerProfileService).deleteById(anyString());

        washerController.deleteproduct("john@example.com");

        verify(washerProfileService, times(1)).deleteById("john@example.com");
    }
}
