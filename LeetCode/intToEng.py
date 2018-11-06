def transfer(num):
    fix = {
        "digit": ["zero", "one ", "two ", "three ", "four ", "five ", "six ",
                  "seven ", "eight ", "nine ", "ten ", "eleven ", "twelve ",
                  "thirteen ", "fourteen ", "fifteen ", "sixteen ",
                  "seventeen ", "eighteen ", "nineteen "],
        10: ["", "ten", "twenty ", "thirty ", "fourty ", "fifty ",
             "sixty ", "seventy ", "eighty ", "ninety "],
        100: "hundred ",
        1000: "thousand "
    }
    result = ""
    count = 100
    more = 0
    if (num >= 100):
        more = num / 100
        num %= 100
    if (num < 20 and num > 0):
        result += fix["digit"][num]
    elif (num < 100 and num > 0):
        result += fix[10][num / 10]
        if (num % 10 != 0):
            result += fix["digit"][num % 10]
    while (more):
        reminder = more % 10
        more /= 10
        if (reminder):
            result = fix["digit"][reminder] + fix[count] + result
        count *= 10

    print(result)


transfer(1234)
