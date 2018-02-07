maxNum = 4000000
sum = 0
first = 0
second = 1
nextNum = first + second

while nextNum <= maxNum:
    if nextNum % 2 == 0:
        sum += nextNum
    first, second = second, nextNum
    nextNum = first + second

print(sum)
