Spring Boot JPA Entity Relationships

This project demonstrates One-to-One, One-to-Many, and Many-to-Many relationships using Spring Boot, Hibernate, and PostgreSQL.

1. Technologies Used

Java 17+

Spring Boot 3+

Spring Data JPA

Hibernate

PostgreSQL

2. One-to-One Relationship

Entities:

User

Profile

Explanation:

Each User has one Profile.

User owns the relationship via @JoinColumn.

cascade = CascadeType.ALL ensures that when a User is saved or deleted, the associated Profile is also saved or deleted.

Key Annotations:

@OneToOne

@JoinColumn

cascade = CascadeType.ALL

Database Mapping:

users table has a foreign key profile_id referencing profiles(id).

3. One-to-Many / Many-to-One Relationship

Entities:

Department

Employee

Explanation:

A Department can have many Employees.

Each Employee belongs to exactly one Department.

Employee owns the relationship (foreign key department_id).

Department uses mappedBy to indicate inverse side.

cascade = CascadeType.ALL ensures that when a Department is saved or deleted, all its Employees are also saved or deleted.

Key Annotations:

@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)

@ManyToOne

@JoinColumn(name = "department_id")

Database Mapping:

employees table has foreign key department_id referencing departments(id).

4. Many-to-Many Relationship

Entities:

Student

Course

Explanation:

A Student can enroll in many Courses.

A Course can have many Students.

A join table student_courses stores the relationships.

Student owns the relationship and defines @JoinTable.

Course uses mappedBy to indicate inverse side.

Key Annotations:

@ManyToMany

@JoinTable with joinColumns and inverseJoinColumns

mappedBy

Database Mapping:

student_courses join table stores pairs of student_id and course_id.

5. Cascade Types

PERSIST → save child when parent is saved

MERGE → update child when parent is updated

REMOVE → delete child when parent is deleted

ALL → includes all above
