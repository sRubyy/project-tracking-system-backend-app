package com.pfa.app;

import com.pfa.app.model.dto.ProjectCommitInfoDTO;
import com.pfa.app.model.entity.Project;
import com.pfa.app.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    private ProjectService projectService;

    /**
     * See README.md - ProjectService.findById(final Integer projectId)
     * */
    @Test
    public void testFindById() {
        // Test Case 1: (0, True, False)
        Project expectedProject1 = new Project();
        int projectId1 = 0;
        when(projectService.findById(eq(projectId1))).thenReturn(expectedProject1);

        Project resultProject1 = projectService.findById(projectId1);
        assertThat(resultProject1).isEqualTo(expectedProject1);

        // Test Case 2: (1, True, False)
        Project expectedProject2 = new Project();
        int projectId2 = 1;
        when(projectService.findById(eq(projectId2))).thenReturn(expectedProject2);

        Project resultProject2 = projectService.findById(projectId2);
        assertThat(resultProject2).isEqualTo(expectedProject2);
    }

    /**
     * See README.md - ProjectService.findByUsernameAndProjectId(final String username, final Integer projectId)
     * */
    @Test
    public void testFindByUsernameAndProjectId() {
        // Test Case 1: (False, 0, True, False)
        ProjectCommitInfoDTO expectedProjectCommitInfoDTO1 = mock(ProjectCommitInfoDTO.class);
        String username1 = "James Gosling";
        int projectId1 = 0;
        when(projectService.findByUsernameAndProjectId(eq(username1), eq(projectId1))).thenReturn(expectedProjectCommitInfoDTO1);

        ProjectCommitInfoDTO resultProjectCommitInfoDTO1 = projectService.findByUsernameAndProjectId(username1, projectId1);
        assertThat(resultProjectCommitInfoDTO1).isEqualTo(expectedProjectCommitInfoDTO1);

        // Test Case 2: (False, 1, True, False)
        ProjectCommitInfoDTO expectedProjectCommitInfoDTO2 = mock(ProjectCommitInfoDTO.class);
        String username2 = "Anders Hejlsberg";
        int projectId2 = 1;
        when(projectService.findByUsernameAndProjectId(eq(username2), eq(projectId2))).thenReturn(expectedProjectCommitInfoDTO2);

        ProjectCommitInfoDTO resultProjectCommitInfoDTO2 = projectService.findByUsernameAndProjectId(username2, projectId2);
        assertThat(resultProjectCommitInfoDTO2).isEqualTo(expectedProjectCommitInfoDTO2);
    }
}
