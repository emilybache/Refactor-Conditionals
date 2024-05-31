def lift_up_conditional(a, b):
    if a:
        if b:
            return a_true_b_true()
        else:
            return a_true_b_false()
    else:
        if b:
            return a_false_b_true()
        else:
            return a_false_b_false()


def a_false_b_false():
    return "AFalseBFalse"


def a_false_b_true():
    return "AFalseBTrue"


def a_true_b_false():
    return "ATrueBFalse"


def a_true_b_true():
    return "ATrueBTrue"


def hello_world(s1, s2):
    if s1 != "hello":
        if s2 != "world":
            if s1 != "foo":
                return 6
            return 1
        elif s1 != "foo":
            return 2
    else:
        if s2 == "bar":
            return 3
        elif s2 != "world":
            return 4
        return 5
    return 0
