# Input Domain Modeling

## Function: `Credential.findById(final Integer credentialId)`

### Testing Goal

The testing goal is to verify that it correctly retrieves a `Credential` object from the repository by its credential ID and returns it. Additionally, it should ensure that the function throws an ObjectNotFoundException when no Credential object is found for the provided credential ID.

### Information

- Parameters: `credentialId`
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

Base Choices:	`A3, B1, C1` and `A2, B1, C1`

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
| T3 (Zero, False, True)     | 0            | Error, Throw ObjectNotFoundException |
| T4 (Zero, True, False)     | 0            | Found, No Error                      |

---

## Function: `Credential.findByUsername(final String username)`

### Testing Goal

The testing goal is to verify that it correctly retrieves a `Credential` object from the repository by its username and returns it. Additionally, it should ensure that the function throws an UsernameNotFoundException when no Credential object is found for the provided username.

### Information

- Parameters: `username`
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

Base Choices:	`A1, B1, C1` and `A2, B1, C1`

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

| Test                   | username | Expect Result                          |
|------------------------|----------|----------------------------------------|
| (notNull, True, False) | johndoe  | Found, No Error                        |
| (notNull, False, True) | devYok   | Error, Throw UsernameNotFoundException |
