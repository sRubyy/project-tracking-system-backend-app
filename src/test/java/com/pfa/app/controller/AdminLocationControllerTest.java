/* Copyright (C) 2023 Thanawat Kanjanapoo, Kaewalin Limpremwattana, Pannavich Thanormvongse,
 * Poomrapee Wareeboutr, Thanakorn Charoenritthitham, Supawit Phimonjit, and Sutthiphon Thankam -All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

package com.pfa.app.controller;

import com.pfa.app.exception.custom.ObjectNotFoundException;
import com.pfa.app.model.entity.Location;
import com.pfa.app.service.LocationService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminLocationControllerTest {

    @Mock
    private LocationService locationServiceMock;

    @Autowired
    private LocationService locationService;

    @Autowired
    private MockMvc mockMvc;

    /**
     * See README.md - AdminLocationController.displayAdminLocationsEdit(@RequestParam("locationId") final String locationId, final Model model)`
     * */
    @Nested
    class TestDisplayAdminLocationsEdit{

        // Test case 1: ("", Not found, Throw exception)
        @Test
        @WithMockUser(username = "admin", roles = "ADMIN")
        public void testEmptyLocationIdCantResponse() throws Exception {
            assertThrows(NumberFormatException.class, () ->{
                locationService.findById(Integer.parseInt(""));
            });

            mockMvc.perform(MockMvcRequestBuilders.get("/admins/locations/admin-locations-edit")
                            .param("locationId", ""))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andReturn();
        }

        // Test case 2: ("1", Found, get response of target locationId)
        @Test
        @WithMockUser(username = "admin", roles = "ADMIN")
        public void testLocationIdCanResponse() throws Exception {
            Location location = new Location();

            when(locationServiceMock.findById(Integer.parseInt("1"))).thenReturn(location);

            assertEquals(location, locationServiceMock.findById(1));

            mockMvc.perform(MockMvcRequestBuilders.get("/admins/locations/admin-locations-edit")
                            .param("locationId", "1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.view().name("admins/locations/admin-locations-edit"))
                    .andExpect(MockMvcResultMatchers.model().attributeExists("location"))
                    .andReturn();
        }

        // Test case 3: ("3", Not found, Throw exception)
        @Test
        @WithMockUser(username = "admin", roles = "ADMIN")
        public void testLocationIdCantResponseNotFound() throws Exception {
            when(locationServiceMock.findById(Integer.parseInt("3"))).thenThrow(ObjectNotFoundException.class);

            assertThrows(ObjectNotFoundException.class, () ->{
                locationServiceMock.findById(Integer.parseInt("3"));
            });

            mockMvc.perform(MockMvcRequestBuilders.get("/admins/locations/admin-locations-edit")
                            .param("locationId", "3"))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andReturn();
        }
    }

}
