CREATE TABLE `administrators`  (
  `username` varchar(32) NULL,
  `password` varchar(64) NOT NULL
);

CREATE TABLE `courseInfo`  (
  `courseId` bigint NOT NULL AUTO_INCREMENT,
  `courseName` varchar(64) NULL,
  `teacherId` bigint NOT NULL,
  `teacherName` varchar(64) NULL,
  `introduction` varchar(512) NULL,
  `academicCredit` int NULL,
  PRIMARY KEY (`courseId`, `teacherId`)
);

CREATE TABLE `postgradeStudent`  (
  `teacherId` int NULL,
  `teacherName` varchar(32) NULL,
  `directions` varchar(255) NULL,
  PRIMARY KEY (`teacherId`)
);

CREATE TABLE `studentCourse`  (
  `courseId` bigint NOT NULL,
  `studentId` bigint NOT NULL,
  `score` decimal(10, 2) UNSIGNED NULL,
  PRIMARY KEY (`courseId`, `studentId`)
);

CREATE TABLE `students`  (
  `studentId` bigint NOT NULL,
  `studentName` varchar(32) NULL,
  `gender` varchar(4) NULL,
  `birth` date NULL,
  `grade` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `major` varchar(255) NULL,
  `password` varchar(64) NULL,
  `type` varchar(32) NULL,
  `tutor` varchar(255) NULL,
  `searchDirection` varchar(255) NULL,
  `rankClass` varchar(255) NULL,
  `headTeacher` varchar(255) NULL,
  PRIMARY KEY (`studentId`)
);

CREATE TABLE `teachers`  (
  `teacherId` bigint NOT NULL,
  `teacherName` varchar(32) NULL,
  `password` varchar(64) NULL,
  PRIMARY KEY (`teacherId`)
);

CREATE TABLE `undergraduateStudent`  (
  `teacherId` bigint NULL,
  `teacherName` varchar(32) NULL,
  `class` varchar(32) NULL
);

