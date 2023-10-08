# Input Domain Modeling

## Function: `ProjectService.findById(final Integer projectId)`

### Testing Goal

The testing goal aims for deleted the `Location` from repository by location ID. Furthermore, If the provided location ID is not exit. The Function should throw an `ObjectNotFoundException`.

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

Using **All Combinations (ACoC)** approach will have 12 test cases.

|          | COL1         | COL2         | COL3         | COL4         | COL5         |
|----------|--------------|--------------|--------------|--------------|--------------|
| **ROW1** | (A1, B1, C1) | (A1, B1, C2) | (A1, B2, C1) | (A1, B2, C2) | (A2, B1, C1) |
| **ROW2** | (A2, B1, C2) | (A2, B2, C1) | (A2, B2, C2) | (A3, B1, C1) | (A3, B1, C2) |
| **ROW3** | (A3, B2, C1) | (A3, B2, C2) |              |              |              |

### Derived Test Values

|          | COL1             | COL2              | COL3              | COL4               | COL5             |
|----------|------------------|-------------------|-------------------|--------------------|------------------|
| **ROW1** | (-1, True, True) | (-1, True, False) | (-1, False, True) | (-1, False, False) | (0, True, True)  |
| **ROW2** | (0, True, False) | (0, False, True)  | (0, False, False) | (1, True, True)    | (1, True, False) |
| **ROW3** | (1, False, True) | (1, False, False) |                   |                    |                  |

---

# Input Domain Modeling

## Function: `LocationService.deleteById(final Integer locationId)`

### Testing Goal

The testing goal aims for deleted the `Location` from repository by location ID. Furthermore, If the provided location ID is not exit. The Function should throw an `ObjectNotFoundException`.

### Information

- Parameters: `locationId`
- Return Type: `None`
- Return Value: `None`
- Exceptional Behavior: Throws `ObjectNotFoundException` if the Location does not exist.

### Interface-Based Characteristics

| Characteristics            | B1               | B2    | B3               |
|----------------------------|------------------|-------|------------------|
| Refinement of `locationId` | Negative integer | Zero  | Positive integer |

### Functionality-Based Characteristics

| Characteristics                               | B1   | B2    |
|-----------------------------------------------|------|-------|
| The target `Location` is  delete successfully | True | False |

### Merging Characteristics

| Characteristics                               | B1               | B2    | B3               |
|-----------------------------------------------|------------------|-------|------------------|
| Refinement of `locationId`                    | Negative integer | Zero  | Positive integer |
| The target `Location` is  delete successfully | True             | False |                  |


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

| Test        | Integer | Expected Result                                | 
|-------------|---------|------------------------------------------------|
| (-1, false) | -1      | Can't delete, Throws `ObjectNotFoundException` |
| (0, false)  | 0       | Can't delete, Throws `ObjectNotFoundException` |
| (1, True)   | 1       | Deleted, No Error                              |
| (4, False)  | 4       | Can't delete, Throws `ObjectNotFoundException` |

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

| Characteristics           | B1               | B2    |
|---------------------------|------------------|-------|
| `Location ` is null       | True             | False |

### Functionality-Based Characteristics

| Characteristics                      | B1   | B2    |
|--------------------------------------|------|-------|
| New details of `Location ` has saved | True | False |

### Merging Characteristics

| Characteristics                      | B1   | B2    |
|--------------------------------------|------|-------|
| `Location ` is null                  | True | False |
| New details of `Location ` has saved | True | False |

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

| Test           | Location | Expected Result   | 
|----------------|----------|-------------------|
| (True, False)  | null     | Not update, Error |
| (False, True)  | Location | Updated, No Error |
| (False, False) | Location | Not update, Error |

---