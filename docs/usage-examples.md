# 📖 Usage Examples

## Console Version Examples

### Example 1: Single Student with 3 Subjects

#### Input:
```
Student name: Maria Santos
Student ID: 2024001
Number of subjects: 3

Subject 1: Mathematics - Grade: 95
Subject 2: Science - Grade: 88
Subject 3: English - Grade: 92
```

#### Output:
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

### Example 2: Student with Mixed Grades

#### Input:
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

#### Output:
```
Average: 74.00
Letter Grade: C
Status: PASSED ✓
Classification: Fair
Passed Subjects: 4/5 (History: Failed)
```

### Example 3: Failing Student

#### Input:
```
Student name: Ana Cruz
Student ID: 2024003
Number of subjects: 3

Subject 1: Math - Grade: 45
Subject 2: Science - Grade: 52
Subject 3: English - Grade: 58
```

#### Output:
```
Average: 51.67
Letter Grade: F
Status: FAILED ✗ (Average below 60)
Classification: Failed
```

## GUI Version Examples

### Adding a Student

1. Click **"➕ Add Student"** button
2. Fill in:
   - **Name**: Juan Dela Cruz
   - **Student ID**: 2024001
   - **Number of Subjects**: 3
3. For each subject, enter:
   - **Subject 1**: Math, Grade: 95
   - **Subject 2**: Science, Grade: 88
   - **Subject 3**: English, Grade: 92
4. Click **"💾 Save"**
5. Student appears in the table!

### Viewing a Report

1. **Click on any student** in the table
2. The **Grade Report panel** automatically updates
3. Shows:
   - Student name and ID
   - All subjects with grades
   - Average, letter grade, GPA
   - Pass/Fail status
   - Statistics (highest, lowest, passed subjects)

### Deleting a Student

1. **Select a student** in the table
2. Click **"🗑️ Delete Student"** button
3. Confirm the deletion
4. Student is removed!

## Multiple Students Summary

When viewing all students (Console) or the table (GUI):

```
==================================================
📊 ALL STUDENTS SUMMARY
==================================================
Name                 | Student ID   | Average | Grade | Status
--------------------------------------------------
Maria Santos         | 2024001      | 91.67   | A     | PASS
Pedro Reyes          | 2024002      | 74.00   | C     | PASS
Ana Cruz             | 2024003      | 51.67   | F     | FAIL
Juan Dela Cruz       | 2024004      | 85.50   | B     | PASS
==================================================
Total Students: 4
```

## Tips

### Console Version
- Use **option 2** to see all students at a glance
- Use **option 3** for detailed individual reports
- Press **5** to exit cleanly

### GUI Version
- Use **Ctrl+Click** for quick selection
- The **refresh button** reloads the table
- Click **About** for app information
- Window is **resizable** for better viewing

---

**Happy Grading! 📚✨**
```