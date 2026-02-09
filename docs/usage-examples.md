# 📖 Usage Examples

## Example 1: Single Student with 3 Subjects

### Input:
```
Student name: Maria Santos
Student ID: 2024001
Number of subjects: 3

Subject 1: Mathematics - Grade: 95
Subject 2: Science - Grade: 88
Subject 3: English - Grade: 92
```

### Output:
```
==================================================
📊 GRADE REPORT
==================================================
Student: Maria Santos (ID: 2024001)
--------------------------------------------------
Mathematics    : 95.0 (A)
Science        : 88.0 (B)
English        : 92.0 (A)
--------------------------------------------------
Average        : 91.67
Letter Grade   : A
GPA (4.0 scale): 4.0
Status         : PASSED ✓
Classification : Excellent
--------------------------------------------------
Highest Grade  : 95.0
Lowest Grade   : 88.0
Passed Subjects: 3/3
==================================================
```

## Example 2: Student with Mixed Grades

### Input:
```
Student name: Pedro Reyes
Student ID: 2024002
Number of subjects: 5

Subject 1: Math - Grade: 75
Subject 2: Science - Grade: 82
Subject 3: English - Grade: 68
Subject 4: History - Grade: 55
Subject 5: PE - Grade: 90
```

### Output:
```
Average: 74.00
Letter Grade: C
Status: PASSED ✓
Classification: Fair
Passed Subjects: 4/5 (History: Failed)
```

## Example 3: Failing Student

### Input:
```
Student name: Ana Cruz
Student ID: 2024003
Number of subjects: 3

Subject 1: Math - Grade: 45
Subject 2: Science - Grade: 52
Subject 3: English - Grade: 58
```

### Output:
```
Average: 51.67
Letter Grade: F
Status: FAILED ✗ (Average below 60)
Classification: Failed
```

## Example 4: Multiple Students Summary

```
==================================================
📊 ALL STUDENTS SUMMARY
==================================================
Name                 | Student ID   | Average | Grade | Status
--------------------------------------------------
Maria Santos         | 2024001      | 91.67   | A     | PASS
Pedro Reyes          | 2024002      | 74.00   | C     | PASS
Ana Cruz             | 2024003      | 51.67   | F     | FAIL
==================================================
Total Students: 3
```
```