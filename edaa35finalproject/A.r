confidence_interval <- function(x, confidence_level = 0.95) {
  n <- length(x)
  alpha <- 1 - confidence_level
  if (n < 30) {
    stat <- qt(1 - alpha / 2, n - 1)
  } else {
    stat <- qnorm(1 - alpha / 2)
  }
  interval <- stat * sd(x) / sqrt(n)
  mean_value <- mean(x)
  result <- c(mean_value - interval, mean_value + interval)
  names(result) <- c("lower", "upper")
  result
}

plotresult <- function(file, start = 1) {
  data <- read.csv(file)
  data <- data[start:nrow(data), ]
  plot(data, type = "l")
}

calc_confidence_interval <- function(data1) {
  print(confidence_interval(data1))
}

calc_t_test <- function(data1, data2) {
  print(t.test(data1, data2))
}

AOE <- 475

data1 <- read.csv("AsortResult1.txt", header = TRUE)
data1 <- data1[-(1:AOE), ]$Time
data2 <- read.csv("AsortResult2.txt", header = TRUE)
data2 <- data2[-(1:AOE), ]$Time
data3 <- read.csv("AsortResult3.txt", header = TRUE)
data3 <- data3[-(1:AOE), ]$Time
data4 <- read.csv("AsortResult4.txt", header = TRUE)
data4 <- data4[-(1:AOE), ]$Time
data5 <- read.csv("AsortResult5.txt", header = TRUE)
data5 <- data5[-(1:AOE), ]$Time

all_data <- data.frame(data1, data2, data3, data4, data5)

v <- c()
for (i in 1:(600 - AOE)) {
  sum <- 0
  for (x in all_data) {
    sum <- sum + x[i]
  }
  sum <- sum / 5
  v <- c(v, sum)
}



# print(mean(v))
# calc_confidence_interval(v)

# for (x in v) {
#   write.csv(x, file = "output.txt", append = TRUE, sep = "\n")
# }



# png("Q_sort_1.png")
# plotresult("QsortResult1.txt")
# dev.off()
