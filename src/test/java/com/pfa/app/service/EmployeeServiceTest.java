/* Copyright (C) 2023 Thanawat Kanjanapoo, Kaewalin Limpremwattana, Pannavich Thanormvongse,
 * Poomrapee Wareeboutr, Thanakorn Charoenritthitham, Supawit Phimonjit, and Sutthiphon Thankam -All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

package com.pfa.app.service;

import com.pfa.app.model.entity.Employee;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeService employeeServiceMock;

    /**
     * See README.md - EmployeeService.save(final Employee employee)`
     * */
    @Nested
    class TestSaveEmployee{

        // Test Case 1: (null, throw exception)
        @Test
        public void testNullEmployeeCantSave(){
            when(employeeServiceMock.save(null)).thenThrow(NullPointerException.class);

            assertThrows(NullPointerException.class, () -> {
                employeeServiceMock.save(null);
            });
        }

        // Test case 2: (employee, can saved employee)
        @Test
        public void testEmployeeCanSave(){
            Employee employee = new Employee();

            when(employeeServiceMock.save(employee)).thenReturn(employee);

            assertEquals(employee, employeeServiceMock.save(employee));
    }

        //Test case 3: (employee, can't saved employee, throw exception)
        // problem with the database connection or query execution
        @Test
        public void testEmployeeCantSave(){
            Employee employee = new Employee();
            when(employeeServiceMock.save(employee)).thenThrow(JpaSystemException.class);

            assertThrows(JpaSystemException.class, () -> {
                employeeServiceMock.save(employee);
            });
        }
    }

    /**
     * See README.md - EmployeeService.findByUsername(final String username)`
     * */
    @Nested
    class TestFindByUsername{

        // Test Case 1: ("", Not found, throw except)
        @Test
        public void testFindByEmptyUsername(){
            when(employeeServiceMock.findByUsername("")).thenThrow(UsernameNotFoundException.class);

            assertThrows(UsernameNotFoundException.class, () -> {
                employeeServiceMock.findByUsername("");
            });
        }

        // Test Case 2: ("tianza", Found, return target employee)
        @Test
        public void testFindByUsername(){
            Employee employee = new Employee();

            when(employeeServiceMock.findByUsername("tianza")).thenReturn(employee);

            assertEquals(employee, employeeServiceMock.findByUsername("tianza"));
        }
    }
}
