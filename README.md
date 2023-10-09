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

| Characteristics               | B1               | B2    | B3               |
|-------------------------------|------------------|-------|------------------|
| C1: Refinement of `projectId` | Negative integer | Zero  | Positive integer |

### Functionality-Based Characteristics

| Characteristics                        | B1   | B2    |
|----------------------------------------|------|-------|
| C2: Target `Project` is found          | True | False |
| C3: Throwing `ObjectNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                        | B1               | B2    | B3               |
|----------------------------------------|------------------|-------|------------------|
| C1: Refinement of `projectId`          | Negative integer | Zero  | Positive integer |
| C2: Target `Project` is found          | True             | False |                  |
| C3: Throwing `ObjectNotFoundException` | True             | False |                  |

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

| Characteristics               | B1               | B2    | B3               |
|-------------------------------|------------------|-------|------------------|
| C1: `username` is empty       | True             | False |                  |
| C2: Refinement of `projectId` | Negative integer | Zero  | Positive integer |

### Functionality-Based Characteristics

| Characteristics                        | B1   | B2    |
|----------------------------------------|------|-------|
| C3: Matching `Project` is found        | True | False |
| C4: Throwing `ObjectNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                        | B1               | B2    | B3               |
|----------------------------------------|------------------|-------|------------------|
| C1: `username` is empty                | True             | False |                  |
| C2: Refinement of `projectId`          | Negative integer | Zero  | Positive integer |
| C3: Matching `Project` is found        | True             | False |                  |
| C4: Throwing `ObjectNotFoundException` | True             | False |                  |

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

| Characteristics                  | B1               | B2   | B3               |
|----------------------------------|------------------|------|------------------|
| C1: Refinement of `credentialId` | Negative integer | Zero | Positive integer |

### Functionality-Based Characteristics

