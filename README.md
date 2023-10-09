# Input Domain Modeling

## Function: `ProjectService.findById(final Integer projectId)`

### Testing Goal

The testing goal is to verify that it correctly retrieves a `Project` object from the repository by its project ID and returns it. Additionally, it should ensure that the function throws an `ObjectNotFoundException` when no Project object is found for the provided project ID.

### Information

- Parameters: `Integer projectId`
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

| Test                | projectId | Expected Result | 
|---------------------|-----------|-----------------|
| T1 (1, True, False) | 1         | Found, No Error |

---

## Function: `ProjectService.findByUsernameAndProjectId(final String username, final Integer projectId)`

### Testing Goal

Verify that the function returns a `ProjectCommitInfoDTO` object when a matching record is found in the repository, and throws an `ObjectNotFoundException` when no matching record is found.

### Information

- Parameters: `String username`, `Integer projectId`
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

| Test                       | username           | projectId | Expected Result | 
|----------------------------|--------------------|-----------|-----------------|
| T1 (False, 1, True, False) | "Anders Hejlsberg" | 1         | Found, No Error |

---

## Function: `CredentialService.findById(final Integer credentialId)`

### Testing Goal

The testing goal is to verify that it correctly retrieves a `Credential` object from the repository by its credential ID and returns it. Additionally, it should ensure that the function throws an ObjectNotFoundException when no Credential object is found for the provided credential ID.

### Information

- Parameters: `Integer credentialId`
- Return Type: `Credential`
- Return Value: Object of `Credential` according to the given id.
- Exceptional Behavior: Throws `ObjectNotFoundException` if the project does not exist.

### Interface-Based Characteristics

| Characteristics              | B1               | B2   | B3               |
|------------------------------|------------------|------|------------------|
| Refinement of `credentialId` | Negative integer | Zero | Positive integer |

### Functionality-Based Characteristics

| Characteristics                    | B1   | B2    |
|------------------------------------|------|-------|
| Target `Credential` is found       | True | False |
| Throwing `ObjectNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                    | B1               | B2    | B3               |
|------------------------------------|------------------|-------|------------------|
| Refinement of `credentialId`       | Negative integer | Zero  | Positive integer |
| Target `Credential` is found       | True             | False |                  |
| Throwing `ObjectNotFoundException` | True             | False |                  |

### Blocks Abstraction

| Characteristics | B1  | B2  | B3  |
|-----------------|-----|-----|-----|
| A               | A1  | A2  | A3  |
| B               | B1  | B2  |     |
| C               | C1  | C2  |     |

### Combined Partitions

Using **Multiple Base Choice Combination (MBCC)** approach will have 8 test cases.

Base Choices: `A3, B1, C1` and `A2, B1, C1`

| Base Choices | (A3, B1, C1) | (A2, B1, C1) |
|--------------|--------------|--------------|
| **Change A** | (A1, B1, C1) | (A1, B1, C1) |
| **Change B** | (A3, B2, C1) | (A2, B2, C1) |
| **Change C** | (A3, B1, C2) | (A2, B1, C2) |

### Derived Test Values

| Base Choices | (Positive, True, True)  | (Zero, True, True)     |
|--------------|-------------------------|------------------------|
| **Change A** | (Negative, True, True)  | (Negative, True, True) |
| **Change B** | (Positive, False, True) | (Zero, False, True)    |
| **Change C** | (Positive, True, False) | (Zero, True, False)    |

### Feasible Test Values / Expected Result

| Test                       | credentialId | Expect Result                        |
|----------------------------|--------------|--------------------------------------|
| T1 (Positive, False, True) | 1            | Error, Throw ObjectNotFoundException |
| T2 (Positive, True, False) | 2            | Found, No Error                      |

---

## Function: `CredentialService.findByUsername(final String username)`

### Testing Goal

The testing goal is to verify that it correctly retrieves a `Credential` object from the repository by its username and returns it. Additionally, it should ensure that the function throws an UsernameNotFoundException when no Credential object is found for the provided username.

### Information

- Parameters: `String username`
- Return Type: `Credential`
- Return Value: Object of `Credential` according to the given username.
- Exceptional Behavior: Throws `UsernameNotFoundException` if the project does not exist.

### Interface-Based Characteristics

| Characteristics    | B1   | B2      |
|--------------------|------|---------|
| `username` is null | null | notNull |

### Functionality-Based Characteristics

| Characteristics                      | B1   | B2    |
|--------------------------------------|------|-------|
| Target `Credential` is found         | True | False |
| Throwing `UsernameNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                      | B1   | B2      |
|--------------------------------------|------|---------|
| `username` is null                   | null | notNull |
| Target `Credential` is found         | True | False   |
| Throwing `UsernameNotFoundException` | True | False   |

### Blocks Abstraction

| Characteristics | B1  | B2  |
|-----------------|-----|-----|
| A               | A1  | A2  |
| B               | B1  | B2  |
| C               | C1  | C2  |

### Combined Partitions

Using **Multiple Base Choice Combination (MBCC)** approach will have 6 test cases.

Base Choices: `A2, B1, C1` and `A2, B2, C1`

| Base Choices | (A2, B1, C1) | (A2, B2, C1) |
|--------------|--------------|--------------|
| **Change A** | (A1, B1, C1) | (A1, B2, C1) |
| **Change C** | (A2, B1, C2) | (A2, B2, C2) |

### Derived Test Values

| Base Choices | (notNull, True, True)  | (notNull, False, True)  |
|--------------|------------------------|-------------------------|
| **Change A** | (null, True, True)     | (null, False, True)     |
| **Change C** | (notNull, True, False) | (notNull, False, False) |

### Feasible Test Values / Expected Result

| Test                      | username  | Expect Result                          |
|---------------------------|-----------|----------------------------------------|
| T1 (notNull, True, False) | "johndoe" | Found, No Error                        |
| T2 (notNull, False, True) | "devYok"  | Error, Throw UsernameNotFoundException |

---
