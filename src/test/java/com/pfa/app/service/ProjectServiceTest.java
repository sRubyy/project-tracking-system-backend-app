/* Copyright (C) 2023 Thanawat Kanjanapoo, Kaewalin Limpremwattana, Pannavich Thanormvongse,
 * Poomrapee Wareeboutr, Thanakorn Charoenritthitham, Supawit Phimonjit, and Sutthiphon Thankam -All Rights Reserved
 * You may use, distribute and modify this code under the terms of the MIT license.
 */

package com.pfa.app.service;

import com.pfa.app.model.dto.ProjectCommitInfoDTO;
import com.pfa.app.model.entity.Project;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    private ProjectService projectService;

    /**
     * See README.md - ProjectService.findById(final Integer projectId)
     * */
    @Nested
    class TestFindById {
        @Test
        public void testFindByValidId() {
            // Test Case 1: (1, True, False)
            Project expectedProject = new Project();
            int projectId = 1;
            when(projectService.findById(eq(projectId))).thenReturn(expectedProject);

            Project resultProject = projectService.findById(projectId);
            assertThat(resultProject).isEqualTo(expectedProject);
        }
    }

    /**
     * See README.md - ProjectService.findByUsernameAndProjectId(final String username, final Integer projectId)
     * */
    @Nested
    class TestFindByUsernameAndProjectId {
        @Test
        public void testFindByValidUsernameAndValidProjectId() {
            // Test Case 1: (False, 1, True, False)
            ProjectCommitInfoDTO expectedProjectCommitInfoDTO = mock(ProjectCommitInfoDTO.class);
            String username = "Anders Hejlsberg";
            int projectId = 1;
            when(projectService.findByUsernameAndProjectId(eq(username), eq(projectId))).thenReturn(expectedProjectCommitInfoDTO);

            ProjectCommitInfoDTO resultProjectCommitInfoDTO = projectService.findByUsernameAndProjectId(username, projectId);
            assertThat(resultProjectCommitInfoDTO).isEqualTo(expectedProjectCommitInfoDTO);
        }
    }
}