| Characteristics                        | B1   | B2    |
|----------------------------------------|------|-------|
| C2: Target `Credential` is found       | True | False |
| C3: Throwing `ObjectNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                        | B1               | B2    | B3               |
|----------------------------------------|------------------|-------|------------------|
| C1: Refinement of `credentialId`       | Negative integer | Zero  | Positive integer |
| C2: Target `Credential` is found       | True             | False |                  |
| C3: Throwing `ObjectNotFoundException` | True             | False |                  |

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

| Base Choices | (1, True, True)  | (0, True, True)  |
|--------------|------------------|------------------|
| **Change A** | (-1, True, True) | (-1, True, True) |
| **Change B** | (1, False, True) | (0, False, True) |
| **Change C** | (2, True, False) | (0, True, False) |

### Feasible Test Values / Expected Result

| Test                | credentialId | Expect Result                        |
|---------------------|--------------|--------------------------------------|
| T1 (0, False, True) | 0            | Error, Throw ObjectNotFoundException |
| T2 (1, False, True) | 1            | Error, Throw ObjectNotFoundException |
| T3 (2, True, False) | 2            | Found, No Error                      |

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

| Characteristics         | B1   | B2    |
|-------------------------|------|-------|
| C1: `username` is empty | True | False |

### Functionality-Based Characteristics

| Characteristics                          | B1   | B2    |
|------------------------------------------|------|-------|
| C2: Target `Credential` is found         | True | False |
| C3: Throwing `UsernameNotFoundException` | True | False |

### Merging Characteristics

| Characteristics                          | B1   | B2    |
|------------------------------------------|------|-------|
| C1: `username` is empty                  | True | False |
| C2: Target `Credential` is found         | True | False |
| C3: Throwing `UsernameNotFoundException` | True | False |

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

| Base Choices | (False, True, True)  | (False, False, True)  |
|--------------|----------------------|-----------------------|
| **Change A** | (True, True, True)   | (True, False, True)   |
| **Change C** | (False, True, False) | (False, False, False) |

### Feasible Test Values / Expected Result

| Test                    | username  | Expect Result                          |
|-------------------------|-----------|----------------------------------------|
| T1 (False, True, False) | "johndoe" | Found, No Error                        |
| T2 (False, False, True) | "devYok"  | Error, Throw UsernameNotFoundException |
| T3 (True, False, True)  | ""        | Error, Throw UsernameNotFoundException |

---

## Function: `AssignmentService.findByEmployeeIdAndProjectId(final Integer employeeId, final Integer projectId)`

### Testing Goal

The testing goal is to verify that it correctly retrieves a `List<ProjectCommit>` from the repository by employeeId, projectId. It will return project commit if both of id are match to the existing id in the database, else it will return {} empty list.

### Information

- Parameters: `final Integer employeeId`, `final Integer projectId`
- Return Type: `List<ProjectCommit>`
- Return Value: The list of `List<ProjectCommit>` according to the given `employeeId` and `projectId`.
- Exceptional Behavior: -

### Interface-Based Characteristics

| Characteristics                | B1               | B2   | B3               |
|--------------------------------|------------------|------|------------------|
| C1: Refinement of `employeeId` | Negative integer | Zero | Positive integer |
| C2: Refinement of `projectId`  | Negative integer | Zero | Positive integer |

### Functionality-Based Characteristics

| Characteristics             | B1   | B2    |
|-----------------------------|------|-------|
| C3: Project commit is found | True | False |

### Merging Characteristics

| Characteristics                | B1               | B2    | B3               |
|--------------------------------|------------------|-------|------------------|
| C1: Refinement of `employeeId` | Negative integer | Zero  | Positive integer |
| C2: Refinement of `projectId`  | Negative integer | Zero  | Positive integer |
| C3: Project commit is found    | True             | False |                  |

### Blocks Abstraction

| Characteristics | B1 | B2 | B3 |
|-----------------|----|----|----|
| A               | A1 | A2 | A3 |
| B               | B1 | B2 | B3 |
| C               | C1 | C2 |    |

### Combined Partitions

Using **Each Choice (ECC)** approach will have 3 test cases.

(A1, B1, C1)

(A2, B2, C2)

(A3, B3, C2) || (A3, B3, C1)

|          | COL1         | COL2         | COL3         |
|----------|--------------|--------------|--------------|
| **ROW1** | (A1, B1, C1) | (A2, B2, C1) | (A3, B3, C2) |

### Derived Test Values

|          | COL1         | COL2          | COL3            |
|----------|--------------|---------------|-----------------|
| **ROW1** | (1, 1, True) | (0, 0, False) | (-1, -1, False) |

### Feasible Test Values / Expected Result

| Test               | employeeId | projectId | Expected Result       | 
|--------------------|------------|-----------|-----------------------|
| T1 (1, 1, True)    | 1          | 1         | Target project commit |
| T2 (0, 0, False)   | 0          | 0         | {} Empty list         |
| T3 (-1, -1, False) | -1         | -1        | {} Empty list         |

---

## Function: `EmployeeService.findByUsername(final String username)`

### Testing Goal

Verify that the function returns the `Employee` class when a matching username is found in the repository. If it not found, it will return empty.

### Information

- Parameters: `final String username`
- Return Type: `Employee`
- Return Value: The target employee of `Employee class` according to the given username.
- Exceptional Behavior: -

### Interface-Based Characteristics

| Characteristics           | B1               | B2    |
|---------------------------|------------------|-------|
| C1: `username` is empty   | True             | False |

### Functionality-Based Characteristics

| Characteristics         | B1   | B2    |
|-------------------------|------|-------|
| C2: `username` is found | True | False |

### Merging Characteristics

| Characteristics         | B1   | B2    |
|-------------------------|------|-------|
| C1: `username` is empty | True | False |
| C2: `username` is found | True | False |

### Blocks Abstraction

| Characteristics | B1 | B2 |
|-----------------|----|----|
| A               | A1 | A2 |
| B               | B1 | B2 |

### Combined Partitions

Using **Each Choice (ECC)** approach will have 2 test cases.

(A1, B2)

(A2, B1) || (A2, B2)

|          | COL1     | COL2     |
|----------|----------|----------|
| **ROW1** | (A1, B2) | (A2, B1) |

### Derived Test Values

|          | COL1          | COL2          |
|----------|---------------|---------------|
| **ROW1** | (True, False) | (False, True) |

### Feasible Test Values / Expected Result

| Test             | username | Expected Result               | 
|------------------|----------|-------------------------------|
| T1 (True, False) | ""       | Not found, throw except       |
| T2 (False, True) | "tianza" | Found, return target employee |

---

## Function: `EmployeeService.save(final Employee employee)`

### Testing Goal

The testing goal is to verify that it correctly save a `Employee` by given the employee parameter, if employee is null, then it can't save.

### Information

- Parameters: `final Employee employee`
- Return Type: `Employee`
- Return Value: The saved employee
- Exceptional Behavior: -

### Interface-Based Characteristics

| Characteristics        | B1   | B2    |
|------------------------|------|-------|
| C1: `Employee` is null | True | False |

### Functionality-Based Characteristics

| Characteristics                     | B1   | B2    |
|-------------------------------------|------|-------|
| C2: `Employee` can save in database | True | False |

### Merging Characteristics

| Characteristics                     | B1   | B2    |
|-------------------------------------|------|-------|
| C1: `Employee` is null              | True | False |
| C2: `Employee` can save in database | True | False |

### Blocks Abstraction

| Characteristics | B1 | B2 |
|-----------------|----|----|
| A               | A1 | A2 |
| B               | B1 | B2 |

### Combined Partitions

Using **Pair Wise (PWC)** approach will have 4 test cases.

(A1, B1) --> Infeasible, can't save employee with null `Employee`

(A1, B2)

(A2, B1)

(A2, B2)

|          | COL1     | COL2     | COL3     | COL4     |
|----------|----------|----------|----------|----------|
| **ROW1** | (A1, B1) | (A1, B2) | (A2, B1) | (A2, B2) |

### Derived Test Values

|          | COL1         | COL2          | COL3          | COL4           |
|----------|--------------|---------------|---------------|----------------|
| **ROW1** | (True, True) | (True, False) | (False, True) | (False, False) |

### Feasible Test Values / Expected Result

| Test              | Employee | Expected Result                                                                                                     | 
|-------------------|----------|---------------------------------------------------------------------------------------------------------------------|
| T1 (True, False)  | null     | can't saved employee, throw exception                                                                               |
| T2 (False, True)  | employee | can saved employee                                                                                                  |
| T3 (False, False) | employee | can't saved employee, throw exception (this case might happened, when there is the issue of connection in database) |

---

## Function: `AdminLocationController.displayAdminLocationsEdit(@RequestParam("locationId") final String locationId, final Model model)`

### Testing Goal

The testing aims to verify whether the controller works as intended by specifying `locationId` and it should find the location by that identifier then return the location binding on the view or template. If the location is not found or the location is empty, it should throw an exception instead.

### Information

- Parameters: `final String locationId`, `final Model model`
- Return Type: `String`
- Return Value: name of view rendered as a response
- Exceptional Behavior: -

### Interface-Based Characteristics

| Characteristics           | B1   | B2    |
|---------------------------|------|-------|
| C1: `locationId` is empty | True | False |

### Functionality-Based Characteristics

| Characteristics                        | B1   | B2    |
|----------------------------------------|------|-------|
| C2: retrieved location from identifier | True | False |

### Merging Characteristics

| Characteristics                        | B1   | B2    |
|----------------------------------------|------|-------|
| C1: `locationId` is empty              | True | False |
| C2: retrieved location from identifier | True | False |

### Blocks Abstraction

| Characteristics | B1 | B2 |
|-----------------|----|----|
| A               | A1 | A2 |
| B               | B1 | B2 |

### Combined Partitions

Using **Pair Wise (PWC)** approach will have 4 test cases.

(A1, B1) --> Infeasible, can't retrieve location from identifier with null `locationId`

(A1, B2)	

(A2, B1)	

(A2, B2)

|          | COL1     | COL2     | COL3     | COL4     |
|----------|----------|----------|----------|----------|
| **ROW1** | (A1, B1) | (A1, B2) | (A2, B1) | (A2, B2) |

### Derived Test Values

|          | COL1         | COL2          | COL3          | COL4           |
|----------|--------------|---------------|---------------|----------------|
| **ROW1** | (True, True) | (True, False) | (False, True) | (False, False) |

### Feasible Test Values / Expected Result

| Test              | locationId | Expected Result                          | 
|-------------------|------------|------------------------------------------|
| T1 (True, False)  | ""         | Not found, Throw exception               |
| T2 (False, True)  | "1"        | Found, get response of target locationId |
| T3 (False, False) | "3"        | Not found, Throw exception               |

---

## Function: `LocationService.deleteById(final Integer locationId)`

### Testing Goal

The testing goal aims for deleted the `Location` from repository by location ID. Furthermore, If the provided location ID is not exit. The Function should throw an `ObjectNotFoundException`.

### Information

- Parameters: `locationId`
- Return Type: `None`
- Return Value: `None`.
- Exceptional Behavior: Throws `ObjectNotFoundException` if the Location does not exist.

### Interface-Based Characteristics

| Characteristics                | B1               | B2    | B3               |
|--------------------------------|------------------|-------|------------------|
| C1: Refinement of `locationId` | Negative integer | Zero  | Positive integer |

### Functionality-Based Characteristics

| Characteristics                                   | B1   | B2    |
|---------------------------------------------------|------|-------|
| C2: The target `Location` is  delete successfully | True | False |

### Merging Characteristics

| Characteristics                                   | B1               | B2    | B3               |
|---------------------------------------------------|------------------|-------|------------------|
| C1: Refinement of `locationId`                    | Negative integer | Zero  | Positive integer |
| C2: The target `Location` is  delete successfully | True             | False |                  |


### Blocks Abstraction

| Characteristics | B1 | B2 | B3 |
|-----------------|----|----|----|
| A               | A1 | A2 | A3 |
| B               | B1 | B2 |    |

### Combined Partitions

Using **All Combinations (ACoC)** approach will have 6 test cases.

|          | COL1     | COL2     |
|----------|----------|----------|
| **ROW1** | (A1, B1) | (A1, B2) |
| **ROW2** | (A2, B1) | (A2, B2) |
| **ROW3** | (A3, B1) | (A3, B2) |

### Derived Test Values

|          | COL1       | COL2        |
|----------|------------|-------------|
| **ROW1** | (-1, True) | (-1, False) |
| **ROW2** | (0, True)  | (0, False)  |
| **ROW3** | (1, True)  | (4, False)  |

### Feasible Test Values / Expected Result

| Test           | Integer | Expected Result                                | 
|----------------|---------|------------------------------------------------|
| T1 (-1, False) | -1      | Can't delete, Throws `ObjectNotFoundException` |
| T2 (0, False)  | 0       | Can't delete, Throws `ObjectNotFoundException` |
| T3 (1, True)   | 1       | Deleted, No Error                              |
| T4 (4, False)  | 4       | Can't delete, Throws `ObjectNotFoundException` |

---

## Function: `LocationService.update(final Location location)`

### Testing Goal

Ensure that function must returns the `Location` with new details when provided a exit Location object. Vice versa, it will throw an ObjectNotFoundException

### Information

- Parameters: `location`
- Return Type: `Location`
- Return Value: The specific `Location` that has updated some details.
- Exceptional Behavior: Throws `ObjectNotFoundException` if the target location isn't exit.

### Interface-Based Characteristics

| Characteristics        | B1               | B2    |
|------------------------|------------------|-------|
| C1: `Location` is null | True             | False |

### Functionality-Based Characteristics

| Characteristics                         | B1   | B2    |
|-----------------------------------------|------|-------|
| C2: New details of `Location` has saved | True | False |

### Merging Characteristics

| Characteristics                         | B1   | B2    |
|-----------------------------------------|------|-------|
| C1: `Location` is null                  | True | False |
| C2: New details of `Location` has saved | True | False |

### Blocks Abstraction

| Characteristics | B1 | B2 |
|-----------------|----|----|
| A               | A1 | A2 |
| B               | B1 | B2 |

### Combined Partitions

Using **All Combinations (ACoC)** approach will have 4 test cases.

|          | COL1     | COL2     |
|----------|----------|----------|
| **ROW1** | (A1, B1) | (A1, B2) |
| **ROW2** | (A2, B1) | (A2, B2) |

### Derived Test Values

|          | COL1          | COL2           |
|----------|---------------|----------------|
| **ROW1** | (True, True)  | (True, False)  |
| **ROW2** | (False, True) | (False, False) |

### Feasible Test Values / Expected Result

| Test              | Location | Expected Result   | 
|-------------------|----------|-------------------|
| T1 (True, False)  | null     | Not update, Error |
| T2 (False, True)  | Location | Updated, No Error |
| T3 (False, False) | Location | Not update, Error |

---