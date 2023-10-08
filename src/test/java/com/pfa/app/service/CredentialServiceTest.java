package com.pfa.app.service;

import com.pfa.app.exception.custom.ObjectNotFoundException;
import com.pfa.app.model.entity.Credential;
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
    @Test
    public void testFindById() {
        // Test Case 1: (1, False, True)
        int credentialId1 = 1;
        when(credentialService.findById(eq(credentialId1))).thenThrow(new ObjectNotFoundException());

        assertThrows(ObjectNotFoundException.class, () -> credentialService.findById(credentialId1));

        // Test Case 2: (2, True, False)
        Credential expectedCredential1 = new Credential();
        int credentialId2 = 2;
        when(credentialService.findById(eq(credentialId2))).thenReturn(expectedCredential1);

        Credential resultCredential1 = credentialService.findById(credentialId2);
        assertThat(resultCredential1).isEqualTo(expectedCredential1);
    }

    /**
     * See README.md - CredentialService.findByUsername(final String username)`
     * */
    @Test
    public void testFindByUsername() {

        // Test Case 1: ("johndoe", True, False)
        Credential expectedCredential1 = new Credential();
        String username1 = "johndoe";
        when(credentialService.findByUsername(eq(username1))).thenReturn(expectedCredential1);

        Credential resultCredential1 = credentialService.findByUsername(username1);
        assertThat(resultCredential1).isEqualTo(expectedCredential1);

        // Test Case 2: ("devYok", False, True)
        String username2 = "devYok";
        when(credentialService.findByUsername(eq(username2))).thenThrow(new UsernameNotFoundException("###### NO Credential object FOUND with username: " + username2 + " ! ######"));

        assertThrows(UsernameNotFoundException.class, () -> credentialService.findByUsername(username2));
    }
}
