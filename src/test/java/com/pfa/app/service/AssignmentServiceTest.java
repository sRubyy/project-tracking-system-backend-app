/* Copyright (C) 2023 Thanawat Kanjanapoo, Kaewalin Limpremwattana, Pannavich Thanormvongse,
* Poomrapee Wareeboutr, Thanakorn Charoenritthitham, Supawit Phimonjit, and Sutthiphon Thankam -All Rights Reserved
* You may use, distribute and modify this code under the terms of the MIT license.
*/

package com.pfa.app.service;

import com.pfa.app.model.dto.ProjectCommit;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AssignmentServiceTest {

    @Mock
    private AssignmentService assignmentServiceMock;

    /**
     * See README.md - AssignmentService.findByEmployeeIdAndProjectId(final Integer employeeId, final Integer projectId)`
     * */
    @Nested
    class TestFindByEmployeeIdAndProjectId{

        // Test Case 1: (1, 1, Target project commit)
        @Test
        public void testValidEmployeeIdAndValidProjectId(){
            ProjectCommit projectCommit1 = mock(ProjectCommit.class);
            ProjectCommit projectCommit2 = mock(ProjectCommit.class);
            List<ProjectCommit> projectCommitList = new ArrayList<>(
                    Arrays.asList(projectCommit1, projectCommit2)
            );

            when(assignmentServiceMock.findByEmployeeIdAndProjectId(1, 1)).thenReturn(projectCommitList);

            assertIterableEquals(projectCommitList, assignmentServiceMock.findByEmployeeIdAndProjectId(1, 1));
        }

        // Test Case 2: (0, 0, {} Empty list)
        @Test
        public void testZeroEmployeeIdAndZeroProjectId(){
            List<ProjectCommit> emptyProjectCommitList = new ArrayList<>();

            when(assignmentServiceMock.findByEmployeeIdAndProjectId(0, 0)).thenReturn(emptyProjectCommitList);

            assertIterableEquals(emptyProjectCommitList, assignmentServiceMock.findByEmployeeIdAndProjectId(0, 0));
        }

        // Test Case 3: (-1, -1, {} Empty list)
        @Test
        public void testNegativeEmployeeIdAndNegativeProjectId(){
            List<ProjectCommit> emptyProjectCommitList = new ArrayList<>();

            when(assignmentServiceMock.findByEmployeeIdAndProjectId(-1, -1)).thenReturn(emptyProjectCommitList);

            assertIterableEquals(emptyProjectCommitList, assignmentServiceMock.findByEmployeeIdAndProjectId(-1, -1));
        }
    }

}
