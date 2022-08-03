df= airquality
dim(df)

sapply(df, class)

which(is.na(df))
sum(is.na(df))
x=colSums(is.na(df))
print(x)

for (i in 1:6){
  df[,i]=ifelse ((is.na(df[,i])), (mean(df[,i],na.rm=TRUE)),(df[,i]))
}
print(df)

df2=na.omit(df)
print(df2)