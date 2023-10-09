# Input Domain Modeling

## Function: `ProjectService.findById(final Integer projectId)`

### Testing Goal

The testing goal is to verify that it correctly retrieves a `Project` object from the repository by its project ID and returns it. Additionally, it should ensure that the function throws an `ObjectNotFoundException` when no Project object is found for the provided project ID.

### Information

- Parameters: `Integer`
- Return Type: `Project`
- Return Value: Object of `Project` according to the given id.
- Exceptional Behavior: Throws `ObjectNotFoundException` if the project does not exist.

### Interface-Based Characteristics

| Characteristics           | B1               | B2    | B3               |
|---------------------------|------------------|-------|------------------|
| Refinement of `projectId` | Negative integer | Zero  | Positive integer |

### Functionality-Based Characteristics

| Characteristics                    | B1   | B2    |
|------------------------------------|------|-------|
| Target `Project` is found          | True | False |
| Throwing `ObjectNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                    | B1               | B2    | B3               |
|------------------------------------|------------------|-------|------------------|
| Refinement of `projectId`          | Negative integer | Zero  | Positive integer |
| Target `Project` is found          | True             | False |                  |
| Throwing `ObjectNotFoundException` | True             | False |                  |

### Blocks Abstraction

| Characteristics | B1 | B2 | B3 |
|-----------------|----|----|----|
| A               | A1 | A2 | A3 |
| B               | B1 | B2 |    |
| C               | C1 | C2 |    |

### Combined Partitions

Using **Base Choice (BCC)** approach will have 5 test cases.

Base Choice = (A2, B1, C2)

|          | COL1         | COL2         | COL3         | COL4         | COL5 |
|----------|--------------|--------------|--------------|--------------|------|
| **ROW1** | (A1, B1, C2) | (A3, B1, C2) | (A2, B2, C2) | (A2, B1, C1) |      |

### Derived Test Values

Base Choice = (0, True, False)

|          | COL1              | COL2             | COL3              | COL4            | COL5 |
|----------|-------------------|------------------|-------------------|-----------------|------|
| **ROW1** | (-1, True, False) | (1, True, False) | (0, False, False) | (0, True, True) |      |

### Feasible Test Values / Expected Result

| Test             | Integer | Expected Result | 
|------------------|---------|-----------------|
| (0, True, False) | 0       | Found, No Error |
| (1, True, False) | 1       | Found, No Error |

---

## Function: `ProjectService.findByUsernameAndProjectId(final String username, final Integer projectId)`

### Testing Goal

Verify that the function returns a `ProjectCommitInfoDTO` object when a matching record is found in the repository, and throws an `ObjectNotFoundException` when no matching record is found.

### Information

- Parameters: `String`, `Integer`
- Return Type: `ProjectCommitInfoDTO`
- Return Value: Object of `ProjectCommitInfoDTO` according to the given username and project id.
- Exceptional Behavior: Throws `ObjectNotFoundException` if the matching record is not found.

### Interface-Based Characteristics

| Characteristics           | B1               | B2    | B3               |
|---------------------------|------------------|-------|------------------|
| `username` is empty       | True             | False |                  |
| Refinement of `projectId` | Negative integer | Zero  | Positive integer |

### Functionality-Based Characteristics

| Characteristics                    | B1   | B2    |
|------------------------------------|------|-------|
| Matching `Project` is found        | True | False |
| Throwing `ObjectNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                    | B1               | B2    | B3               |
|------------------------------------|------------------|-------|------------------|
| `username` is empty                | True             | False |                  |
| Refinement of `projectId`          | Negative integer | Zero  | Positive integer |
| Matching `Project` is found        | True             | False |                  |
| Throwing `ObjectNotFoundException` | True             | False |                  |

### Blocks Abstraction

| Characteristics | B1 | B2 | B3 |
|-----------------|----|----|----|
| A               | A1 | A2 |    |
| B               | B1 | B2 | B3 |
| C               | C1 | C2 |    |
| D               | D1 | D2 |    |

### Combined Partitions

Using **Base Choice (BCC)** approach will have 6 test cases.

Base Choice = (A2, B2, C1, D2)

|          | COL1             | COL2             | COL3             | COL4             | COL5             |
|----------|------------------|------------------|------------------|------------------|------------------|
| **ROW1** | (A1, B2, C1, D2) | (A2, B1, C1, D2) | (A2, B3, C1, D2) | (A2, B2, C2, D2) | (A2, B2, C1, D1) |

### Derived Test Values

Base Choice = (False, 0, True, False)

|          | COL1                   | COL2                     | COL3                    | COL4                     | COL5                   |
|----------|------------------------|--------------------------|-------------------------|--------------------------|------------------------|
| **ROW1** | (True, 0, True, False) | (False, -1, True, False) | (False, 1, True, False) | (False, 0, False, False) | (False, 0, True, True) |

### Feasible Test Values / Expected Result

| Test                    | String             | Integer | Expected Result | 
|-------------------------|--------------------|---------|-----------------|
| (False, 0, True, False) | "James Gosling"    | 0       | Found, No Error |
| (False, 1, True, False) | "Anders Hejlsberg" | 1       | Found, No Error |

---