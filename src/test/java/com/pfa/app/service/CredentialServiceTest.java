/* Copyright (C) 2023 Thanawat Kanjanapoo, Kaewalin Limpremwattana, Pannavich Thanormvongse,
 * Poomrapee Wareeboutr, Thanakorn Charoenritthitham, Supawit Phimonjit, and Sutthiphon Thankam -All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

package com.pfa.app.service;

import com.pfa.app.exception.custom.ObjectNotFoundException;
import com.pfa.app.model.entity.Credential;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CredentialServiceTest {

    @Mock
    private CredentialService credentialService;

    /**
     * See README.md - CredentialService.findById(final Integer credentialId)
     * */
    @Nested
    class TestFindById{
        @Test
        public void testFindByZeroId() {
            // Test Case 1: (0, False, True)
            int credentialId0 = 0;
            when(credentialService.findById(eq(credentialId0))).thenThrow(new ObjectNotFoundException());

            assertThrows(ObjectNotFoundException.class, () -> credentialService.findById(credentialId0));
        }
        @Test
        public void testFindByInvalidId() {
            // Test Case 2: (1, False, True)
            int credentialId1 = 1;
            when(credentialService.findById(eq(credentialId1))).thenThrow(new ObjectNotFoundException());

            assertThrows(ObjectNotFoundException.class, () -> credentialService.findById(credentialId1));
        }
        @Test
        public void testFindByValidId(){
            // Test Case 3: (2, True, False)
            Credential expectedCredential1 = new Credential();
            int credentialId2 = 2;
            when(credentialService.findById(eq(credentialId2))).thenReturn(expectedCredential1);

            Credential resultCredential1 = credentialService.findById(credentialId2);
            assertThat(resultCredential1).isEqualTo(expectedCredential1);
        }
    }

    /**
     * See README.md - CredentialService.findByUsername(final String username)`
     * */
    @Nested
    class TestFindByUsername{
        @Test
        public void testFindByValidUsername() {
            // Test Case 1: ("johndoe", True, False)
            Credential expectedCredential1 = new Credential();
            String username1 = "johndoe";
            when(credentialService.findByUsername(eq(username1))).thenReturn(expectedCredential1);

            Credential resultCredential1 = credentialService.findByUsername(username1);
            assertThat(resultCredential1).isEqualTo(expectedCredential1);
        }
        @Test
        public void testFindByInvalidUsername() {
            // Test Case 2: ("devYok", False, True)
            String username2 = "devYok";
            when(credentialService.findByUsername(eq(username2))).thenThrow(new UsernameNotFoundException("###### NO Credential object FOUND with username: " + username2 + " ! ######"));

            assertThrows(UsernameNotFoundException.class, () -> credentialService.findByUsername(username2));
        }
        @Test
        public void testFindByEmptyUsername() {
            // Test Case 3: ("", False, True)
            String username3 = "";
            when(credentialService.findByUsername(eq(username3))).thenThrow(new UsernameNotFoundException("###### NO Credential object FOUND with username: " + username3 + " ! ######"));

            assertThrows(UsernameNotFoundException.class, () -> credentialService.findByUsername(username3));
        }
    }
}
