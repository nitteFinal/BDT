data()
head(mtcars)

rownum=nrow(mtcars)
colnum=ncol(mtcars)
print(paste("Rows:",rownum))
print(paste("Columns:",colnum))

x=data.frame(mtcars)
print(x)
automatic=0
manual=0

for (i in 1:rownum) {
  ifelse((x[i,9]==1),(automatic=automatic+1),(manual=manual+1))
}
ifelse((automatic>manual),print("More AUtomatic Cars Less Manual Car"),print("Less Automatic Cars More Manual Cars"))

hp=x[,4]
wt=x[,6]  
scatter.smooth(hp,wt,span = 2/3,degree = 1,family = c('symmetric','gaussian'))
x[,2]=as.integer(x[,2])
x[,8]=as.integer(x[,8])
x[,9]=as.integer(x[,9])

newmtc=data.frame(x[,2],x[,8],x[,9])
print(newmtc)

for (i in 1:rownum)
  if ((mtcars$cyl[i]<=5)==TRUE)
    print(mtcars[i,-1])