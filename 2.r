n <- as.integer(readline(prompt = "Enter total number: "))
id <- vector(mode="numeric", length=n)
name <- vector(mode="character", length=n)
doj <- vector(mode="numeric", length=n)
dept <- vector(mode="character", length =n)
des <- vector(mode="character", length=n)

for(i in 1:n) {
  id[i]=i
  name[i] = as.character(readline(prompt="Enter name: "))
  doj[i] = as.integer(readline(prompt="Enter date of joining: "))
  dept[i] = as.character(readline(prompt = "Enter Dept: "))
  des[i] = as.character(readline(prompt="Enter des: "))
}
df = data.frame(id, name, doj, dept, des)
print(df)
write.csv(df, "/home/ubuntu/Dev/bdtLab/exam.csv")
df1 = read.csv("/home/ubuntu/Dev/bdtLab/exam.csv")
print(df1)
x <- data.frame(id=3, name="Stuti", doj=2021, dept="CSE", des="Prof.")
write.table(x, file="/home/ubuntu/Dev/bdtLab/exam.csv", append = TRUE, row.names = TRUE,col.names = FALSE, quote=FALSE, sep = ",")
