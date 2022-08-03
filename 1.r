n <- (readline(prompt = "Enter no of students: "))
usn <-vector(mode="character", length=n)
marks <-vector(mode="integer", length = n)
name <- vector(mode="character", length = n)

for(i in 1:n) {
  name[i] <- (readline(prompt = "Enter name: "))
  usn[i] <- (readline(prompt="Enter USN: "))
  marks[i] <- (readline(prompt="Enter Marks: "))
}
student <- data.frame(usn, name, marks)
age <- vector(mode = "integer", length=n)

for(i in 1:n) {
  age[i] <- (readline(prompt="Enter Age: "))
}
student <- cbind(student, age)
print(student)
for(i in 1:n) {
  if(student[i,][4] < 20 && student[i,][3] > 25) {
    print(student[i,])
  }
}