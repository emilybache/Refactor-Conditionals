
def deMorgan(x):
    return not (x != 5 and x != 7)
    # return x==5 or x==7


def split(x, y):
    if x == 3 and y == 4:
        return x + y
    else:
        return 0


def join(x, y):
    if x == 3:
        if y == 4:
            return x + y
    return 0


def split_statements(x, y):
    result = 0
    factor = 1
    if x > 3:
        result += y * 3
        factor = x

    return result * factor


def join_statements(x, y):
    result = 0
    factor = 1
    if x > 3:
        factor = x

    if x > 3:
        result += y * 3

    return result * factor


def redundant_else(x):
    if x < 3:
        return 1
    elif x < 10:
        return 10
    if x < 30:
        return 30
    return 0


def invert(x):
    if x != 3:
        return 3
    else:
        return 4

# endif //EXAMPLECONDITIONALS_H
