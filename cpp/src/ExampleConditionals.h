
#ifndef EXAMPLECONDITIONALS_H
#define EXAMPLECONDITIONALS_H


static bool deMorgan(int x) {
    return !(x!=5 && x!=7);
    //return x==5 || x==7;
}

static int split(int x, int y) {
    if (x == 3 && y == 4) {
        return x+y;
    } else {
        return 0;
    }
}

static int join(int x, int y) {
    if (x == 3) {
        if (y == 4) {
            return x + y;
        }
    }
    return 0;
}

static int split_statements(int x, int y) {
    int result = 0;
    int factor = 1;
    if (x > 3) {
        result += y*3;
        factor = x;
    }
    return result*factor;
}

static int join_statements(int x, int y) {
    int result = 0;
    int factor = 1;
    if (x > 3) {
        factor = x;
    }
    if (x > 3) {
        result += y*3;
    }
    return result*factor;
}

static int redundant_else(int x) {
    if (x < 3) {
        return 1;
    } else if (x < 10) {
        return 10;
    }
    if (x < 30) {
        return 30;
    }
    return 0;
}

static int invert(int x) {
    if (x != 3) {
        return 3;
    } else {
        return 4;
    }
}

#endif //EXAMPLECONDITIONALS_H
