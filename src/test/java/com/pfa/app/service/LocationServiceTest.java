/* Copyright (C) 2023 Thanawat Kanjanapoo, Kaewalin Limpremwattana, Pannavich Thanormvongse,
 * Poomrapee Wareeboutr, Thanakorn Charoenritthitham, Supawit Phimonjit, and Sutthiphon Thankam -All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

package com.pfa.app.service;

import com.pfa.app.exception.custom.ObjectNotFoundException;
import com.pfa.app.model.entity.Location;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class LocationServiceTest {

    @Mock
    private LocationService locationservice;

    /**
     * See README.md - LocationService.deleteById(final Integer locationId)
     * */
    @Nested
    class LocationServiceDeleteByIDTest {
        @Test
        public void testDeleteByNegativeId(){
            // Test case 1: (-1, False)
            int targetID = -1;
            when(locationservice.findById(targetID)).thenThrow(new ObjectNotFoundException());
            assertThrows(ObjectNotFoundException.class, () -> locationservice.findById(targetID));
        }
        @Test
        public void testDeleteByIdZero(){
            // Test case 2: (0, False)
            int targetID = 0;
            when(locationservice.findById(targetID)).thenThrow(new ObjectNotFoundException());
            assertThrows(ObjectNotFoundException.class, () -> locationservice.findById(targetID));
        }
        @Test
        public void testDeleteByExistId() {
            // Test case 3: (1, True)
            Location location = new Location();
            location.setLocationId(1);
            when(locationservice.findById(location.getLocationId())).thenThrow(new ObjectNotFoundException());

            locationservice.deleteById(location.getLocationId());
            assertThrows(ObjectNotFoundException.class, () -> {
                locationservice.findById(location.getLocationId());
            });
        }

        @Test
        public void testDeleteByNotExistId() {
            // Test case 4: (4, False)
            int targetID = 4;
            when(locationservice.findById(targetID)).thenThrow(new ObjectNotFoundException());
            assertThrows(ObjectNotFoundException.class, () -> locationservice.findById(targetID));
        }

    }

    /**
     * See README.md - LocationService.update(final Location location)
     * */
    @Nested
    class LocationServiceUpdateTest {
        @Test
        public void testUpdateWithNullLocation() {
            //Test case 1: (True,False)
            when(locationservice.update(null)).thenThrow(NullPointerException.class);
            assertThrows(NullPointerException.class, () -> locationservice.update(null));
        }

        @Test
        public void testUpdateWithValidLocation() {
            //Test case 2: (Location,Ture)
            Location targetlocation = new Location();
            when(locationservice.update(eq(targetlocation))).thenReturn(targetlocation);
            Location resultofupdate1 = locationservice.update(targetlocation);
            assertThat(resultofupdate1).isEqualTo(targetlocation);
        }

        @Test
        public void testUpdateWithError() {
            //Test case 3: (Location,false)
            // problem with the database connection or query execution
            Location targetlocation2 = new Location();
            when(locationservice.update(eq(targetlocation2))).thenThrow(JpaSystemException.class);
            assertThrows(JpaSystemException.class, () -> locationservice.update(targetlocation2));
        }

    }
}
